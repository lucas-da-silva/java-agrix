package com.betrybe.agrix.exceptions;

/**
 * Exception for when a farm is not found.
 */
public class FarmNotFoundException extends NotFoundException {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }

}
