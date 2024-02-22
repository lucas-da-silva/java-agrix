package com.betrybe.agrix.services;

import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.entities.Farm;
import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.repositories.CropRepository;
import com.betrybe.agrix.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Layer service for entity Farm.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;
  private final CropRepository cropRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  public Farm save(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> findAll() {
    return farmRepository.findAll();
  }

  public Farm findById(Long id) {
    return farmRepository.findById(id)
        .orElseThrow(FarmNotFoundException::new);
  }

  /**
   * Create a new Crop and add the Farm relationship.
   *
   * @param farmId Farm id.
   * @param crop   Crop object.
   * @return Crop created or null.
   */
  public Crop setCrop(Long farmId, Crop crop) {
    Optional<Farm> optionalFarm = farmRepository.findById(farmId);

    if (optionalFarm.isEmpty()) {
      throw new FarmNotFoundException();
    }

    crop.setFarm(optionalFarm.get());
    return cropRepository.save(crop);
  }

  /**
   * Find Crops by Farm ID.
   *
   * @param farmId Farm ID.
   * @return List of Crops associated with the Farm ID.
   */
  public List<Crop> findCropsByFarmId(Long farmId) {
    Optional<Farm> optionalFarm = farmRepository.findById(farmId);

    if (optionalFarm.isEmpty()) {
      throw new FarmNotFoundException();
    }

    return optionalFarm.get().getCrop();
  }
}


