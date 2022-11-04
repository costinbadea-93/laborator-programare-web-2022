package com.example.ex1.controller;

import com.example.ex1.model.Person;
import com.example.ex1.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonRestController {
    private final PersonService personService;

    public PersonRestController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/people")
    public List<Person> personList(){
        return personService.retrieveAllPerson();
    }

}
