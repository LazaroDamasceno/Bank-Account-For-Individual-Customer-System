package com.api.v1.bank_account.deposit;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public interface DepositCash {
    
    ResponseEntity<Void> deposit(    
        @NotBlank
        @Size(min=9, max=9, message="Ssn has 9 digits.")
        String ssn,

        @NotBlank
        String number,

        @NotNull
        @Positive
        double cash
    );

}
