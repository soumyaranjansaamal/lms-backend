package com.lms.lms_backend.exception;

import java.time.Instant;

/**
 * Lightweight error response DTO (alternative/compatibility).
 */
public class ErrorResponse {
    private String error;
    private String message;
    private int status;
    private Instant timestamp;

    public ErrorResponse() {
        this.timestamp = Instant.now();
    }

    public ErrorResponse(String error, String message, int status) {
        this();
        this.error = error;
        this.message = message;
        this.status = status;
    }

    // getters & setters
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}