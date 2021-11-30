package com.example.gsaccessingdatajpa.controller;


import com.example.gsaccessingdatajpa.Customer;
import com.example.gsaccessingdatajpa.repository.CustomerRepository;
import com.example.gsaccessingdatajpa.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;


    // Uma rota que permita recuperar todos os clientes do BD;
    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    //PathVariable usamos para identificadores unicos(como id)
    // Uma rota que permita recuperar um cliente pelo seu ID;
    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") Long id) {
        return service.findbyId(id).stream().findFirst().orElseThrow();
    }

    // Uma rota que permita recuperar clientes por sobrenome
    //http://localhost:8080/customers/lastName?lastName=Sturm
    @GetMapping("/lastName")
    public List<Customer> findByLastName(@RequestParam String lastName) {
        return service.findByLastName(lastName);
    }


    // Uma rota que permita salvar um cliente no Bano de Dados;
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Customer obj) {
        obj = service.Save(obj);
        //endereco do novo objeto que será inserido, isto é uma boa prática
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build(); //created retorna o cod 201
    }


}
