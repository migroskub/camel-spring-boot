/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.springboot.springdoc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import io.apicurio.datamodels.openapi.models.OasDocument;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import org.apache.camel.CamelContext;
import org.apache.camel.model.rest.RestDefinition;
import org.apache.camel.openapi.BeanConfig;
import org.apache.camel.openapi.DefaultRestDefinitionsResolver;
import org.apache.camel.openapi.RestDefinitionsResolver;
import org.apache.camel.openapi.RestOpenApiReader;
import org.apache.camel.spi.RestConfiguration;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.apache.camel.openapi.OpenApiHelper.clearVendorExtensions;

/**
 * Springdoc auto-configuration.
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({SpringdocConfiguration.class})
@ConditionalOnBean(type = "org.apache.camel.spring.boot.CamelAutoConfiguration")
@ConditionalOnProperty(name = "camel.springdoc.enabled", matchIfMissing = true)
@AutoConfigureAfter(name = "org.apache.camel.spring.boot.CamelAutoConfiguration")
@AutoConfigureBefore(name = "org.springdoc.core.SpringdocConfiguration")
public class SpringdocAutoConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(SpringdocAutoConfiguration.class);

    private final RestOpenApiReader reader = new RestOpenApiReader();
    private final RestDefinitionsResolver resolver = new DefaultRestDefinitionsResolver();
    private final OpenAPI openapi = new OpenAPI();

    @Bean
    CamelContextConfiguration springdocOnBeforeStart(final GenericApplicationContext ac, final CamelContext camelContext, final SpringdocConfiguration config) {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(final CamelContext camelContext) {
                // routes have now been loaded, so we need to detect rest-dsl APIs in Camel
                // this will trigger spring boot to create the bean which springdoc can detect
                try {
                    Optional.ofNullable(createOpenAPI(camelContext))
                            .ifPresent(created -> {
                                LOG.info("OpenAPI ({}) created from Camel Rest-DSL v{} - {}",
                                        created.getOpenapi(), created.getInfo().getVersion(), created.getInfo().getTitle());
                                // transfer data to the existing OpenAPI instance
                                Optional.ofNullable(created.getInfo()).ifPresent(openapi::setInfo);
                                Optional.ofNullable(created.getOpenapi()).ifPresent(openapi::setOpenapi);
                                Optional.ofNullable(created.getComponents()).ifPresent(openapi::setComponents);
                                Optional.ofNullable(created.getExtensions()).ifPresent(openapi::setExtensions);
                                Optional.ofNullable(created.getSecurity()).ifPresent(openapi::setSecurity);
                                Optional.ofNullable(created.getExternalDocs()).ifPresent(openapi::setExternalDocs);
                                Optional.ofNullable(created.getPaths()).ifPresent(openapi::setPaths);
                                Optional.ofNullable(created.getTags()).ifPresent(openapi::setTags);
                                // Note: do not copy servers, since we use the spring-boot configured setting
                            });
                } catch (Exception e) {
                    LOG.warn("Error generating OpenAPI from Camel Rest DSL due to: {}. This exception is ignored.", e.getMessage(), e);
                }
            }

            @Override
            public void afterApplicationStart(final CamelContext camelContext) {
                // noop
            }
        };
    }

    @Bean
    OpenAPI camelRestDSLOpenApi() {
        // due to ordering how beans are resolved and setup in spring boot, then we need to create
        // this provisional bean which is later updated with the actual Rest DSL APIs after the routes has been loaded
        // into Camel
        return openapi;
    }

    private OpenAPI createOpenAPI(final CamelContext camelContext) throws Exception {
        final List<RestDefinition> rests = resolver.getRestDefinitions(camelContext, null);
        if (rests == null || rests.isEmpty()) {
            return null;
        }

        final BeanConfig bc = new BeanConfig();
        final Info info = new Info();

        final RestConfiguration rc = camelContext.getRestConfiguration();
        initOpenApi(bc, info, rc.getApiProperties());

        final OasDocument openApi = reader.read(camelContext, rests, bc, null, camelContext.getClassResolver());
        if (!rc.isApiVendorExtension()) {
            clearVendorExtensions(openApi);
        }

        // dump to json
        final ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        final Object dump = io.apicurio.datamodels.Library.writeNode(openApi);
        final byte[] jsonData = mapper.writeValueAsBytes(dump);
        // json to yaml
        final JsonNode node = mapper.readTree(jsonData);
        final String yaml = new YAMLMapper().writeValueAsString(node);

        // parse bytes into swagger
        return Optional.ofNullable(new OpenAPIV3Parser().readContents(yaml))
                .map(SwaggerParseResult::getOpenAPI)
                .map(a -> a.info(info))
                .orElse(null);
    }

    /**
     * This consumes a property object, if non-null, by converting it to a string and running the given
     * string consumer on the value.
     */
    private static final BiConsumer<Object, Consumer<String>> consumeProperty = (a, b) ->
            Optional.ofNullable(a)
                    .map(String.class::cast)
                    .ifPresent(b);

    private static void initOpenApi(BeanConfig bc, Info info, Map<String, Object> config) {
        // configure openApi options
        consumeProperty.accept(config.get("openapi.version"), bc::setVersion);
        consumeProperty.accept(config.get("base.path"), bc::setBasePath);
        consumeProperty.accept(config.get("host"), bc::setHost);
        consumeProperty.accept(config.get("api.version"), info::setVersion);
        consumeProperty.accept(config.get("api.description"), info::setDescription);
        consumeProperty.accept(config.get("api.termsOfService"), info::setTermsOfService);
        consumeProperty.accept(config.get("api.license.name"), bc::setLicense);
        consumeProperty.accept(config.get("api.license.url"), bc::setLicenseUrl);
        consumeProperty.accept(config.get("api.title"), s -> {
            bc.setTitle(s);
            info.setTitle(s);
        });
        Optional.of(config.getOrDefault("schemes", config.getOrDefault("schemas", "http")))
                .map(String.class::cast)
                .map(v -> v.split(","))
                .ifPresent(bc::setSchemes);
        Optional.ofNullable(config.get("api.contact.name"))
                .map(String.class::cast)
                .map(name -> new Contact()
                        .name(name)
                        .email((String) config.get("api.contact.email"))
                        .url((String) config.get("api.contact.url")))
                .ifPresent(info::setContact);
    }
}
