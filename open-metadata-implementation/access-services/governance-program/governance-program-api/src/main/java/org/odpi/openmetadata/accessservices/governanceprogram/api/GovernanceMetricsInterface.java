/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.governanceprogram.api;


import org.odpi.openmetadata.accessservices.governanceprogram.metadataelements.GovernanceMetricElement;
import org.odpi.openmetadata.accessservices.governanceprogram.properties.GovernanceMetricProperties;
import org.odpi.openmetadata.frameworks.connectors.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.connectors.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.connectors.ffdc.UserNotAuthorizedException;

import java.util.List;

/**
 * The GovernanceMetricsInterface supports the definition of the metrics that measure the success of the governance program.  Typically, a
 * metric is associated with a governance definition.
 */
public interface GovernanceMetricsInterface
{
    /**
     * Create a new governance metric.
     *
     * @param userId calling user
     * @param metricProperties properties of the metric
     *
     * @return unique identifier of the metric
     *
     * @throws InvalidParameterException typeName, documentIdentifier or userId is null; documentIdentifier is not unique; typeName is not valid
     * @throws PropertyServerException problem accessing property server
     * @throws UserNotAuthorizedException security access problem
     */
    String createGovernanceMetric(String                     userId,
                                  GovernanceMetricProperties metricProperties) throws InvalidParameterException,
                                                                                      UserNotAuthorizedException,
                                                                                      PropertyServerException;

    /**
     * Update an existing governance metric.
     *
     * @param userId calling user
     * @param metricGUID unique identifier of the metric to update
     * @param isMergeUpdate are unspecified properties unchanged (true) or replaced with null?
     * @param metricProperties properties to update
     *
     * @throws InvalidParameterException guid, documentIdentifier or userId is null; documentIdentifier is not unique; guid is not known
     * @throws PropertyServerException problem accessing property server
     * @throws UserNotAuthorizedException security access problem
     */
    void  updateGovernanceMetric(String                     userId,
                                 String                     metricGUID,
                                 boolean                    isMergeUpdate,
                                 GovernanceMetricProperties metricProperties) throws InvalidParameterException,
                                                                                     UserNotAuthorizedException,
                                                                                     PropertyServerException;


    /**
     * Delete a specific governance metric.
     *
     * @param userId calling user
     * @param metricGUID unique identifier of the metric to remove
     *
     * @throws InvalidParameterException guid is null or not known
     * @throws PropertyServerException problem accessing property server
     * @throws UserNotAuthorizedException security access problem
     */
    void  deleteGovernanceMetric(String userId,
                                 String metricGUID) throws InvalidParameterException,
                                                           UserNotAuthorizedException,
                                                           PropertyServerException;



    /**
     * Create a link to show that a governance metric supports the requirements of one of the governance policies.
     * If the link already exists the rationale is updated.
     *
     * @param userId calling user
     * @param metricGUID unique identifier of the governance metric
     * @param governanceDefinitionGUID unique identifier of the governance definition
     * @param rationale description of how the metric supports the driver
     *
     * @throws InvalidParameterException one of the guids is null or not known
     * @throws PropertyServerException problem accessing property server
     * @throws UserNotAuthorizedException security access problem
     */
    void setupGovernanceDefinitionMetric(String userId,
                                         String metricGUID,
                                         String governanceDefinitionGUID,
                                         String rationale) throws InvalidParameterException,
                                                                  UserNotAuthorizedException,
                                                                  PropertyServerException;


    /**
     * Remove the link between a governance metric and a governance definition.
     *
     * @param userId calling user
     * @param metricGUID unique identifier of the governance metric
     * @param governanceDefinitionGUID unique identifier of the governance definition
     *
     * @throws InvalidParameterException one of the guids is null or not known
     * @throws PropertyServerException problem accessing property server
     * @throws UserNotAuthorizedException security access problem
     */
    void clearGovernanceDefinitionMetric(String userId,
                                         String metricGUID,
                                         String governanceDefinitionGUID) throws InvalidParameterException,
                                                                                 UserNotAuthorizedException,
                                                                                 PropertyServerException;

    /**
     * Return information about a specific governance metric.
     *
     * @param userId calling user
     * @param metricGUID unique identifier for the governance metrics
     *
     * @return properties of the governance metric
     *
     * @throws InvalidParameterException metricGUID or userId is null
     * @throws PropertyServerException problem accessing property server
     * @throws UserNotAuthorizedException security access problem
     */
    GovernanceMetricElement getGovernanceMetricByGUID(String userId,
                                                      String metricGUID) throws InvalidParameterException,
                                                                                UserNotAuthorizedException,
                                                                                PropertyServerException;

    /**
     * Retrieve the list of governance metrics for this search string.
     *
     * @param userId the name of the calling user.
     * @param searchString value to search for (supports wildcards).
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     *
     * @return list of metrics
     *
     * @throws InvalidParameterException guid invalid or the search parameter is not correctly specified, or is null.
     * @throws PropertyServerException the server is not available.
     * @throws UserNotAuthorizedException the calling user is not authorized to issue the call.
     */
    List<GovernanceMetricElement> findGovernanceMetrics(String userId,
                                                        String searchString,
                                                        int    startFrom,
                                                        int    pageSize) throws InvalidParameterException,
                                                                                PropertyServerException,
                                                                                UserNotAuthorizedException;
}
