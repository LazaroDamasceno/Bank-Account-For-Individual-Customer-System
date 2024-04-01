package com.api.v1.bank_account.transfer;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public interface TransferCash {

    Future<ResponseEntity<Void>> transfer(
        @NotBlank
        @Size(min=9, max=9, message="SSN has 9 digits.")
        String ssn,

        @NotBlank
        String number1,

        @NotNull
        @Positive
        double cash,

        @NotBlank
        String number2
    );
    
}
