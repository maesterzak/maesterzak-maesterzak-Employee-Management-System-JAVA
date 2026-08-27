package net.javaguides.ems_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFound.class)
  public ResponseEntity<Map<String, Object>> handleResourceNotFound(
          ResourceNotFound exception) {

    Map<String, Object> error = new LinkedHashMap<>();

    error.put("timestamp", LocalDateTime.now());
    error.put("status", HttpStatus.NOT_FOUND.value());
    error.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
    error.put("path", "/api/v1/employees");
    error.put("message", exception.getMessage());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}