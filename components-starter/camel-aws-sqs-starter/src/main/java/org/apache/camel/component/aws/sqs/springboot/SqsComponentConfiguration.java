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
package org.apache.camel.component.aws.sqs.springboot;

import javax.annotation.Generated;
import com.amazonaws.Protocol;
import com.amazonaws.services.sqs.AmazonSQS;
import org.apache.camel.component.aws.sqs.SqsComponent;
import org.apache.camel.component.aws.sqs.SqsConfiguration;
import org.apache.camel.component.aws.sqs.SqsOperations;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;

/**
 * Sending and receive messages to/from AWS SQS service.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.springboot.maven.SpringBootAutoConfigurationMojo")
@ConfigurationProperties(prefix = "camel.component.aws-sqs")
public class SqsComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the aws-sqs component. This is
     * enabled by default.
     */
    private Boolean enabled;
    /**
     * The hostname of the Amazon AWS cloud.
     */
    private String amazonAWSHost = "amazonaws.com";
    /**
     * To use the AmazonSQS as client. The option is a
     * com.amazonaws.services.sqs.AmazonSQS type.
     */
    private AmazonSQS amazonSQSClient;
    /**
     * Setting the autocreation of the queue
     */
    private Boolean autoCreateQueue = true;
    /**
     * Setting the autoDiscoverClient mechanism, if true, the component will
     * look for a client instance in the registry automatically otherwise it
     * will skip that checking.
     */
    private Boolean autoDiscoverClient = true;
    /**
     * The component configuration. The option is a
     * org.apache.camel.component.aws.sqs.SqsConfiguration type.
     */
    private SqsConfiguration configuration;
    /**
     * The underlying protocol used to communicate with SQS
     */
    private String protocol = "https";
    /**
     * To define a proxy protocol when instantiating the SQS client
     */
    private Protocol proxyProtocol = Protocol.HTTPS;
    /**
     * Specify the queue owner aws account id when you need to connect the queue
     * with different account owner.
     */
    private String queueOwnerAWSAccountId;
    /**
     * Specify the queue region which could be used with queueOwnerAWSAccountId
     * to build the service URL. When using this parameter, the configuration
     * will expect the capitalized name of the region (for example AP_EAST_1)
     * You'll need to use the name Regions.EU_WEST_1.name()
     */
    private String region;
    /**
     * A list of attribute names to receive when consuming. Multiple names can
     * be separated by comma.
     */
    private String attributeNames;
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
     * Allows you to use multiple threads to poll the sqs queue to increase
     * throughput
     */
    private Integer concurrentConsumers = 1;
    /**
     * The default visibility timeout (in seconds)
     */
    private Integer defaultVisibilityTimeout;
    /**
     * Delete message from SQS after it has been read
     */
    private Boolean deleteAfterRead = true;
    /**
     * Whether or not to send the DeleteMessage to the SQS queue if an exchange
     * fails to get through a filter. If 'false' and exchange does not make it
     * through a Camel filter upstream in the route, then don't send
     * DeleteMessage.
     */
    private Boolean deleteIfFiltered = true;
    /**
     * If enabled then a scheduled background task will keep extending the
     * message visibility on SQS. This is needed if it takes a long time to
     * process the message. If set to true defaultVisibilityTimeout must be set.
     * See details at Amazon docs.
     */
    private Boolean extendMessageVisibility = false;
    /**
     * The length of time, in seconds, for which Amazon SQS can reuse a data key
     * to encrypt or decrypt messages before calling AWS KMS again. An integer
     * representing seconds, between 60 seconds (1 minute) and 86,400 seconds
     * (24 hours). Default: 300 (5 minutes).
     */
    private Integer kmsDataKeyReusePeriodSeconds;
    /**
     * The ID of an AWS-managed customer master key (CMK) for Amazon SQS or a
     * custom CMK.
     */
    private String kmsMasterKeyId;
    /**
     * A list of message attribute names to receive when consuming. Multiple
     * names can be separated by comma.
     */
    private String messageAttributeNames;
    /**
     * Define if Server Side Encryption is enabled or not on the queue
     */
    private Boolean serverSideEncryptionEnabled = false;
    /**
     * The duration (in seconds) that the received messages are hidden from
     * subsequent retrieve requests after being retrieved by a ReceiveMessage
     * request to set in the
     * com.amazonaws.services.sqs.model.SetQueueAttributesRequest. This only
     * make sense if its different from defaultVisibilityTimeout. It changes the
     * queue visibility timeout attribute permanently.
     */
    private Integer visibilityTimeout;
    /**
     * Duration in seconds (0 to 20) that the ReceiveMessage action call will
     * wait until a message is in the queue to include in the response.
     */
    private Integer waitTimeSeconds;
    /**
     * Delay sending messages for a number of seconds.
     */
    private Integer delaySeconds;
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
     * Only for FIFO queues. Strategy for setting the messageDeduplicationId on
     * the message. Can be one of the following options: useExchangeId,
     * useContentBasedDeduplication. For the useContentBasedDeduplication
     * option, no messageDeduplicationId will be set on the message.
     */
    private String messageDeduplicationIdStrategy = "useExchangeId";
    /**
     * Only for FIFO queues. Strategy for setting the messageGroupId on the
     * message. Can be one of the following options: useConstant, useExchangeId,
     * usePropertyValue. For the usePropertyValue option, the value of property
     * CamelAwsMessageGroupId will be used.
     */
    private String messageGroupIdStrategy;
    /**
     * The operation to do in case the user don't want to send only a message
     */
    private SqsOperations operation;
    /**
     * Whether the component should use basic property binding (Camel 2.x) or
     * the newer property binding with additional capabilities
     */
    @Deprecated
    private Boolean basicPropertyBinding = false;
    /**
     * Define if you want to apply delaySeconds option to the queue or on single
     * messages
     */
    private Boolean delayQueue = false;
    /**
     * To define the queueUrl explicitly. All other parameters, which would
     * influence the queueUrl, are ignored. This parameter is intended to be
     * used, to connect to a mock implementation of SQS, for testing purposes.
     */
    private String queueUrl;
    /**
     * To define a proxy host when instantiating the SQS client
     */
    private String proxyHost;
    /**
     * To define a proxy port when instantiating the SQS client
     */
    private Integer proxyPort;
    /**
     * The maximumMessageSize (in bytes) an SQS message can contain for this
     * queue.
     */
    private Integer maximumMessageSize;
    /**
     * The messageRetentionPeriod (in seconds) a message will be retained by SQS
     * for this queue.
     */
    private Integer messageRetentionPeriod;
    /**
     * The policy for this queue
     */
    private String policy;
    /**
     * If you do not specify WaitTimeSeconds in the request, the queue attribute
     * ReceiveMessageWaitTimeSeconds is used to determine how long to wait.
     */
    private Integer receiveMessageWaitTimeSeconds;
    /**
     * Specify the policy that send message to DeadLetter queue. See detail at
     * Amazon docs.
     */
    private String redrivePolicy;
    /**
     * Amazon AWS Access Key
     */
    private String accessKey;
    /**
     * Amazon AWS Secret Key
     */
    private String secretKey;

    public String getAmazonAWSHost() {
        return amazonAWSHost;
    }

    public void setAmazonAWSHost(String amazonAWSHost) {
        this.amazonAWSHost = amazonAWSHost;
    }

    public AmazonSQS getAmazonSQSClient() {
        return amazonSQSClient;
    }

    public void setAmazonSQSClient(AmazonSQS amazonSQSClient) {
        this.amazonSQSClient = amazonSQSClient;
    }

    public Boolean getAutoCreateQueue() {
        return autoCreateQueue;
    }

    public void setAutoCreateQueue(Boolean autoCreateQueue) {
        this.autoCreateQueue = autoCreateQueue;
    }

    public Boolean getAutoDiscoverClient() {
        return autoDiscoverClient;
    }

    public void setAutoDiscoverClient(Boolean autoDiscoverClient) {
        this.autoDiscoverClient = autoDiscoverClient;
    }

    public SqsConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(SqsConfiguration configuration) {
        this.configuration = configuration;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Protocol getProxyProtocol() {
        return proxyProtocol;
    }

    public void setProxyProtocol(Protocol proxyProtocol) {
        this.proxyProtocol = proxyProtocol;
    }

    public String getQueueOwnerAWSAccountId() {
        return queueOwnerAWSAccountId;
    }

    public void setQueueOwnerAWSAccountId(String queueOwnerAWSAccountId) {
        this.queueOwnerAWSAccountId = queueOwnerAWSAccountId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAttributeNames() {
        return attributeNames;
    }

    public void setAttributeNames(String attributeNames) {
        this.attributeNames = attributeNames;
    }

    public Boolean getBridgeErrorHandler() {
        return bridgeErrorHandler;
    }

    public void setBridgeErrorHandler(Boolean bridgeErrorHandler) {
        this.bridgeErrorHandler = bridgeErrorHandler;
    }

    public Integer getConcurrentConsumers() {
        return concurrentConsumers;
    }

    public void setConcurrentConsumers(Integer concurrentConsumers) {
        this.concurrentConsumers = concurrentConsumers;
    }

    public Integer getDefaultVisibilityTimeout() {
        return defaultVisibilityTimeout;
    }

    public void setDefaultVisibilityTimeout(Integer defaultVisibilityTimeout) {
        this.defaultVisibilityTimeout = defaultVisibilityTimeout;
    }

    public Boolean getDeleteAfterRead() {
        return deleteAfterRead;
    }

    public void setDeleteAfterRead(Boolean deleteAfterRead) {
        this.deleteAfterRead = deleteAfterRead;
    }

    public Boolean getDeleteIfFiltered() {
        return deleteIfFiltered;
    }

    public void setDeleteIfFiltered(Boolean deleteIfFiltered) {
        this.deleteIfFiltered = deleteIfFiltered;
    }

    public Boolean getExtendMessageVisibility() {
        return extendMessageVisibility;
    }

    public void setExtendMessageVisibility(Boolean extendMessageVisibility) {
        this.extendMessageVisibility = extendMessageVisibility;
    }

    public Integer getKmsDataKeyReusePeriodSeconds() {
        return kmsDataKeyReusePeriodSeconds;
    }

    public void setKmsDataKeyReusePeriodSeconds(
            Integer kmsDataKeyReusePeriodSeconds) {
        this.kmsDataKeyReusePeriodSeconds = kmsDataKeyReusePeriodSeconds;
    }

    public String getKmsMasterKeyId() {
        return kmsMasterKeyId;
    }

    public void setKmsMasterKeyId(String kmsMasterKeyId) {
        this.kmsMasterKeyId = kmsMasterKeyId;
    }

    public String getMessageAttributeNames() {
        return messageAttributeNames;
    }

    public void setMessageAttributeNames(String messageAttributeNames) {
        this.messageAttributeNames = messageAttributeNames;
    }

    public Boolean getServerSideEncryptionEnabled() {
        return serverSideEncryptionEnabled;
    }

    public void setServerSideEncryptionEnabled(
            Boolean serverSideEncryptionEnabled) {
        this.serverSideEncryptionEnabled = serverSideEncryptionEnabled;
    }

    public Integer getVisibilityTimeout() {
        return visibilityTimeout;
    }

    public void setVisibilityTimeout(Integer visibilityTimeout) {
        this.visibilityTimeout = visibilityTimeout;
    }

    public Integer getWaitTimeSeconds() {
        return waitTimeSeconds;
    }

    public void setWaitTimeSeconds(Integer waitTimeSeconds) {
        this.waitTimeSeconds = waitTimeSeconds;
    }

    public Integer getDelaySeconds() {
        return delaySeconds;
    }

    public void setDelaySeconds(Integer delaySeconds) {
        this.delaySeconds = delaySeconds;
    }

    public Boolean getLazyStartProducer() {
        return lazyStartProducer;
    }

    public void setLazyStartProducer(Boolean lazyStartProducer) {
        this.lazyStartProducer = lazyStartProducer;
    }

    public String getMessageDeduplicationIdStrategy() {
        return messageDeduplicationIdStrategy;
    }

    public void setMessageDeduplicationIdStrategy(
            String messageDeduplicationIdStrategy) {
        this.messageDeduplicationIdStrategy = messageDeduplicationIdStrategy;
    }

    public String getMessageGroupIdStrategy() {
        return messageGroupIdStrategy;
    }

    public void setMessageGroupIdStrategy(String messageGroupIdStrategy) {
        this.messageGroupIdStrategy = messageGroupIdStrategy;
    }

    public SqsOperations getOperation() {
        return operation;
    }

    public void setOperation(SqsOperations operation) {
        this.operation = operation;
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

    public Boolean getDelayQueue() {
        return delayQueue;
    }

    public void setDelayQueue(Boolean delayQueue) {
        this.delayQueue = delayQueue;
    }

    public String getQueueUrl() {
        return queueUrl;
    }

    public void setQueueUrl(String queueUrl) {
        this.queueUrl = queueUrl;
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

    public Integer getMaximumMessageSize() {
        return maximumMessageSize;
    }

    public void setMaximumMessageSize(Integer maximumMessageSize) {
        this.maximumMessageSize = maximumMessageSize;
    }

    public Integer getMessageRetentionPeriod() {
        return messageRetentionPeriod;
    }

    public void setMessageRetentionPeriod(Integer messageRetentionPeriod) {
        this.messageRetentionPeriod = messageRetentionPeriod;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public Integer getReceiveMessageWaitTimeSeconds() {
        return receiveMessageWaitTimeSeconds;
    }

    public void setReceiveMessageWaitTimeSeconds(
            Integer receiveMessageWaitTimeSeconds) {
        this.receiveMessageWaitTimeSeconds = receiveMessageWaitTimeSeconds;
    }

    public String getRedrivePolicy() {
        return redrivePolicy;
    }

    public void setRedrivePolicy(String redrivePolicy) {
        this.redrivePolicy = redrivePolicy;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}