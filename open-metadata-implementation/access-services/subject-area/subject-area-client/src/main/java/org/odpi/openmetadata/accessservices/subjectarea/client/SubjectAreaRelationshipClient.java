/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.subjectarea.client;

import org.odpi.openmetadata.accessservices.subjectarea.properties.objects.common.FindRequest;
import org.odpi.openmetadata.accessservices.subjectarea.properties.objects.graph.Line;

import java.util.List;

/**
 * Client class for subject area relationships {@link Line}
 * */
public interface SubjectAreaRelationshipClient<L extends Line>  extends SubjectAreaClient<L> {

    /**
     * @throws UnsupportedOperationException - this method is until not supported
     **/
    @Override
    List<L> find(String userId, FindRequest findRequest) throws UnsupportedOperationException;
}