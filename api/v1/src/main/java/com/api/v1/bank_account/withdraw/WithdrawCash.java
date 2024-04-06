package com.api.v1.bank_account.withdraw;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;

public interface WithdrawCash {

    ResponseEntity<Void> withdraw(
        @NotBlank
        @Size(min=9, max=9, message="SSN has 9 digits.")
        String ssn,

        @NotBlank
        String number,

        @NotNull
        @Positive
        double cash
    );

}
