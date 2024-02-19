package com.example.jobFinder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApiKeyNotFoundException extends RuntimeException {
  public ApiKeyNotFoundException(String apiKey) {
    super(String.format("Client with api key: %s not found!", apiKey));
  }
}
