package com.lms.lms_backend.exception;

import java.time.Instant;
import java.util.List;

public class ApiError {
    private String error;
    private String message;
    private int status;
    private Instant timestamp;
    private List<String> details;

    public ApiError() {
        this.timestamp = Instant.now();
    }

    public ApiError(String error, String message, int status) {
        this();
        this.error = error;
        this.message = message;
        this.status = status;
    }

    public ApiError(String error, String message, int status, List<String> details) {
        this(error, message, status);
        this.details = details;
    }

    // getters + setters
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
    public List<String> getDetails() { return details; }
    public void setDetails(List<String> details) { this.details = details; }
}