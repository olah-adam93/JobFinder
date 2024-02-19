package com.example.jobFinder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidNameException extends RuntimeException {
  public InvalidNameException(String msg) {
    super(msg);
  }
}
