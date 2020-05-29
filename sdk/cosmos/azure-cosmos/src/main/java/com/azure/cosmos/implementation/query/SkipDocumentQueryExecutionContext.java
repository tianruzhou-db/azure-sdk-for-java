// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.implementation.query;

import com.azure.cosmos.implementation.http.HttpHeaders;
import com.azure.cosmos.BridgeInternal;
import com.azure.cosmos.CosmosException;
import com.azure.cosmos.models.FeedResponse;
import com.azure.cosmos.implementation.Resource;
import com.azure.cosmos.implementation.HttpConstants;
import com.azure.cosmos.implementation.Utils;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class SkipDocumentQueryExecutionContext<T extends Resource> implements IDocumentQueryExecutionComponent<T> {

    private final IDocumentQueryExecutionComponent<T> component;
    private int skipCount;

    SkipDocumentQueryExecutionContext(IDocumentQueryExecutionComponent<T> component, int skipCount) {
        if (component == null) {
            throw new IllegalArgumentException("documentQueryExecutionComponent cannot be null");
        }
        this.component = component;
        this.skipCount = skipCount;
    }

    public static <T extends Resource> Flux<IDocumentQueryExecutionComponent<T>> createAsync(
        Function<String, Flux<IDocumentQueryExecutionComponent<T>>> createSourceComponentFunction,
        int skipCount,
        String continuationToken) {
        OffsetContinuationToken offsetContinuationToken;
        Utils.ValueHolder<OffsetContinuationToken> outOffsetContinuationToken = new Utils.ValueHolder<>();
        if (continuationToken != null) {
            if (!OffsetContinuationToken.tryParse(continuationToken, outOffsetContinuationToken)) {
                String message = String.format("Invalid JSON in continuation token %s for Skip~Context",
                    continuationToken);
                CosmosException dce =
                    BridgeInternal.createCosmosException(HttpConstants.StatusCodes.BADREQUEST,
                    message);
                return Flux.error(dce);
            }

            offsetContinuationToken = outOffsetContinuationToken.v;
        } else {
            offsetContinuationToken = new OffsetContinuationToken(skipCount, null);
        }

        return createSourceComponentFunction.apply(offsetContinuationToken.getSourceToken())
                   .map(component -> new SkipDocumentQueryExecutionContext<>(component,
                       offsetContinuationToken.getOffset()));
    }

    @Override
    public Flux<FeedResponse<T>> drainAsync(int maxPageSize) {

        return this.component.drainAsync(maxPageSize).map(tFeedResponse -> {

            List<T> documentsAfterSkip =
                tFeedResponse.getResults().stream().skip(this.skipCount).collect(Collectors.toList());

            int numberOfDocumentsSkipped = tFeedResponse.getResults().size() - documentsAfterSkip.size();
            this.skipCount -= numberOfDocumentsSkipped;

            HttpHeaders headers = Utils.clone(tFeedResponse.getResponseHeaders());
            if (this.skipCount >= 0) {
                // Add Offset Continuation Token
                String sourceContinuationToken = tFeedResponse.getContinuationToken();
                OffsetContinuationToken offsetContinuationToken = new OffsetContinuationToken(this.skipCount,
                    sourceContinuationToken);
                headers.put(HttpConstants.Headers.CONTINUATION, offsetContinuationToken.toJson());
            }

            return BridgeInternal.createFeedResponseWithQueryMetrics(documentsAfterSkip, headers,
                BridgeInternal.queryMetricsFromFeedResponse(tFeedResponse));
        });
    }

    IDocumentQueryExecutionComponent<T> getComponent() {
        return this.component;
    }
}
