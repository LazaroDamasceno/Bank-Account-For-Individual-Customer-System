package com.api.v1.customer.update;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface UpdateCustomer {

    ResponseEntity<Void> update(
        @NotBlank 
        @Size(min=9, max=9, message="Phone number has 9 digits.")
        String ssn, 
        @NotNull UpdateCustomerDTO dto
    );
    
}
