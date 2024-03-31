package com.api.v1.bank_account.deposit;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface DepositCash {
    
    Future<ResponseEntity<Void>> deposit(    
        @NotBlank
        @Size(min=9, max=9, message="Ssn has 9 digits.")
        String ssn,

        @NotBlank
        String number,

        @NotBlank
        double cash
    );

}
