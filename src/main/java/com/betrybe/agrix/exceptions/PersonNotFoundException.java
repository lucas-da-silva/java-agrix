package com.betrybe.agrix.exceptions;

/**
 * Exception for when a person is not found.
 */
public class PersonNotFoundException extends NotFoundException {

  public PersonNotFoundException() {
    super("Pessoa não encontrada!");
  }

}
