package com.example.associationmapping.repos;

import com.example.associationmapping.entities.License;
import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License,Integer> {
}
