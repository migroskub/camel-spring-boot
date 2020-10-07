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
package org.apache.camel.component.aws.iam.springboot;

import javax.annotation.Generated;
import com.amazonaws.Protocol;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import org.apache.camel.component.aws.iam.IAMComponent;
import org.apache.camel.component.aws.iam.IAMConfiguration;
import org.apache.camel.component.aws.iam.IAMOperations;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;

/**
 * Manage AWS IAM instances.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.springboot.maven.SpringBootAutoConfigurationMojo")
@ConfigurationProperties(prefix = "camel.component.aws-iam")
public class IAMComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the aws-iam component. This is
     * enabled by default.
     */
    private Boolean enabled;
    /**
     * Setting the autoDiscoverClient mechanism, if true, the component will
     * look for a client instance in the registry automatically otherwise it
     * will skip that checking.
     */
    private Boolean autoDiscoverClient = true;
    /**
     * Amazon AWS Access Key
     */
    private String accessKey;
    /**
     * The component configuration. The option is a
     * org.apache.camel.component.aws.iam.IAMConfiguration type.
     */
    private IAMConfiguration configuration;
    /**
     * To use a existing configured AWS IAM as client. The option is a
     * com.amazonaws.services.identitymanagement.AmazonIdentityManagement type.
     */
    private AmazonIdentityManagement iamClient;
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
     * The operation to perform
     */
    private IAMOperations operation;
    /**
     * To define a proxy host when instantiating the IAM client
     */
    private String proxyHost;
    /**
     * To define a proxy port when instantiating the IAM client
     */
    private Integer proxyPort;
    /**
     * To define a proxy protocol when instantiating the IAM client
     */
    private Protocol proxyProtocol = Protocol.HTTPS;
    /**
     * The region in which IAM client needs to work. When using this parameter,
     * the configuration will expect the capitalized name of the region (for
     * example AP_EAST_1) You'll need to use the name Regions.EU_WEST_1.name()
     */
    private String region;
    /**
     * Amazon AWS Secret Key
     */
    private String secretKey;
    /**
     * Whether the component should use basic property binding (Camel 2.x) or
     * the newer property binding with additional capabilities
     */
    @Deprecated
    private Boolean basicPropertyBinding = false;

    public Boolean getAutoDiscoverClient() {
        return autoDiscoverClient;
    }

    public void setAutoDiscoverClient(Boolean autoDiscoverClient) {
        this.autoDiscoverClient = autoDiscoverClient;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public IAMConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(IAMConfiguration configuration) {
        this.configuration = configuration;
    }

    public AmazonIdentityManagement getIamClient() {
        return iamClient;
    }

    public void setIamClient(AmazonIdentityManagement iamClient) {
        this.iamClient = iamClient;
    }

    public Boolean getLazyStartProducer() {
        return lazyStartProducer;
    }

    public void setLazyStartProducer(Boolean lazyStartProducer) {
        this.lazyStartProducer = lazyStartProducer;
    }

    public IAMOperations getOperation() {
        return operation;
    }

    public void setOperation(IAMOperations operation) {
        this.operation = operation;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    public Protocol getProxyProtocol() {
        return proxyProtocol;
    }

    public void setProxyProtocol(Protocol proxyProtocol) {
        this.proxyProtocol = proxyProtocol;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
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
}