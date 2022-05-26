package com.sample.example.service.impl;

import com.sample.example.entity.Persons;
import com.sample.example.entity.Role;
import com.sample.example.mapper.PersonMapper;
import com.sample.example.mapper.PersonMapperXml;
import com.sample.example.model.PersonData;
import com.sample.example.model.PersonRequest;
import com.sample.example.repository.PersonRepository;
import com.sample.example.repository.RoleRepository;
import com.sample.example.service.ExampleService;
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

    PersonMapper personMapper;

    PersonMapperXml personMapperXml;

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

    @Override
    public PersonData findByIdXml(Long id) {
        return personMapperXml.findPersonById(id);
    }

    @Override
    public PersonData findById(Long id) {
        return personMapper.findById(id);
    }
}
