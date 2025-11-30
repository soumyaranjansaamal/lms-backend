package com.lms.lms_backend.exception;

import java.time.Instant;

public class ErrorResponse {
    private Instant timestamp = Instant.now();
    private String message;
    private String details;
    private int status; // optional http status

    public ErrorResponse() {}

    // This constructor is the one your controllers expect
    public ErrorResponse(String message, String details) {
        this.message = message;
        this.details = details;
    }

    // Optional full constructor
    public ErrorResponse(String message, String details, int status) {
        this.message = message;
        this.details = details;
        this.status = status;
    }

    // getters/setters
    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
}