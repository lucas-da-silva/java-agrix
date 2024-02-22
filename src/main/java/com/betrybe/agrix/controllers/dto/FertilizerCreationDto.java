package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.entities.Fertilizer;

/**
 * Request Fertilizer DTO.
 */
public record FertilizerCreationDto(String name, String brand, String composition) {

  /**
   * Create a Fertilizer entity.
   *
   * @return Fertilizer entity.
   */
  public Fertilizer toEntity() {
    Fertilizer fertilizer = new Fertilizer();
    fertilizer.setName(name);
    fertilizer.setComposition(composition);
    fertilizer.setBrand(brand);
    return fertilizer;
  }

}
