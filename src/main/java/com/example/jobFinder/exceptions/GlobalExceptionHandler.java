package com.example.jobFinder.exceptions;

import com.example.jobFinder.util.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(InvalidNameException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ApiErrorResponse> handleInvalidNameException(InvalidNameException ex) {
    return ResponseEntity.badRequest().body(new ApiErrorResponse(ex.getMessage()));
  }

  @ExceptionHandler(InvalidEmailException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ApiErrorResponse> handleInvalidEmailException(InvalidEmailException ex) {
    return ResponseEntity.badRequest().body(new ApiErrorResponse(ex.getMessage()));
  }

  @ExceptionHandler(InvalidLocationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ApiErrorResponse> handleInvalidLocationException(
      InvalidLocationException ex) {
    return ResponseEntity.badRequest().body(new ApiErrorResponse(ex.getMessage()));
  }

  @ExceptionHandler(InvalidKeyWordException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ApiErrorResponse> handleInvalidKeyWordException(
      InvalidKeyWordException ex) {
    return ResponseEntity.badRequest().body(new ApiErrorResponse(ex.getMessage()));
  }

  @ExceptionHandler(ApiKeyNotFoundException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public ResponseEntity<ApiErrorResponse> handleApiKeyNotFoundException(
      ApiKeyNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .body(new ApiErrorResponse(ex.getMessage()));
  }

  @ExceptionHandler(PositionNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ApiErrorResponse> handlePositionNotFoundException(
      PositionNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiErrorResponse(ex.getMessage()));
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ApiErrorResponse> handleRuntimeException(RuntimeException ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ApiErrorResponse(ex.getMessage()));
  }
}
