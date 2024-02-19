package com.example.jobFinder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidLocationException extends RuntimeException {
  public InvalidLocationException(String msg) {
    super(msg);
  }
}
