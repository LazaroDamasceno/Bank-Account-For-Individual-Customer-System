package com.api.v1.customer.register;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface RegisterCustomer {

    Future<ResponseEntity<Void>> register(@NotNull RegisterCustomerDTO dto);
    
}
