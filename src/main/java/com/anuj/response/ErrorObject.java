package com.anuj.response;

/**
 * @author anuj.parmar
 *
 */

public class ErrorObject {
    private String errorCode;
    private String errorMessage;
    private String target;

    public ErrorObject(final String errorCode, final String errorMessage, final String target) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.target = target;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(final String target) {
        this.target = target;
    }
}