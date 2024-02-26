package com.betrybe.agrix.controllers;

import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.entities.Fertilizer;
import com.betrybe.agrix.services.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manage requests for the /crops route.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;

  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  @Secured({"ADMIN", "MANAGER"})
  @GetMapping
  public List<Crop> getAllCrops() {
    return cropService.findAll();
  }

  /**
   * Recover Crop by ID.
   *
   * @param cropId Crop ID.
   * @return Recovered Crop.
   */
  @GetMapping("/{cropId}")
  public Crop getCropById(@PathVariable Long cropId) {
    return cropService.findById(cropId);
  }

  @GetMapping("/search")
  public List<Crop> getCropsByHarvestDateBetween(
      @RequestParam LocalDate start,
      @RequestParam LocalDate end
  ) {
    return cropService.findByHarvestDateBetween(start, end);
  }

  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  @ResponseStatus(HttpStatus.CREATED)
  public String setFertilizers(@PathVariable Long cropId, @PathVariable Long fertilizerId) {
    cropService.setFertilizer(cropId, fertilizerId);
    return "Fertilizante e plantação associados com sucesso!";
  }

  @GetMapping("/{cropId}/fertilizers")
  public List<Fertilizer> getFertilizersByCropId(@PathVariable Long cropId) {
    return cropService.findFertilizersByCropId(cropId);
  }

}
