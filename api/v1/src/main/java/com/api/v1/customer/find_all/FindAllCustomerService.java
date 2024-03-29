package com.api.v1.customer.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.customer.Customer;
import com.api.v1.customer.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllCustomerService implements FindAllCustomer {
    
    private final CustomerRepository repository;
    
    @Override
    public Future<ResponseEntity<List<Customer>>> findAll() {
        return CompletableFuture.completedFuture(
            ResponseEntity.ok(
                repository.findAll()
            )
        );
    }
    
}
