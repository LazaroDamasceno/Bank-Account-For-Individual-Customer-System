package com.api.v1.bank_account.deposit;

import jakarta.validation.constraints.NotBlank;

public class BankAccountNotFoundException extends RuntimeException {

    public BankAccountNotFoundException(@NotBlank String number) {
        super("Bank account whose number is %s is not found.".formatted(number));
    }

}
