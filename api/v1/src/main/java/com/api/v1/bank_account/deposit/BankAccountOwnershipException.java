package com.api.v1.bank_account.deposit;

import jakarta.validation.constraints.NotNull;

public class BankAccountOwnershipException extends RuntimeException {

    public BankAccountOwnershipException(@NotNull RequestBankAccountDTO dto) {
        super("Bank account whose number is %s is not owned by customer whose ssn is %s.".formatted(dto.number(), dto.ssn()));
    }

}
