package com.example.UserDemo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.boot.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annontation.RequestMapping;
import org.springframework.web.bind.annontation.PutMapping;
import org.springframework.web.bind.annontation.GetMapping;
import org.springframework.web.bind.annontation.PutMapping;
import org.springframework.web.bind.annontation.PatchMapping;
import org.springframework.web.bind.annontation.PathVariable;
import org.springframework.web.bind.annontation.DeleteMapping;
import org.springframework.web.bind.annontation.RequestBody;
import org.springframework.web.bind.annontation.RestController;

@RequestMapping("users")
@RestController
public class PersonController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/")
    public List<Person> getAllUsers() {
        Optional<List<Person>> people = personDAO.findAll();
        return people;

    }

    @GetMapping(value = "/{id}")
    public Person getUserByID(@PathVariable("id") UUID id) {
        Optional<Person> person = personDAO.findById(id);

        // we have to use the `person.get` to actually retrieve the Person instance
        // because `findById` does not return a Java Class Object as opposed to using
        // `getOne` command. This is due to the fact that it could return null object
        // if the objects in the database is empty
        if (person.isPresent()) {
            return person.get();
        } else {
            return null;
        }

    }

    @PatchMapping
    public Person updateUserInfoPartial(@RequestBody Person newPersonInfo) {
    }

    @PutMapping

        person = newPersonInfo;
        return personDAO.save(person);


    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        Optional<Person> newPerson = personDAO.save(person);
        return newPerson;

    }

    @DeleteMapping(value = "/{id}")
    public void removePerson(@PathVariable("id") UUID id) {
        personDAO.deleteById(id);
    
    }

}
