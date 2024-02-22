package com.betrybe.agrix.services;

import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.entities.Fertilizer;
import com.betrybe.agrix.exceptions.CropNotFoundException;
import com.betrybe.agrix.repositories.CropRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Layer service for entity Crop.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;

  private final FertilizerService fertilizerService;

  @Autowired
  public CropService(CropRepository cropRepository, FertilizerService fertilizerService) {
    this.cropRepository = cropRepository;
    this.fertilizerService = fertilizerService;
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  public Crop findById(Long id) {
    return cropRepository.findById(id).orElseThrow(CropNotFoundException::new);
  }

  public List<Crop> findByHarvestDateBetween(LocalDate start, LocalDate end) {
    System.out.println("Passou do primeiro método");
    return cropRepository.findByHarvestDateBetween(start, end);
  }

  /**
   * Associates a crop with a fertilizer.
   *
   * @param cropId       Crop id.
   * @param fertilizerId Fertilizer id.
   */
  public void setFertilizer(Long cropId, Long fertilizerId) {
    Optional<Crop> optionalCrop = cropRepository.findById(cropId);

    if (optionalCrop.isEmpty()) {
      throw new CropNotFoundException();
    }

    Crop crop = optionalCrop.get();
    Fertilizer fertilizer = fertilizerService.findById(fertilizerId);
    crop.getFertilizers().add(fertilizer);
    fertilizer.getCrops().add(crop);

    cropRepository.save(crop);
    fertilizerService.save(fertilizer);
  }

  /**
   * Lists the fertilizers associated with a plantation.
   *
   * @param cropId Crop id.
   */
  public List<Fertilizer> findFertilizersByCropId(Long cropId) {
    Optional<Crop> optionalCrop = cropRepository.findById(cropId);

    if (optionalCrop.isEmpty()) {
      throw new CropNotFoundException();
    }

    return optionalCrop.get().getFertilizers();
  }
}
