package com.api.v1.customer.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.customer.Customer;
import com.api.v1.customer.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllCustomerService implements FindAllCustomer {
    
    private final CustomerRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(
                repository.findAll()
        );
    }
    
}
