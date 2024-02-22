package com.betrybe.agrix.exceptions;

/**
 * Exception for when a fertilizer is not found.
 */
public class FertilizerNotFound extends NotFoundException {

  public FertilizerNotFound() {
    super("Fertilizante não encontrado!");
  }

}
