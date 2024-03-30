package com.api.v1.customer.delete_all;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
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
    public Future<ResponseEntity<Void>> deleteAll() {
        return service.deleteAll();
    }
    
}
