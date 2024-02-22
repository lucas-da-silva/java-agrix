package com.betrybe.agrix.exceptions;

/**
 * Exception for when a crop is not found.
 */
public class CropNotFoundException extends NotFoundException {

  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }

}
