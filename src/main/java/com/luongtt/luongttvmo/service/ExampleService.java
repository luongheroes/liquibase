package com.luongtt.luongttvmo.service;

import com.luongtt.luongttvmo.entity.Persons;
import com.luongtt.luongttvmo.model.PersonRequest;

import java.util.List;

public interface ExampleService {

    List<Persons> allPerson();

    Persons createPerson(PersonRequest personRequest);
}
