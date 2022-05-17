package com.luongtt.luongttvmo.controller;

import com.luongtt.luongttvmo.entity.Persons;
import com.luongtt.luongttvmo.model.PersonRequest;
import com.luongtt.luongttvmo.service.ExampleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
