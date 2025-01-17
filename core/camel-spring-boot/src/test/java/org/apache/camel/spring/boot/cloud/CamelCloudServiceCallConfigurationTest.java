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
package org.apache.camel.spring.boot.cloud;

import java.util.List;
import java.util.Map;
import org.apache.camel.cloud.ServiceChooser;
import org.apache.camel.cloud.ServiceDefinition;
import org.apache.camel.cloud.ServiceDiscovery;
import org.apache.camel.cloud.ServiceFilter;
import org.apache.camel.cloud.ServiceLoadBalancer;
import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CamelCloudServiceCallConfigurationTest {
    @Test
    public void testConfiguration() {
        new ApplicationContextRunner()
            .withConfiguration(
                AutoConfigurations.of(
                        CamelAutoConfiguration.class,
                        CamelCloudAutoConfiguration.class,
                        CamelCloudServiceChooserAutoConfiguration.class
                )
            )
            .withPropertyValues(
                    "camel.cloud.enabled=false",
                    "camel.cloud.service-discovery.enabled=false",
                    "camel.cloud.service-filter.enabled=false",
                    "camel.cloud.service-chooser.enabled=true",
                    "camel.cloud.load-balancer.enabled=false",
                    "debug=false"
            )
            .run(context -> {
                    Environment env = context.getEnvironment();
                    assertFalse(env.getProperty("camel.cloud.enabled", Boolean.class));
                    assertFalse(env.getProperty("camel.cloud.service-discovery.enabled", Boolean.class));
                    assertFalse(env.getProperty("camel.cloud.service-filter.enabled", Boolean.class));
                    assertTrue(env.getProperty("camel.cloud.service-chooser.enabled", Boolean.class));
                    assertFalse(env.getProperty("camel.cloud.load-balancer.enabled", Boolean.class));

                    assertTrue(context.getBeansOfType(ServiceDiscovery.class).isEmpty());
                    assertTrue(context.getBeansOfType(ServiceFilter.class).isEmpty());
                    assertTrue(context.getBeansOfType(ServiceChooser.class).isEmpty());
                    assertTrue(context.getBeansOfType(ServiceLoadBalancer.class).isEmpty());

                }
            );
    }

    @Test
    public void testStaticServiceDiscoveryConfigurationWithMetadata() {
      new ApplicationContextRunner()
          .withConfiguration(
              AutoConfigurations.of(
                  CamelAutoConfiguration.class,
                  CamelCloudAutoConfiguration.class,
                  CamelCloudServiceChooserAutoConfiguration.class,
                  CamelCloudServiceDiscoveryAutoConfiguration.class
              )
          )
          .withPropertyValues(
              "camel.cloud.enabled=true",
              "camel.cloud.service-discovery.enabled=true",
              "camel.cloud.service-discovery.services.first-service[0]=service1-1:80",
              "camel.cloud.service-discovery.services.first-service[1]=service1-2:80",
              "camel.cloud.service-discovery.services.second-service[0]=service2-1:80",
              "camel.cloud.service-discovery.service-definitions.third-service-with-metadata[0].id=service3-0",
              "camel.cloud.service-discovery.service-definitions.third-service-with-metadata[0].host=service3",
              "camel.cloud.service-discovery.service-definitions.third-service-with-metadata[0].port=80",
              "camel.cloud.service-discovery.service-definitions.third-service-with-metadata[0].metadata.foo=bar",
              "camel.cloud.service-discovery.configurations.my-static-service-discovery.services.fourth-service[0]=service4-1:80",
              "camel.cloud.service-discovery.configurations.my-static-service-discovery.service-definitions.fifth-service-with-metadata[0].host=service5",
              "camel.cloud.service-discovery.configurations.my-static-service-discovery.service-definitions.fifth-service-with-metadata[0].port=80",
              "camel.cloud.service-discovery.configurations.my-static-service-discovery.service-definitions.fifth-service-with-metadata[0].metadata.baz=gnarf",
              "camel.cloud.service-filter.enabled=false",
              "camel.cloud.service-chooser.enabled=false",
              "camel.cloud.load-balancer.enabled=false",
              "debug=false"
          )
          .run(context -> {
                Map<String, ServiceDiscovery> serviceDiscoveryBeans = context.getBeansOfType(ServiceDiscovery.class);

                ServiceDiscovery staticServiceDiscovery = serviceDiscoveryBeans.get("static-service-discovery");
                assertEquals(2, staticServiceDiscovery.getServices("first-service").size());
                assertEquals(1, staticServiceDiscovery.getServices("second-service").size());
                List<ServiceDefinition> serviceDefinitionsWithMetadata = staticServiceDiscovery.getServices("third-service-with-metadata");
                assertEquals(1, serviceDefinitionsWithMetadata.size());
                ServiceDefinition serviceDefinition = serviceDefinitionsWithMetadata.get(0);
                assertEquals("third-service-with-metadata", serviceDefinition.getName());
                assertEquals("service3-0", serviceDefinition.getId());
                assertEquals("service3", serviceDefinition.getHost());
                assertEquals(80, serviceDefinition.getPort());
                assertEquals("bar", serviceDefinition.getMetadata().get("foo"));

                ServiceDiscovery myStaticServiceDiscovery = serviceDiscoveryBeans.get("my-static-service-discovery");
                assertEquals(myStaticServiceDiscovery.getServices("fourth-service").size(), 1);
                List<ServiceDefinition> services = myStaticServiceDiscovery.getServices("fifth-service-with-metadata");
                assertEquals(services.size(), 1);
                assertEquals(services.get(0).getMetadata().get("baz"), "gnarf");

              }
          );
    }

}
