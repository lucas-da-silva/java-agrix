package com.betrybe.agrix.repositories;

import com.betrybe.agrix.entities.Crop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Crop interface.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

  List<Crop> findByHarvestDateBetween(LocalDate start, LocalDate end);

}
