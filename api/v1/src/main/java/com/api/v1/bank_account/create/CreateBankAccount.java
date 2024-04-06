package com.api.v1.bank_account.create;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface CreateBankAccount {

    ResponseEntity<Void> create(
        @NotBlank
        @Size(min=9, max=9, message="Phone number has 9 digits.")
        String ssn
    );
    
}
