package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.entities.Person;
import com.betrybe.agrix.security.Role;

/**
 * Request Person DTO.
 */
public record PersonCreationDto(String username, String password, Role role) {

  /**
   * Create a Person entity.
   *
   * @return Person entity.
   */
  public Person toEntity() {
    Person person = new Person();

    person.setUsername(username);
    person.setPassword(password);
    person.setRole(role);

    return person;
  }

}
