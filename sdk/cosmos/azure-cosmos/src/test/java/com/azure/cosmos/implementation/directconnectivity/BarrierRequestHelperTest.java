// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.implementation.directconnectivity;

import com.azure.cosmos.implementation.http.HttpHeaders;
import com.azure.cosmos.implementation.AsyncDocumentClient;
import com.azure.cosmos.implementation.Document;
import com.azure.cosmos.implementation.HttpConstants;
import com.azure.cosmos.implementation.IAuthorizationTokenProvider;
import com.azure.cosmos.implementation.OperationType;
import com.azure.cosmos.implementation.ResourceType;
import com.azure.cosmos.implementation.RxDocumentClientImpl;
import com.azure.cosmos.implementation.RxDocumentServiceRequest;
import com.azure.cosmos.implementation.TestConfigurations;
import com.azure.cosmos.implementation.routing.PartitionKeyRangeIdentity;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

public class BarrierRequestHelperTest {
    @Test(groups = "direct")
    public void barrierBasic() {
        IAuthorizationTokenProvider authTokenProvider = getIAuthorizationTokenProvider();

        for (ResourceType resourceType : ResourceType.values()) {

            for (OperationType operationType : OperationType.values()) {
                Document randomResource = new Document();
                randomResource.setId(UUID.randomUUID().toString());
                RxDocumentServiceRequest request =
                        RxDocumentServiceRequest.create(operationType, resourceType, "/dbs/7mVFAA==/colls/7mVFAP1jpeU=", randomResource, (HttpHeaders) null);

                BarrierRequestHelper.createAsync(request, authTokenProvider, 10l, 10l).block();
                request =
                        RxDocumentServiceRequest.create(operationType, resourceType, "/dbs/7mVFAA==", randomResource, null);

                request.setResourceId("3");
                try {
                    BarrierRequestHelper.createAsync(request, authTokenProvider, 10l, 10l).block();
                } catch (Exception e) {
                    if (!BarrierRequestHelper.isCollectionHeadBarrierRequest(resourceType, operationType)) {
                        fail("Should not fail for non-collection head combinations");
                    }
                }
            }
        }
    }

    @Test(groups = "direct")
    public void barrierDBFeed() {
        IAuthorizationTokenProvider authTokenProvider = getIAuthorizationTokenProvider();

        ResourceType resourceType = ResourceType.DocumentCollection;
        OperationType operationType = OperationType.Query;

        Document randomResource = new Document();
        randomResource.setId(UUID.randomUUID().toString());
        RxDocumentServiceRequest request =
                RxDocumentServiceRequest.create(operationType, resourceType, "/dbs/7mVFAA==/colls/7mVFAP1jpeU=", randomResource, (HttpHeaders) null);

        RxDocumentServiceRequest barrierRequest = BarrierRequestHelper.createAsync(request, authTokenProvider, 11l, 10l).block();

        assertThat(barrierRequest.getOperationType()).isEqualTo(OperationType.HeadFeed);
        assertThat(barrierRequest.getResourceType()).isEqualTo(ResourceType.Database);


        assertThat(getTargetGlobalLsn(barrierRequest)).isEqualTo(10l);
        assertThat(getTargetLsn(barrierRequest)).isEqualTo(11l);
    }

    @Test(groups = "direct")
    public void barrierDocumentQueryNameBasedRequest() {
        IAuthorizationTokenProvider authTokenProvider = getIAuthorizationTokenProvider();

        ResourceType resourceType = ResourceType.Document;
        OperationType operationType = OperationType.Query;

        Document randomResource = new Document();
        randomResource.setId(UUID.randomUUID().toString());
        RxDocumentServiceRequest request =
                RxDocumentServiceRequest.create(operationType, resourceType, "/dbs/dbname/colls/collname", randomResource, (HttpHeaders) null);

        RxDocumentServiceRequest barrierRequest = BarrierRequestHelper.createAsync(request, authTokenProvider, 11l, 10l).block();

        assertThat(barrierRequest.getOperationType()).isEqualTo(OperationType.Head);
        assertThat(barrierRequest.getResourceType()).isEqualTo(ResourceType.DocumentCollection);
        assertThat(barrierRequest.getResourceAddress()).isEqualTo("dbs/dbname/colls/collname");

        assertThat(getTargetGlobalLsn(barrierRequest)).isEqualTo(10l);
        assertThat(getTargetLsn(barrierRequest)).isEqualTo(11l);
    }

    @Test(groups = "direct")
    public void barrierDocumentReadNameBasedRequest() {
        IAuthorizationTokenProvider authTokenProvider = getIAuthorizationTokenProvider();

        ResourceType resourceType = ResourceType.Document;
        OperationType operationType = OperationType.Read;

        Document randomResource = new Document();
        randomResource.setId(UUID.randomUUID().toString());
        RxDocumentServiceRequest request =
                RxDocumentServiceRequest.create(operationType, resourceType, "/dbs/dbname/colls/collname", randomResource, (HttpHeaders) null);

        RxDocumentServiceRequest barrierRequest = BarrierRequestHelper.createAsync(request, authTokenProvider, 11l, 10l).block();

        assertThat(barrierRequest.getOperationType()).isEqualTo(OperationType.Head);
        assertThat(barrierRequest.getResourceType()).isEqualTo(ResourceType.DocumentCollection);
        assertThat(barrierRequest.getResourceAddress()).isEqualTo("dbs/dbname/colls/collname");

        assertThat(getTargetGlobalLsn(barrierRequest)).isEqualTo(10l);
        assertThat(getTargetLsn(barrierRequest)).isEqualTo(11l);
        assertThat(barrierRequest.getIsNameBased()).isEqualTo(true);

    }

    @Test(groups = "direct")
    public void barrierDocumentReadRidBasedRequest() {
        IAuthorizationTokenProvider authTokenProvider = getIAuthorizationTokenProvider();

        ResourceType resourceType = ResourceType.Document;
        OperationType operationType = OperationType.Read;

        Document randomResource = new Document();
        randomResource.setId(UUID.randomUUID().toString());
        RxDocumentServiceRequest request =
                RxDocumentServiceRequest.create(operationType, "7mVFAA==", resourceType, (HttpHeaders) null);

        RxDocumentServiceRequest barrierRequest = BarrierRequestHelper.createAsync(request, authTokenProvider, 11l, 10l).block();

        assertThat(barrierRequest.getOperationType()).isEqualTo(OperationType.Head);
        assertThat(barrierRequest.getResourceType()).isEqualTo(ResourceType.DocumentCollection);
        assertThat(barrierRequest.getResourceAddress()).isEqualTo("7mVFAA==");

        assertThat(getTargetGlobalLsn(barrierRequest)).isEqualTo(10l);
        assertThat(getTargetLsn(barrierRequest)).isEqualTo(11l);
        assertThat(barrierRequest.getIsNameBased()).isEqualTo(false);
    }

    @DataProvider(name = "isCollectionHeadBarrierRequestArgProvider")
    public Object[][] isCollectionHeadBarrierRequestArgProvider() {
        return new Object[][]{
                // resourceType, operationType, isCollectionHeadBarrierRequest

                {ResourceType.Attachment, null, true},
                {ResourceType.Document, null, true},
                {ResourceType.Conflict, null, true},
                {ResourceType.StoredProcedure, null, true},
                {ResourceType.Attachment, null, true},
                {ResourceType.Trigger, null, true},

                {ResourceType.DocumentCollection, OperationType.ReadFeed, false},
                {ResourceType.DocumentCollection, OperationType.Query, false},
                {ResourceType.DocumentCollection, OperationType.SqlQuery, false},

                {ResourceType.DocumentCollection, OperationType.Create, true},
                {ResourceType.DocumentCollection, OperationType.Read, true},
                {ResourceType.DocumentCollection, OperationType.Replace, true},
                {ResourceType.DocumentCollection, OperationType.ExecuteJavaScript, true},

                {ResourceType.PartitionKeyRange, null, false},
        };
    }

    @Test(groups = "direct", dataProvider = "isCollectionHeadBarrierRequestArgProvider")
    public void isCollectionHeadBarrierRequest(ResourceType resourceType,
                                               OperationType operationType,
                                               boolean expectedResult) {
        if (operationType != null) {
            boolean actual = BarrierRequestHelper.isCollectionHeadBarrierRequest(resourceType, operationType);
            assertThat(actual).isEqualTo(expectedResult);
        } else {
            for (OperationType type : OperationType.values()) {
                boolean actual = BarrierRequestHelper.isCollectionHeadBarrierRequest(resourceType, type);
                assertThat(actual).isEqualTo(expectedResult);
            }
        }
    }

    private IAuthorizationTokenProvider getIAuthorizationTokenProvider() {
        return (RxDocumentClientImpl)
                new AsyncDocumentClient.Builder()
                        .withMasterKeyOrResourceToken(TestConfigurations.MASTER_KEY)
                        .withServiceEndpoint(TestConfigurations.HOST)
                        .build();
    }

    private String getHeaderValue(RxDocumentServiceRequest req, String name) {
        return req.getHeaders().getValue(name);
    }

    private String getPartitionKey(RxDocumentServiceRequest req) {
        return getHeaderValue(req, HttpConstants.Headers.PARTITION_KEY);
    }

    private String getCollectionRid(RxDocumentServiceRequest req) {
        return getHeaderValue(req, WFConstants.BackendHeaders.COLLECTION_RID);
    }

    private PartitionKeyRangeIdentity getPartitionKeyRangeIdentity(RxDocumentServiceRequest req) {
        return req.getPartitionKeyRangeIdentity();
    }

    private Long getTargetLsn(RxDocumentServiceRequest req) {
        return Long.parseLong(getHeaderValue(req, HttpConstants.Headers.TARGET_LSN));
    }

    private Long getTargetGlobalLsn(RxDocumentServiceRequest req) {
        return Long.parseLong(getHeaderValue(req, HttpConstants.Headers.TARGET_GLOBAL_COMMITTED_LSN));
    }
}

