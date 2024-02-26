package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FertilizerCreationDto;
import com.betrybe.agrix.entities.Fertilizer;
import com.betrybe.agrix.services.FertilizerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manage requests for the /fertilizers route.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;

  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Fertilizer createFertilizer(@RequestBody FertilizerCreationDto fertilizer) {
    return fertilizerService.save(fertilizer.toEntity());
  }

  @Secured("ADMIN")
  @GetMapping
  public List<Fertilizer> getAllFertilizers() {
    return fertilizerService.findAll();
  }

  @GetMapping("/{id}")
  public Fertilizer getFertilizerById(@PathVariable Long id) {
    return fertilizerService.findById(id);
  }

}
