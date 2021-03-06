// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.implementation;

import com.azure.core.annotation.ServiceClientBuilder;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.CookiePolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;

/** A builder for creating a new instance of the AzureCognitiveServiceMetricsAdvisorRestAPIOpenAPIV2 type. */
@ServiceClientBuilder(serviceClients = {AzureCognitiveServiceMetricsAdvisorRestAPIOpenAPIV2Impl.class})
public final class AzureCognitiveServiceMetricsAdvisorRestAPIOpenAPIV2ImplBuilder {
    /*
     * Supported Cognitive Services endpoints (protocol and hostname, for
     * example: https://<resource-name>.cognitiveservices.azure.com).
     */
    private String endpoint;

    /**
     * Sets Supported Cognitive Services endpoints (protocol and hostname, for example:
     * https://&lt;resource-name&gt;.cognitiveservices.azure.com).
     *
     * @param endpoint the endpoint value.
     * @return the AzureCognitiveServiceMetricsAdvisorRestAPIOpenAPIV2ImplBuilder.
     */
    public AzureCognitiveServiceMetricsAdvisorRestAPIOpenAPIV2ImplBuilder endpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /*
     * The HTTP pipeline to send requests through
     */
    private HttpPipeline pipeline;

    /**
     * Sets The HTTP pipeline to send requests through.
     *
     * @param pipeline the pipeline value.
     * @return the AzureCognitiveServiceMetricsAdvisorRestAPIOpenAPIV2ImplBuilder.
     */
    public AzureCognitiveServiceMetricsAdvisorRestAPIOpenAPIV2ImplBuilder pipeline(HttpPipeline pipeline) {
        this.pipeline = pipeline;
        return this;
    }

    /**
     * Builds an instance of AzureCognitiveServiceMetricsAdvisorRestAPIOpenAPIV2Impl with the provided parameters.
     *
     * @return an instance of AzureCognitiveServiceMetricsAdvisorRestAPIOpenAPIV2Impl.
     */
    public AzureCognitiveServiceMetricsAdvisorRestAPIOpenAPIV2Impl buildClient() {
        if (pipeline == null) {
            this.pipeline =
                    new HttpPipelineBuilder()
                            .policies(new UserAgentPolicy(), new RetryPolicy(), new CookiePolicy())
                            .build();
        }
        AzureCognitiveServiceMetricsAdvisorRestAPIOpenAPIV2Impl client =
                new AzureCognitiveServiceMetricsAdvisorRestAPIOpenAPIV2Impl(pipeline, endpoint);
        return client;
    }
}
