package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.entities.Fertilizer;

/**
 * Request Fertilizer DTO.
 */
public record FertilizerCreationDto(String name, String brand, String composition) {

  /**
   * Create a Fertilizer class.
   *
   * @return Fertilizer class.
   */
  public Fertilizer toEntity() {
    Fertilizer fertilizer = new Fertilizer();
    fertilizer.setName(name);
    fertilizer.setComposition(composition);
    fertilizer.setBrand(brand);
    return fertilizer;
  }

}
