package com.betrybe.agrix.repositories;

import com.betrybe.agrix.entities.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Fertilizer interface.
 */
@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

}
