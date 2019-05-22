/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adminservices.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class SuccessMessageResponse extends AdminServicesAPIResponse
{
    private String successMessage = null;


    /**
     * Default constructor
     */
    public SuccessMessageResponse()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public SuccessMessageResponse(SuccessMessageResponse  template)
    {
        super(template);

        if (template != null)
        {
            this.successMessage = template.getSuccessMessage();
        }
    }


    /**
     * Return the success message (if any).
     *
     * @return string or null
     */
    public String getSuccessMessage()
    {
        return successMessage;
    }


    /**
     * Set up the success message.  This provides supplementary information about the services that
     * have been changed.
     *
     * @param successMessage string or null
     */
    public void setSuccessMessage(String successMessage)
    {
        this.successMessage = successMessage;
    }


    /**
     * JSON-like toString
     *
     * @return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "SuccessMessageResponse{" +
                "successMessage='" + successMessage + '\'' +
                ", relatedHTTPCode=" + getRelatedHTTPCode() +
                ", exceptionClassName='" + getExceptionClassName() + '\'' +
                ", exceptionErrorMessage='" + getExceptionErrorMessage() + '\'' +
                ", exceptionSystemAction='" + getExceptionSystemAction() + '\'' +
                ", exceptionUserAction='" + getExceptionUserAction() + '\'' +
                ", exceptionProperties=" + getExceptionProperties() +
                '}';
    }

}
