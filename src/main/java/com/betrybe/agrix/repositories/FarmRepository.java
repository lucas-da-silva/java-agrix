package com.betrybe.agrix.repositories;

import com.betrybe.agrix.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Farm interface.
 */
@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

}
