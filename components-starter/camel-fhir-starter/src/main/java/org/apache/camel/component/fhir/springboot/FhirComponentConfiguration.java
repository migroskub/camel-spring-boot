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
package org.apache.camel.component.fhir.springboot;

import javax.annotation.Generated;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.api.IRestfulClientFactory;
import org.apache.camel.component.fhir.FhirConfiguration;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;

/**
 * Exchange information in the healthcare domain using the FHIR (Fast Healthcare
 * Interoperability Resources) standard.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.springboot.maven.SpringBootAutoConfigurationMojo")
@ConfigurationProperties(prefix = "camel.component.fhir")
public class FhirComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the fhir component. This is
     * enabled by default.
     */
    private Boolean enabled;
    /**
     * Encoding to use for all request
     */
    private String encoding;
    /**
     * The FHIR Version to use
     */
    private String fhirVersion = "R4";
    /**
     * Will log every requests and responses
     */
    private Boolean log = false;
    /**
     * Pretty print all request
     */
    private Boolean prettyPrint = false;
    /**
     * The FHIR server base URL
     */
    private String serverUrl;
    /**
     * Allows for bridging the consumer to the Camel routing Error Handler,
     * which mean any exceptions occurred while the consumer is trying to pickup
     * incoming messages, or the likes, will now be processed as a message and
     * handled by the routing Error Handler. By default the consumer will use
     * the org.apache.camel.spi.ExceptionHandler to deal with exceptions, that
     * will be logged at WARN or ERROR level and ignored.
     */
    private Boolean bridgeErrorHandler = false;
    /**
     * Whether the producer should be started lazy (on the first message). By
     * starting lazy you can use this to allow CamelContext and routes to
     * startup in situations where a producer may otherwise fail during starting
     * and cause the route to fail being started. By deferring this startup to
     * be lazy then the startup failure can be handled during routing messages
     * via Camel's routing error handlers. Beware that when the first message is
     * processed then creating and starting the producer may take a little time
     * and prolong the total processing time of the processing.
     */
    private Boolean lazyStartProducer = false;
    /**
     * Whether the component should use basic property binding (Camel 2.x) or
     * the newer property binding with additional capabilities
     */
    @Deprecated
    private Boolean basicPropertyBinding = false;
    /**
     * To use the custom client. The option is a
     * ca.uhn.fhir.rest.client.api.IGenericClient type.
     */
    private IGenericClient client;
    /**
     * To use the custom client factory. The option is a
     * ca.uhn.fhir.rest.client.api.IRestfulClientFactory type.
     */
    private IRestfulClientFactory clientFactory;
    /**
     * Compresses outgoing (POST/PUT) contents to the GZIP format
     */
    private Boolean compress = false;
    /**
     * To use the shared configuration. The option is a
     * org.apache.camel.component.fhir.FhirConfiguration type.
     */
    private FhirConfiguration configuration;
    /**
     * How long to try and establish the initial TCP connection (in ms)
     */
    private Integer connectionTimeout = 10000;
    /**
     * When this option is set, model classes will not be scanned for children
     * until the child list for the given type is actually accessed.
     */
    private Boolean deferModelScanning = false;
    /**
     * FhirContext is an expensive object to create. To avoid creating multiple
     * instances, it can be set directly. The option is a
     * ca.uhn.fhir.context.FhirContext type.
     */
    private FhirContext fhirContext;
    /**
     * Force conformance check
     */
    private Boolean forceConformanceCheck = false;
    /**
     * HTTP session cookie to add to every request
     */
    private String sessionCookie;
    /**
     * How long to block for individual read/write operations (in ms)
     */
    private Integer socketTimeout = 10000;
    /**
     * Request that the server modify the response using the _summary param
     */
    private String summary;
    /**
     * When should Camel validate the FHIR Server's conformance statement
     */
    private String validationMode = "ONCE";
    /**
     * The proxy host
     */
    private String proxyHost;
    /**
     * The proxy password
     */
    private String proxyPassword;
    /**
     * The proxy port
     */
    private Integer proxyPort;
    /**
     * The proxy username
     */
    private String proxyUser;
    /**
     * OAuth access token
     */
    private String accessToken;
    /**
     * Username to use for basic authentication
     */
    private String password;
    /**
     * Username to use for basic authentication
     */
    private String username;

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getFhirVersion() {
        return fhirVersion;
    }

    public void setFhirVersion(String fhirVersion) {
        this.fhirVersion = fhirVersion;
    }

    public Boolean getLog() {
        return log;
    }

    public void setLog(Boolean log) {
        this.log = log;
    }

    public Boolean getPrettyPrint() {
        return prettyPrint;
    }

    public void setPrettyPrint(Boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public Boolean getBridgeErrorHandler() {
        return bridgeErrorHandler;
    }

    public void setBridgeErrorHandler(Boolean bridgeErrorHandler) {
        this.bridgeErrorHandler = bridgeErrorHandler;
    }

    public Boolean getLazyStartProducer() {
        return lazyStartProducer;
    }

    public void setLazyStartProducer(Boolean lazyStartProducer) {
        this.lazyStartProducer = lazyStartProducer;
    }

    @Deprecated
    @DeprecatedConfigurationProperty
    public Boolean getBasicPropertyBinding() {
        return basicPropertyBinding;
    }

    @Deprecated
    public void setBasicPropertyBinding(Boolean basicPropertyBinding) {
        this.basicPropertyBinding = basicPropertyBinding;
    }

    public IGenericClient getClient() {
        return client;
    }

    public void setClient(IGenericClient client) {
        this.client = client;
    }

    public IRestfulClientFactory getClientFactory() {
        return clientFactory;
    }

    public void setClientFactory(IRestfulClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public Boolean getCompress() {
        return compress;
    }

    public void setCompress(Boolean compress) {
        this.compress = compress;
    }

    public FhirConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(FhirConfiguration configuration) {
        this.configuration = configuration;
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public Boolean getDeferModelScanning() {
        return deferModelScanning;
    }

    public void setDeferModelScanning(Boolean deferModelScanning) {
        this.deferModelScanning = deferModelScanning;
    }

    public FhirContext getFhirContext() {
        return fhirContext;
    }

    public void setFhirContext(FhirContext fhirContext) {
        this.fhirContext = fhirContext;
    }

    public Boolean getForceConformanceCheck() {
        return forceConformanceCheck;
    }

    public void setForceConformanceCheck(Boolean forceConformanceCheck) {
        this.forceConformanceCheck = forceConformanceCheck;
    }

    public String getSessionCookie() {
        return sessionCookie;
    }

    public void setSessionCookie(String sessionCookie) {
        this.sessionCookie = sessionCookie;
    }

    public Integer getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getValidationMode() {
        return validationMode;
    }

    public void setValidationMode(String validationMode) {
        this.validationMode = validationMode;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getProxyUser() {
        return proxyUser;
    }

    public void setProxyUser(String proxyUser) {
        this.proxyUser = proxyUser;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}