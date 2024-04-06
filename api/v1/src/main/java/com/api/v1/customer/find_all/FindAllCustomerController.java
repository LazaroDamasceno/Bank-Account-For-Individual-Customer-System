package com.api.v1.customer.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.customer.Customer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class FindAllCustomerController implements FindAllCustomer {
    
    private final FindAllCustomerService service;
    
    @Override
    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<Customer>> findAll() {
        return service.findAll();
    }
    
}
