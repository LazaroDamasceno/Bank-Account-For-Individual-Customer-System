package com.api.v1.customer.register;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface RegisterCustomer {

    ResponseEntity<Void> register(@NotNull RegisterCustomerDTO dto);
    
}
