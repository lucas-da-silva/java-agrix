package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.entities.Crop;
import java.time.LocalDate;

/**
 * Request Crop DTO.
 */
public record CropCreationDto(String name, Double plantedArea, LocalDate plantedDate,
                              LocalDate harvestDate) {

  /**
   * Create a Crop class.
   *
   * @return Crop class.
   */
  public Crop toEntity() {
    Crop crop = new Crop();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    crop.setPlantedDate(plantedDate);
    crop.setHarvestDate(harvestDate);
    return crop;
  }

}
