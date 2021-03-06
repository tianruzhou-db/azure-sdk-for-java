/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.databoxedge.v2019_08_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.databoxedge.v2019_08_01.implementation.ContainerInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.databoxedge.v2019_08_01.implementation.DataBoxEdgeManager;
import org.joda.time.DateTime;

/**
 * Type representing Container.
 */
public interface Container extends HasInner<ContainerInner>, Indexable, Refreshable<Container>, Updatable<Container.Update>, HasManager<DataBoxEdgeManager> {
    /**
     * @return the containerStatus value.
     */
    ContainerStatus containerStatus();

    /**
     * @return the createdDateTime value.
     */
    DateTime createdDateTime();

    /**
     * @return the dataFormat value.
     */
    AzureContainerDataFormat dataFormat();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the refreshDetails value.
     */
    RefreshDetails refreshDetails();

    /**
     * @return the type value.
     */
    String type();

    /**
     * The entirety of the Container definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithStorageAccount, DefinitionStages.WithDataFormat, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of Container definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a Container definition.
         */
        interface Blank extends WithStorageAccount {
        }

        /**
         * The stage of the container definition allowing to specify StorageAccount.
         */
        interface WithStorageAccount {
           /**
            * Specifies deviceName, storageAccountName, resourceGroupName.
            * @param deviceName The device name
            * @param storageAccountName The Storage Account Name
            * @param resourceGroupName The resource group name
            * @return the next definition stage
            */
            WithDataFormat withExistingStorageAccount(String deviceName, String storageAccountName, String resourceGroupName);
        }

        /**
         * The stage of the container definition allowing to specify DataFormat.
         */
        interface WithDataFormat {
           /**
            * Specifies dataFormat.
            * @param dataFormat DataFormat for Container. Possible values include: 'BlockBlob', 'PageBlob', 'AzureFile'
            * @return the next definition stage
            */
            WithCreate withDataFormat(AzureContainerDataFormat dataFormat);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<Container> {
        }
    }
    /**
     * The template for a Container update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<Container> {
    }

    /**
     * Grouping of Container update stages.
     */
    interface UpdateStages {
    }
}
