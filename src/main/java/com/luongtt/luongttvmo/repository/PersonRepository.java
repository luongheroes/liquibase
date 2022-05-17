package com.luongtt.luongttvmo.repository;

import com.luongtt.luongttvmo.entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PersonRepository extends JpaRepository<Persons, Integer> {
}
