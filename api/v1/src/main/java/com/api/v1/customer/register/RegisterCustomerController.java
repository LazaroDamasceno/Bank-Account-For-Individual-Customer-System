package com.api.v1.customer.register;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class RegisterCustomerController implements RegisterCustomer {
    
    private final RegisterCustomerService service;
    
    @Override
    @PostMapping
    @Transactional
    public ResponseEntity<Void> register(@NotNull @RequestBody RegisterCustomerDTO dto) {
        return service.register(dto);
    }
    
}
