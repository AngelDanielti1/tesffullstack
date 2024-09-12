package com.example.crud.controller;

import com.example.crud.model.Person;
import com.example.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<?> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return new ResponseEntity<>(createResponse(true, "Persons retrieved successfully", persons), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return new ResponseEntity<>(createResponse(true, "Person retrieved successfully", person.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(createResponse(false, "Person not found", null), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return new ResponseEntity<>(createResponse(true, "Person created successfully", savedPerson), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        if (personRepository.existsById(id)) {
            person.setId(id);
            Person updatedPerson = personRepository.save(person);
            return new ResponseEntity<>(createResponse(true, "Person updated successfully", updatedPerson), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(createResponse(false, "Person not found", null), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return new ResponseEntity<>(createResponse(true, "Person deleted successfully", null), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(createResponse(false, "Person not found", null), HttpStatus.NOT_FOUND);
        }
    }

    private Object createResponse(boolean status, String msg, Object data) {
        return new ResponseObject(status, msg, data);
    }

    private static class ResponseObject {
        private boolean status;
        private String msg;
        private Object data;

        public ResponseObject(boolean status, String msg, Object data) {
            this.status = status;
            this.msg = msg;
            this.data = data;
        }

        // Getters y Setters
    }
}
