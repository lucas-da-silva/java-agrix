package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.PersonCreationDto;
import com.betrybe.agrix.controllers.dto.PersonDto;
import com.betrybe.agrix.entities.Person;
import com.betrybe.agrix.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manage requests for the /persons route.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDto createPerson(@RequestBody PersonCreationDto personCreation) {
    Person person = personService.create(personCreation.toEntity());
    return PersonDto.fromEntity(person);
  }
}

