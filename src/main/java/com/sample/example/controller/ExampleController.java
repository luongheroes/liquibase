package com.sample.example.controller;

import com.sample.example.entity.Persons;
import com.sample.example.model.PersonData;
import com.sample.example.model.PersonRequest;
import com.sample.example.service.ExampleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ExampleController {
    private ExampleService exampleService;

    @GetMapping("/person/all")
    public List<Persons> getAllPersons() {
        return exampleService.allPerson();
    }

    @PostMapping("/person")
    public Persons getAllPersons(@RequestBody PersonRequest personRequest) {
        return exampleService.createPerson(personRequest);
    }

    @GetMapping("/personXml/{id}")
    public PersonData getPersonXmlById(@PathVariable("id") Long id) {
        return exampleService.findByIdXml(id);
    }

    @GetMapping("/person/{id}")
    public PersonData getPersonById(@PathVariable("id") Long id) {
        return exampleService.findById(id);
    }
}
