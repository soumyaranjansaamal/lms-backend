package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.exception.ErrorResponse;
import com.lms.lms_backend.exception.ResourceNotFoundException;
import com.lms.lms_backend.service.EmployeePrimaryInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Small focused controller that provides update (PUT) endpoint for EmployeePrimaryInfo.
 * We keep this separate to avoid modifying large existing controller files.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeUpdateController {
    private final EmployeePrimaryInfoService employeePrimaryInfoService;
    private final Logger logger = LoggerFactory.getLogger(EmployeeUpdateController.class);

    public EmployeeUpdateController(EmployeePrimaryInfoService employeePrimaryInfoService) {
        this.employeePrimaryInfoService = employeePrimaryInfoService;
    }

    /**
     * Replace (update) employee primary info by id.
     * Expects full EmployeePrimaryInfo JSON in request body.
     *
     * Example:
     * PUT /api/employees/7
     * { "employeeName":"...", "gender":"MALE", "dateOfBirth":"1999-01-01", "qualification":"B.Tech", "phoneNumber":"9999", "email":"x@y.com" }
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployeePrimary(
            @PathVariable("id") Long id,
            @RequestBody EmployeePrimaryInfo payload) {

        try {
            EmployeePrimaryInfo updated = employeePrimaryInfoService.updateEmployee(id, payload);
            return ResponseEntity.ok(updated);
        } catch (ResourceNotFoundException rnfe) {
            logger.info("Update failed - not found: id={}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("Not Found", rnfe.getMessage()));
        } catch (IllegalArgumentException iae) {
            // used for validation / duplicate checks
            logger.info("Update failed - bad request: {}", iae.getMessage());
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Bad Request", iae.getMessage()));
        } catch (Exception ex) {
            logger.error("Unexpected error while updating employee id={}", id, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Server Error", "Unexpected error: " + ex.getMessage()));
        }
    }
}