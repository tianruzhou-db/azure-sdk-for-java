// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.authorization.fluent.models.ADGroupInner;
import com.azure.resourcemanager.authorization.fluent.models.CheckGroupMembershipResultInner;
import com.azure.resourcemanager.authorization.fluent.models.DirectoryObjectInner;
import com.azure.resourcemanager.authorization.models.CheckGroupMembershipParameters;
import com.azure.resourcemanager.authorization.models.GroupCreateParameters;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in GroupsClient. */
public interface GroupsClient {
    /**
     * Checks whether the specified user, group, contact, or service principal is a direct or transitive member of the
     * specified group.
     *
     * @param parameters Request parameters for IsMemberOf API call.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return server response for IsMemberOf API call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<CheckGroupMembershipResultInner>> isMemberOfWithResponseAsync(
        CheckGroupMembershipParameters parameters);

    /**
     * Checks whether the specified user, group, contact, or service principal is a direct or transitive member of the
     * specified group.
     *
     * @param parameters Request parameters for IsMemberOf API call.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return server response for IsMemberOf API call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<CheckGroupMembershipResultInner> isMemberOfAsync(CheckGroupMembershipParameters parameters);

    /**
     * Checks whether the specified user, group, contact, or service principal is a direct or transitive member of the
     * specified group.
     *
     * @param parameters Request parameters for IsMemberOf API call.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return server response for IsMemberOf API call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    CheckGroupMembershipResultInner isMemberOf(CheckGroupMembershipParameters parameters);

    /**
     * Checks whether the specified user, group, contact, or service principal is a direct or transitive member of the
     * specified group.
     *
     * @param parameters Request parameters for IsMemberOf API call.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return server response for IsMemberOf API call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<CheckGroupMembershipResultInner> isMemberOfWithResponse(
        CheckGroupMembershipParameters parameters, Context context);

    /**
     * Remove a member from a group.
     *
     * @param groupObjectId The object ID of the group from which to remove the member.
     * @param memberObjectId Member object id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Void>> removeMemberWithResponseAsync(String groupObjectId, String memberObjectId);

    /**
     * Remove a member from a group.
     *
     * @param groupObjectId The object ID of the group from which to remove the member.
     * @param memberObjectId Member object id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> removeMemberAsync(String groupObjectId, String memberObjectId);

    /**
     * Remove a member from a group.
     *
     * @param groupObjectId The object ID of the group from which to remove the member.
     * @param memberObjectId Member object id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void removeMember(String groupObjectId, String memberObjectId);

    /**
     * Remove a member from a group.
     *
     * @param groupObjectId The object ID of the group from which to remove the member.
     * @param memberObjectId Member object id.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> removeMemberWithResponse(String groupObjectId, String memberObjectId, Context context);

    /**
     * Add a member to a group.
     *
     * @param groupObjectId The object ID of the group to which to add the member.
     * @param url A member object URL, such as
     *     "https://graph.windows.net/0b1f9851-1bf0-433f-aec3-cb9272f093dc/directoryObjects"
         + "/f260bbc4-c254-447b-94cf-293b5ec434dd",
     *     where "0b1f9851-1bf0-433f-aec3-cb9272f093dc" is the tenantId and "f260bbc4-c254-447b-94cf-293b5ec434dd" is
     *     the objectId of the member (user, application, servicePrincipal, group) to be added.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Void>> addMemberWithResponseAsync(String groupObjectId, String url);

    /**
     * Add a member to a group.
     *
     * @param groupObjectId The object ID of the group to which to add the member.
     * @param url A member object URL, such as
     *     "https://graph.windows.net/0b1f9851-1bf0-433f-aec3-cb9272f093dc/directoryObjects"
         + "/f260bbc4-c254-447b-94cf-293b5ec434dd",
     *     where "0b1f9851-1bf0-433f-aec3-cb9272f093dc" is the tenantId and "f260bbc4-c254-447b-94cf-293b5ec434dd" is
     *     the objectId of the member (user, application, servicePrincipal, group) to be added.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> addMemberAsync(String groupObjectId, String url);

    /**
     * Add a member to a group.
     *
     * @param groupObjectId The object ID of the group to which to add the member.
     * @param url A member object URL, such as
     *     "https://graph.windows.net/0b1f9851-1bf0-433f-aec3-cb9272f093dc/directoryObjects"
         + "/f260bbc4-c254-447b-94cf-293b5ec434dd",
     *     where "0b1f9851-1bf0-433f-aec3-cb9272f093dc" is the tenantId and "f260bbc4-c254-447b-94cf-293b5ec434dd" is
     *     the objectId of the member (user, application, servicePrincipal, group) to be added.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void addMember(String groupObjectId, String url);

    /**
     * Add a member to a group.
     *
     * @param groupObjectId The object ID of the group to which to add the member.
     * @param url A member object URL, such as
     *     "https://graph.windows.net/0b1f9851-1bf0-433f-aec3-cb9272f093dc/directoryObjects"
         + "/f260bbc4-c254-447b-94cf-293b5ec434dd",
     *     where "0b1f9851-1bf0-433f-aec3-cb9272f093dc" is the tenantId and "f260bbc4-c254-447b-94cf-293b5ec434dd" is
     *     the objectId of the member (user, application, servicePrincipal, group) to be added.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> addMemberWithResponse(String groupObjectId, String url, Context context);

    /**
     * Create a group in the directory.
     *
     * @param parameters Request parameters for creating a new group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return active Directory group information.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<ADGroupInner>> createWithResponseAsync(GroupCreateParameters parameters);

    /**
     * Create a group in the directory.
     *
     * @param parameters Request parameters for creating a new group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return active Directory group information.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<ADGroupInner> createAsync(GroupCreateParameters parameters);

    /**
     * Create a group in the directory.
     *
     * @param parameters Request parameters for creating a new group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return active Directory group information.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ADGroupInner create(GroupCreateParameters parameters);

    /**
     * Create a group in the directory.
     *
     * @param parameters Request parameters for creating a new group.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return active Directory group information.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ADGroupInner> createWithResponse(GroupCreateParameters parameters, Context context);

    /**
     * Gets list of groups for the current tenant.
     *
     * @param filter The filter to apply to the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return list of groups for the current tenant.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<ADGroupInner> listAsync(String filter);

    /**
     * Gets list of groups for the current tenant.
     *
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return list of groups for the current tenant.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<ADGroupInner> listAsync();

    /**
     * Gets list of groups for the current tenant.
     *
     * @param filter The filter to apply to the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return list of groups for the current tenant.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ADGroupInner> list(String filter, Context context);

    /**
     * Gets list of groups for the current tenant.
     *
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return list of groups for the current tenant.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ADGroupInner> list();

    /**
     * Gets the members of a group.
     *
     * @param objectId The object ID of the group whose members should be retrieved.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the members of a group.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<DirectoryObjectInner> getGroupMembersAsync(String objectId);

    /**
     * Gets the members of a group.
     *
     * @param objectId The object ID of the group whose members should be retrieved.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the members of a group.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DirectoryObjectInner> getGroupMembers(String objectId);

    /**
     * Gets the members of a group.
     *
     * @param objectId The object ID of the group whose members should be retrieved.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the members of a group.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DirectoryObjectInner> getGroupMembers(String objectId, Context context);

    /**
     * Gets group information from the directory.
     *
     * @param objectId The object ID of the user for which to get group information.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return group information from the directory.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<ADGroupInner>> getWithResponseAsync(String objectId);

    /**
     * Gets group information from the directory.
     *
     * @param objectId The object ID of the user for which to get group information.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return group information from the directory.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<ADGroupInner> getAsync(String objectId);

    /**
     * Gets group information from the directory.
     *
     * @param objectId The object ID of the user for which to get group information.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return group information from the directory.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ADGroupInner get(String objectId);

    /**
     * Gets group information from the directory.
     *
     * @param objectId The object ID of the user for which to get group information.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return group information from the directory.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ADGroupInner> getWithResponse(String objectId, Context context);

    /**
     * Delete a group from the directory.
     *
     * @param objectId The object ID of the group to delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Void>> deleteWithResponseAsync(String objectId);

    /**
     * Delete a group from the directory.
     *
     * @param objectId The object ID of the group to delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> deleteAsync(String objectId);

    /**
     * Delete a group from the directory.
     *
     * @param objectId The object ID of the group to delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String objectId);

    /**
     * Delete a group from the directory.
     *
     * @param objectId The object ID of the group to delete.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String objectId, Context context);

    /**
     * Gets a collection of object IDs of groups of which the specified group is a member.
     *
     * @param objectId The object ID of the group for which to get group membership.
     * @param securityEnabledOnly If true, only membership in security-enabled groups should be checked. Otherwise,
     *     membership in all groups should be checked.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a collection of object IDs of groups of which the specified group is a member.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<String> getMemberGroupsAsync(String objectId, boolean securityEnabledOnly);

    /**
     * Gets a collection of object IDs of groups of which the specified group is a member.
     *
     * @param objectId The object ID of the group for which to get group membership.
     * @param securityEnabledOnly If true, only membership in security-enabled groups should be checked. Otherwise,
     *     membership in all groups should be checked.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a collection of object IDs of groups of which the specified group is a member.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<String> getMemberGroups(String objectId, boolean securityEnabledOnly);

    /**
     * Gets a collection of object IDs of groups of which the specified group is a member.
     *
     * @param objectId The object ID of the group for which to get group membership.
     * @param securityEnabledOnly If true, only membership in security-enabled groups should be checked. Otherwise,
     *     membership in all groups should be checked.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a collection of object IDs of groups of which the specified group is a member.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<String> getMemberGroups(String objectId, boolean securityEnabledOnly, Context context);

    /**
     * The owners are a set of non-admin users who are allowed to modify this object.
     *
     * @param objectId The object ID of the group for which to get owners.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return directoryObject list operation result.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<DirectoryObjectInner> listOwnersAsync(String objectId);

    /**
     * The owners are a set of non-admin users who are allowed to modify this object.
     *
     * @param objectId The object ID of the group for which to get owners.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return directoryObject list operation result.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DirectoryObjectInner> listOwners(String objectId);

    /**
     * The owners are a set of non-admin users who are allowed to modify this object.
     *
     * @param objectId The object ID of the group for which to get owners.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return directoryObject list operation result.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DirectoryObjectInner> listOwners(String objectId, Context context);

    /**
     * Add an owner to a group.
     *
     * @param objectId The object ID of the application to which to add the owner.
     * @param url A owner object URL, such as
     *     "https://graph.windows.net/0b1f9851-1bf0-433f-aec3-cb9272f093dc/directoryObjects"
         + "/f260bbc4-c254-447b-94cf-293b5ec434dd",
     *     where "0b1f9851-1bf0-433f-aec3-cb9272f093dc" is the tenantId and "f260bbc4-c254-447b-94cf-293b5ec434dd" is
     *     the objectId of the owner (user, application, servicePrincipal, group) to be added.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Void>> addOwnerWithResponseAsync(String objectId, String url);

    /**
     * Add an owner to a group.
     *
     * @param objectId The object ID of the application to which to add the owner.
     * @param url A owner object URL, such as
     *     "https://graph.windows.net/0b1f9851-1bf0-433f-aec3-cb9272f093dc/directoryObjects"
         + "/f260bbc4-c254-447b-94cf-293b5ec434dd",
     *     where "0b1f9851-1bf0-433f-aec3-cb9272f093dc" is the tenantId and "f260bbc4-c254-447b-94cf-293b5ec434dd" is
     *     the objectId of the owner (user, application, servicePrincipal, group) to be added.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> addOwnerAsync(String objectId, String url);

    /**
     * Add an owner to a group.
     *
     * @param objectId The object ID of the application to which to add the owner.
     * @param url A owner object URL, such as
     *     "https://graph.windows.net/0b1f9851-1bf0-433f-aec3-cb9272f093dc/directoryObjects"
         + "/f260bbc4-c254-447b-94cf-293b5ec434dd",
     *     where "0b1f9851-1bf0-433f-aec3-cb9272f093dc" is the tenantId and "f260bbc4-c254-447b-94cf-293b5ec434dd" is
     *     the objectId of the owner (user, application, servicePrincipal, group) to be added.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void addOwner(String objectId, String url);

    /**
     * Add an owner to a group.
     *
     * @param objectId The object ID of the application to which to add the owner.
     * @param url A owner object URL, such as
     *     "https://graph.windows.net/0b1f9851-1bf0-433f-aec3-cb9272f093dc/directoryObjects"
         + "/f260bbc4-c254-447b-94cf-293b5ec434dd",
     *     where "0b1f9851-1bf0-433f-aec3-cb9272f093dc" is the tenantId and "f260bbc4-c254-447b-94cf-293b5ec434dd" is
     *     the objectId of the owner (user, application, servicePrincipal, group) to be added.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> addOwnerWithResponse(String objectId, String url, Context context);

    /**
     * Remove a member from owners.
     *
     * @param objectId The object ID of the group from which to remove the owner.
     * @param ownerObjectId Owner object id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Void>> removeOwnerWithResponseAsync(String objectId, String ownerObjectId);

    /**
     * Remove a member from owners.
     *
     * @param objectId The object ID of the group from which to remove the owner.
     * @param ownerObjectId Owner object id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> removeOwnerAsync(String objectId, String ownerObjectId);

    /**
     * Remove a member from owners.
     *
     * @param objectId The object ID of the group from which to remove the owner.
     * @param ownerObjectId Owner object id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void removeOwner(String objectId, String ownerObjectId);

    /**
     * Remove a member from owners.
     *
     * @param objectId The object ID of the group from which to remove the owner.
     * @param ownerObjectId Owner object id.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.models.GraphErrorException thrown if the request is rejected by
     *     server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> removeOwnerWithResponse(String objectId, String ownerObjectId, Context context);
}
