package com.example.associationmapping.repos;

import com.example.associationmapping.entities.Programmer;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRepository extends CrudRepository<Programmer,Integer> {
}
