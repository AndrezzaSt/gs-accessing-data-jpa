package com.example.gsaccessingdatajpa.services;

import com.example.gsaccessingdatajpa.Customer;
import com.example.gsaccessingdatajpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public List<Customer> findAll() {

        return (List<Customer>) repo.findAll();
    }

    public Optional<Customer> findbyId(Long id) {

        return repo.findById(id);
    }

   public List<Customer> findByLastName(String lastName) {
        return repo.findByLastName(lastName);
    }

    public Customer Save(Customer obj) {
        return repo.save(obj);
    }
}
