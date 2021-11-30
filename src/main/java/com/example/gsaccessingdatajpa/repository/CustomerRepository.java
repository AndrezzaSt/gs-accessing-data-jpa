package com.example.gsaccessingdatajpa.repository;

import java.util.List;
import java.util.Optional;

import com.example.gsaccessingdatajpa.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

}