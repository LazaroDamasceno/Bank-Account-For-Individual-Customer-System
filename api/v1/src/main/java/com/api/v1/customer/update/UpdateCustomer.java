package com.api.v1.customer.update;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface UpdateCustomer {

    Future<ResponseEntity<Void>> update(@NotBlank String ssn, @NotNull UpdateCustomerDTO dto);
    
}
