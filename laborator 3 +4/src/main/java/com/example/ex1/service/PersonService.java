package com.example.ex1.service;

import com.example.ex1.model.Person;
import com.example.ex1.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

   public List<Person> retrieveAllPerson(){
        return personRepository.retrieveAllPerson();
   }

   public String addPerson(Person person){
        return personRepository.addPerson(person);
   }

   public String deletePerson(String firstName){
        return personRepository.deletePerson(firstName);
   }

}
