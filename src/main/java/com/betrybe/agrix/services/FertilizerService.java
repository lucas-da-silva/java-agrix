package com.betrybe.agrix.services;

import com.betrybe.agrix.entities.Fertilizer;
import com.betrybe.agrix.exceptions.FertilizerNotFound;
import com.betrybe.agrix.repositories.FertilizerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Layer service for entity Fertilizer.
 */
@Service
public class FertilizerService {

  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  public Fertilizer save(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }

  public List<Fertilizer> findAll() {
    return fertilizerRepository.findAll();
  }

  public Fertilizer findById(Long id) {
    return fertilizerRepository.findById(id).orElseThrow(FertilizerNotFound::new);
  }

}
