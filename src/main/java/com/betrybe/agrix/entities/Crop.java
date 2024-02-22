package com.betrybe.agrix.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity Crop.
 */
@Data
@NoArgsConstructor
@Entity
public class Crop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @Column(name = "planted_area")
  private Double plantedArea;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  @JsonIgnore
  private Farm farm;

  private LocalDate plantedDate;

  private LocalDate harvestDate;

  @ManyToMany
  @JsonIgnore
  private List<Fertilizer> fertilizers;

  @JsonProperty("farmId")
  public Long getFarmId() {
    return (farm != null) ? farm.getId() : null;
  }
}
