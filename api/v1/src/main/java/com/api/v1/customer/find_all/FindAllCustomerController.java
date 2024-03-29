package com.api.v1.customer.find_all;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.customer.Customer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class FindAllCustomerController implements FindAllCustomer {
    
    private final FindAllCustomerService service;
    
    @Override
    @GetMapping
    public Future<ResponseEntity<List<Customer>>> findAll() {
        return service.findAll();
    }
    
}
