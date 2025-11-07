package com.fengcastelo.project.Model.Controllers.exceptions;

import com.fengcastelo.project.Services.exceptions.DatabaseException;
import com.fengcastelo.project.Services.exceptions.EntityNotFound;
import com.fengcastelo.project.Services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        //HttpStatus -> retorna um Int no seu value.
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(error, e.getMessage(), request.getRequestURI(), status.value(), Instant.now());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(error, e.getMessage(), request.getRequestURI(), status.value(), Instant.now());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFound e, HttpServletRequest request) {
        String error = "Entity not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(error, e.getMessage(), request.getRequestURI(), status.value(), Instant.now());
        return ResponseEntity.status(status).body(err);
    }
}
