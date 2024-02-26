package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropCreationDto;
import com.betrybe.agrix.controllers.dto.FarmCreationDto;
import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manage requests for the /farms route.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  public FarmService farmService;

  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Farm createFarm(@RequestBody FarmCreationDto farmCreation) {
    return farmService.save(farmCreation.toEntity());
  }

  @GetMapping
  @Secured({"ADMIN", "USER", "MANAGER"})
  public List<Farm> getAllFarms() {
    return farmService.findAll();
  }

  /**
   * Retrieve a farm by id.
   *
   * @param id Farm id.
   * @return Farm.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Farm> getFarmById(@PathVariable Long id) {
    return ResponseEntity.ok(farmService.findById(id));
  }

  /**
   * Create a Crop and link it to a Farm.
   *
   * @param farmId       Farm id.
   * @param cropCreation Crop request body.
   * @return Created Crop.
   */
  @PostMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public Crop setCrop(
      @PathVariable Long farmId,
      @RequestBody CropCreationDto cropCreation
  ) {
    return farmService.setCrop(farmId, cropCreation.toEntity());
  }

  /**
   * Get Crops by Farm ID.
   *
   * @param farmId Farm ID.
   * @return List Crops.
   */
  @GetMapping("/{farmId}/crops")
  public List<Crop> getCropsByFarmId(@PathVariable Long farmId) {
    return farmService.findCropsByFarmId(farmId);
  }

}
