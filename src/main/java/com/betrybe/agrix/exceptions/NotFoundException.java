package com.betrybe.agrix.exceptions;

/**
 * Not Found exception.
 */
public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }
}
