package com.api.v1.customer.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.customer.Customer;

public interface FindAllCustomer {

    ResponseEntity<List<Customer>> findAll();
    
}
