package com.betrybe.agrix.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Test PersonService class")
public class PersonServiceTest {

  @Autowired
  PersonRepository personRepository;

  @Test
  @DisplayName("Create a new person")
  void testCreate() {
    Person person = new Person();
    person.setUsername("firstUser");
    person.setPassword("firstPassword");
    person.setRole(Role.USER);

    Person savedPerson = personRepository.save(person);

    assertEquals(savedPerson.getUsername(), person.getUsername());
    assertEquals(savedPerson.getPassword(), person.getPassword());
    assertEquals(savedPerson.getRole(), person.getRole());

  }

  @Test
  @DisplayName("Returns the person by ID")
  void testGetPersonById() {
    Person person = new Person();
    person.setUsername("secondUser");
    person.setPassword("secondPassword");
    person.setRole(Role.USER);

    Person savedPerson = personRepository.save(person);

    PersonService personService = new PersonService(personRepository);
    Person result = personService.getPersonById(1L);

    assertEquals(result.getUsername(), savedPerson.getUsername());
    assertEquals(result.getPassword(), savedPerson.getPassword());
    assertEquals(result.getRole(), savedPerson.getRole());
  }

  @Test
  @DisplayName("Throws an error when called with a non-existent ID")
  void testGetPersonByIdThrowException() {
    PersonService personService = new PersonService(personRepository);

    Assertions.assertThrows(PersonNotFoundException.class, () -> {
      personService.getPersonById(999L);
    });
  }

  @Test
  @DisplayName("Return the person by user name")
  void testGetPersonByUserName() {
    Person person = new Person();
    person.setUsername("thirdUser");
    person.setPassword("thirdPassword");
    person.setRole(Role.USER);

    Person savedPerson = personRepository.save(person);

    PersonService personService = new PersonService(personRepository);
    Person result = personService.getPersonByUsername("thirdUser");

    assertEquals(result.getUsername(), savedPerson.getUsername());
    assertEquals(result.getPassword(), savedPerson.getPassword());
    assertEquals(result.getRole(), savedPerson.getRole());
  }


  @Test
  @DisplayName("Throws an error when called with a non-existent user name")
  void testGetPersonByUserNameThrowException() {
    PersonService personService = new PersonService(personRepository);

    Assertions.assertThrows(PersonNotFoundException.class, () -> {
      personService.getPersonByUsername("aaaaaaaaaaaaaaaaaaaa");
    });
  }
}
