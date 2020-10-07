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
package org.apache.camel.component.aws2.athena.springboot;

import javax.annotation.Generated;
import org.apache.camel.component.aws2.athena.Athena2Component;
import org.apache.camel.component.aws2.athena.Athena2Configuration;
import org.apache.camel.component.aws2.athena.Athena2Operations;
import org.apache.camel.component.aws2.athena.Athena2OutputType;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import software.amazon.awssdk.core.Protocol;
import software.amazon.awssdk.services.athena.AthenaClient;
import software.amazon.awssdk.services.athena.model.EncryptionOption;

/**
 * Access AWS Athena service using AWS SDK version 2.x.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.springboot.maven.SpringBootAutoConfigurationMojo")
@ConfigurationProperties(prefix = "camel.component.aws2-athena")
public class Athena2ComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the aws2-athena component. This
     * is enabled by default.
     */
    private Boolean enabled;
    /**
     * Amazon AWS Access Key.
     */
    private String accessKey;
    /**
     * The AmazonAthena instance to use as the client. The option is a
     * software.amazon.awssdk.services.athena.AthenaClient type.
     */
    private AthenaClient amazonAthenaClient;
    /**
     * Setting the autoDiscoverClient mechanism, if true, the component will
     * look for a client instance in the registry automatically otherwise it
     * will skip that checking
     */
    private Boolean autoDiscoverClient = true;
    /**
     * The component configuration. The option is a
     * org.apache.camel.component.aws2.athena.Athena2Configuration type.
     */
    private Athena2Configuration configuration;
    /**
     * The Athena database to use.
     */
    private String database;
    /**
     * Milliseconds before the next poll for query execution status. See the
     * section 'Waiting for Query Completion and Retrying Failed Queries' to
     * learn more.
     */
    private Long delay = 2000L;
    /**
     * The encryption type to use when storing query results in S3. One of
     * SSE_S3, SSE_KMS, or CSE_KMS.
     */
    private EncryptionOption encryptionOption;
    /**
     * Include useful trace information at the beginning of queries as an SQL
     * comment (prefixed with --).
     */
    private Boolean includeTrace = false;
    /**
     * Milliseconds before the first poll for query execution status. See the
     * section 'Waiting for Query Completion and Retrying Failed Queries' to
     * learn more.
     */
    private Long initialDelay = 1000L;
    /**
     * For SSE-KMS and CSE-KMS, this is the KMS key ARN or ID.
     */
    private String kmsKey;
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
     * Maximum number of times to attempt a query. Set to 1 to disable retries.
     * See the section 'Waiting for Query Completion and Retrying Failed
     * Queries' to learn more.
     */
    private Integer maxAttempts = 1;
    /**
     * Max number of results to return for the given operation (if supported by
     * the Athena API endpoint). If not set, will use the Athena API default for
     * the given operation.
     */
    private Integer maxResults;
    /**
     * Pagination token to use in the case where the response from the previous
     * request was truncated.
     */
    private String nextToken;
    /**
     * The Athena API function to call.
     */
    private Athena2Operations operation = Athena2Operations.startQueryExecution;
    /**
     * The location in Amazon S3 where query results are stored, such as
     * s3://path/to/query/bucket/. Ensure this value ends with a forward slash
     * ('/').
     */
    private String outputLocation;
    /**
     * How query results should be returned. One of StreamList (default - return
     * a GetQueryResultsIterable that can page through all results), SelectList
     * (returns at most 1,000 rows at a time, plus a NextToken value as a header
     * than can be used for manual pagination of results), S3Pointer (return an
     * S3 path pointing to the results).
     */
    private Athena2OutputType outputType = Athena2OutputType.StreamList;
    /**
     * To define a proxy host when instantiating the Athena client.
     */
    private String proxyHost;
    /**
     * To define a proxy port when instantiating the Athena client.
     */
    private Integer proxyPort;
    /**
     * To define a proxy protocol when instantiating the Athena client.
     */
    private Protocol proxyProtocol = Protocol.HTTPS;
    /**
     * The unique ID identifying the query execution.
     */
    private String queryExecutionId;
    /**
     * The SQL query to run. Except for simple queries, prefer setting this as
     * the body of the Exchange or as a header using
     * Athena2Constants.QUERY_STRING to avoid having to deal with URL encoding
     * issues.
     */
    private String queryString;
    /**
     * The region in which Athena client needs to work. When using this
     * parameter, the configuration will expect the lowercase name of the region
     * (for example ap-east-1). You'll need to use the name
     * Region.EU_WEST_1.id().
     */
    private String region;
    /**
     * Reset the waitTimeout countdown in the event of a query retry. If set to
     * true, potential max time spent waiting for queries is equal to
     * waitTimeout x maxAttempts. See the section 'Waiting for Query Completion
     * and Retrying Failed Queries' to learn more.
     */
    private Boolean resetWaitTimeoutOnRetry = true;
    /**
     * Optional comma separated list of error types to retry the query for. Use
     * 'retryable' to retry all retryable failure conditions (e.g. generic
     * errors and resources exhausted), 'generic' to retry
     * 'GENERIC_INTERNAL_ERROR' failures, 'exhausted' to retry queries that have
     * exhausted resource limits, 'always' to always retry regardless of failure
     * condition, or 'never' or null to never retry (default). See the section
     * 'Waiting for Query Completion and Retrying Failed Queries' to learn more.
     */
    private String retry = "never";
    /**
     * Amazon AWS Secret Key.
     */
    private String secretKey;
    /**
     * Optional max wait time in millis to wait for a successful query
     * completion. See the section 'Waiting for Query Completion and Retrying
     * Failed Queries' to learn more.
     */
    private Long waitTimeout = 0L;
    /**
     * The workgroup to use for running the query.
     */
    private String workGroup;
    /**
     * Whether the component should use basic property binding (Camel 2.x) or
     * the newer property binding with additional capabilities
     */
    @Deprecated
    private Boolean basicPropertyBinding = false;
    /**
     * A unique string to ensure issues queries are idempotent. It is unlikely
     * you will need to set this.
     */
    private String clientRequestToken;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public AthenaClient getAmazonAthenaClient() {
        return amazonAthenaClient;
    }

    public void setAmazonAthenaClient(AthenaClient amazonAthenaClient) {
        this.amazonAthenaClient = amazonAthenaClient;
    }

    public Boolean getAutoDiscoverClient() {
        return autoDiscoverClient;
    }

    public void setAutoDiscoverClient(Boolean autoDiscoverClient) {
        this.autoDiscoverClient = autoDiscoverClient;
    }

    public Athena2Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Athena2Configuration configuration) {
        this.configuration = configuration;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public Long getDelay() {
        return delay;
    }

    public void setDelay(Long delay) {
        this.delay = delay;
    }

    public EncryptionOption getEncryptionOption() {
        return encryptionOption;
    }

    public void setEncryptionOption(EncryptionOption encryptionOption) {
        this.encryptionOption = encryptionOption;
    }

    public Boolean getIncludeTrace() {
        return includeTrace;
    }

    public void setIncludeTrace(Boolean includeTrace) {
        this.includeTrace = includeTrace;
    }

    public Long getInitialDelay() {
        return initialDelay;
    }

    public void setInitialDelay(Long initialDelay) {
        this.initialDelay = initialDelay;
    }

    public String getKmsKey() {
        return kmsKey;
    }

    public void setKmsKey(String kmsKey) {
        this.kmsKey = kmsKey;
    }

    public Boolean getLazyStartProducer() {
        return lazyStartProducer;
    }

    public void setLazyStartProducer(Boolean lazyStartProducer) {
        this.lazyStartProducer = lazyStartProducer;
    }

    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(Integer maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public String getNextToken() {
        return nextToken;
    }

    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }

    public Athena2Operations getOperation() {
        return operation;
    }

    public void setOperation(Athena2Operations operation) {
        this.operation = operation;
    }

    public String getOutputLocation() {
        return outputLocation;
    }

    public void setOutputLocation(String outputLocation) {
        this.outputLocation = outputLocation;
    }

    public Athena2OutputType getOutputType() {
        return outputType;
    }

    public void setOutputType(Athena2OutputType outputType) {
        this.outputType = outputType;
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

    public String getQueryExecutionId() {
        return queryExecutionId;
    }

    public void setQueryExecutionId(String queryExecutionId) {
        this.queryExecutionId = queryExecutionId;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Boolean getResetWaitTimeoutOnRetry() {
        return resetWaitTimeoutOnRetry;
    }

    public void setResetWaitTimeoutOnRetry(Boolean resetWaitTimeoutOnRetry) {
        this.resetWaitTimeoutOnRetry = resetWaitTimeoutOnRetry;
    }

    public String getRetry() {
        return retry;
    }

    public void setRetry(String retry) {
        this.retry = retry;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Long getWaitTimeout() {
        return waitTimeout;
    }

    public void setWaitTimeout(Long waitTimeout) {
        this.waitTimeout = waitTimeout;
    }

    public String getWorkGroup() {
        return workGroup;
    }

    public void setWorkGroup(String workGroup) {
        this.workGroup = workGroup;
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

    public String getClientRequestToken() {
        return clientRequestToken;
    }

    public void setClientRequestToken(String clientRequestToken) {
        this.clientRequestToken = clientRequestToken;
    }
}