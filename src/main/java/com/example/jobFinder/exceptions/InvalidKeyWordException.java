package com.example.jobFinder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidKeyWordException extends RuntimeException {
  public InvalidKeyWordException(String msg) {
    super(msg);
  }
}
