package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.entities.Person;
import com.betrybe.agrix.security.Role;

/**
 * Response Person DTO.
 */
public record PersonDto(
    Long id,
    String username,
    Role role
) {

  /**
   * Create a Person DTO from a Person entity.
   *
   * @param person Person entity.
   * @return Person DTO.
   */
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(
        person.getId(),
        person.getUsername(),
        person.getRole()
    );
  }

}
