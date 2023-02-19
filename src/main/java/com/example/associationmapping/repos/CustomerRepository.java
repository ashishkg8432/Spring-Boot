package com.example.associationmapping.repos;

import com.example.associationmapping.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
