package com.api.v1.bank_account.deposit;

import jakarta.validation.constraints.NotBlank;

public class BankAccountOwnershipException extends RuntimeException {

    public BankAccountOwnershipException(@NotBlank String number, @NotBlank String ssn) {
        super("Bank account whose number is %s is not owned by customer whose ssn is %s.".formatted(number, ssn));
    }

}
