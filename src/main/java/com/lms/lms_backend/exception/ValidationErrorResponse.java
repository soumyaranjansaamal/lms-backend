package com.lms.lms_backend.exception;

import java.util.Map;

public class ValidationErrorResponse {
    private int status;
    private String error;
    private Map<String, String> fieldErrors;

    public ValidationErrorResponse() {}

    public ValidationErrorResponse(int status, String error, Map<String, String> fieldErrors) {
        this.status = status;
        this.error = error;
        this.fieldErrors = fieldErrors;
    }

    // getters + setters
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
    public Map<String, String> getFieldErrors() { return fieldErrors; }
    public void setFieldErrors(Map<String, String> fieldErrors) { this.fieldErrors = fieldErrors; }
}