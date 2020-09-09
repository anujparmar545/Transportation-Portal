package com.anuj.response;


/**
 * @author anuj.parmar
 *
 */


public class ErrorResponse {
    private String httpStatusCode;
    private String httpStatusMessage;
    private ErrorObject errors;

    public ErrorResponse(final String httpStatusCode, final String httpStatusMessage, final ErrorObject errors) {
        this.httpStatusCode = httpStatusCode;
        this.httpStatusMessage = httpStatusMessage;
        this.errors = errors;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(final String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getHttpStatusMessage() {
        return httpStatusMessage;
    }

    public void setHttpStatusMessage(final String httpStatusMessage) {
        this.httpStatusMessage = httpStatusMessage;
    }

    public ErrorObject getErrors() {
        return errors;
    }

    public void setErrors(final ErrorObject errors) {
        this.errors = errors;
    }
}
