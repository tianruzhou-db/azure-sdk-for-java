/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.resources.v2016_06_01.implementation;

import com.microsoft.azure.management.resources.v2016_06_01.TenantIdDescription;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;

class TenantIdDescriptionImpl extends WrapperImpl<TenantIdDescriptionInner> implements TenantIdDescription {
    private final Manager manager;
    TenantIdDescriptionImpl(TenantIdDescriptionInner inner, Manager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public Manager manager() {
        return this.manager;
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String tenantId() {
        return this.inner().tenantId();
    }

}