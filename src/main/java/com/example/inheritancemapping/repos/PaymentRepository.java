package com.example.inheritancemapping.repos;

import com.example.inheritancemapping.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {
}
