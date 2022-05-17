package com.sample.example.service;

import com.sample.example.entity.Persons;
import com.sample.example.model.PersonRequest;

import java.util.List;

public interface ExampleService {

    List<Persons> allPerson();

    Persons createPerson(PersonRequest personRequest);
}
