package com.lms.lms_backend.exception;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Centralised exception handling. Extends ResponseEntityExceptionHandler so we
 * can override standard handlers (e.g. for malformed JSON and validation).
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Handle a custom ResourceNotFoundException -> 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiError err = new ApiError("Not Found",
                ex.getMessage() == null ? "Resource not found" : ex.getMessage(),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    // Backwards-compatible handling of NoSuchElementException -> 404
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiError> handleNoSuchElement(NoSuchElementException ex) {
        ApiError err = new ApiError("Not Found",
                ex.getMessage() == null ? "Resource not found" : ex.getMessage(),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    // Override for malformed JSON (HttpMessageNotReadable)
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        String msg = "Malformed JSON request";
        Throwable cause = ex.getCause();
        if (cause instanceof MismatchedInputException) {
            msg = "JSON parse error: " + cause.getMessage();
        } else if (ex.getMessage() != null) {
            msg = ex.getMessage();
        }

        ApiError err = new ApiError("Bad Request", msg, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    // Override for validation errors (MethodArgumentNotValid)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        List<String> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fe -> {
                    String field = fe.getField();
                    String defaultMessage = fe.getDefaultMessage();
                    return field + ": " + (defaultMessage == null ? "invalid" : defaultMessage);
                })
                .collect(Collectors.toList());

        ApiError err = new ApiError("Validation Failed", "Request validation failed",
                HttpStatus.BAD_REQUEST.value(), details);
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    // Generic catch-all
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAll(Exception ex) {
        ApiError err = new ApiError("Internal Server Error",
                ex.getMessage() == null ? "Unexpected error" : ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}