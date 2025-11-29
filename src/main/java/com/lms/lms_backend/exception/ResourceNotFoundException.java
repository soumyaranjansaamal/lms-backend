package com.lms.lms_backend.exception;

/**
 * Use when entity/resource cannot be found.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() { super(); }
    public ResourceNotFoundException(String message) { super(message); }
    public ResourceNotFoundException(String message, Throwable cause) { super(message, cause); }
}