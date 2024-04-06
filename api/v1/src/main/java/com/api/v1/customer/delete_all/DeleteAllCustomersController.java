package com.api.v1.customer.delete_all;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class DeleteAllCustomersController implements DeleteAllCustomers {

    private final DeleteAllCustomersService service;

    @Override
    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> deleteAll() {
        return service.deleteAll();
    }
    
}
