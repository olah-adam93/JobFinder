package com.example.jobFinder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PositionNotFoundException extends RuntimeException {
  public PositionNotFoundException(Long positionId) {
    super(String.format("Position with id: %s not found!", positionId));
  }
}
