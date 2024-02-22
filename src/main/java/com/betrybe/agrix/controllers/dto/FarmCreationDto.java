package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.entities.Farm;

/**
 * Request Farm DTO.
 */
public record FarmCreationDto(String name, Double size) {

  /**
   * Create a Farm class.
   *
   * @return Farm class.
   */
  public Farm toEntity() {
    Farm farm = new Farm();
    farm.setName(name);
    farm.setSize(size);
    return farm;
  }
}
