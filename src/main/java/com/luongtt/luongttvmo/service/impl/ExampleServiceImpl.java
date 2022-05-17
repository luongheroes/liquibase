package com.luongtt.luongttvmo.service.impl;

import com.luongtt.luongttvmo.entity.Persons;
import com.luongtt.luongttvmo.entity.Role;
import com.luongtt.luongttvmo.model.PersonRequest;
import com.luongtt.luongttvmo.repository.PersonRepository;
import com.luongtt.luongttvmo.repository.RoleRepository;
import com.luongtt.luongttvmo.service.ExampleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ExampleServiceImpl implements ExampleService {

    PersonRepository personRepository;

    RoleRepository roleRepository;

    @Override
    public List<Persons> allPerson() {
        return personRepository.findAll();
    }

    @Override
    public Persons createPerson(PersonRequest personRequest) {
        Optional<Role> role = roleRepository.findById(personRequest.getRole());
        Persons persons = Persons.builder().name(personRequest.getName())
                .address(personRequest.getAddress())
                .role(Objects.nonNull(role)? role.get(): null)
                .build();
        return personRepository.save(persons);
    }
}
