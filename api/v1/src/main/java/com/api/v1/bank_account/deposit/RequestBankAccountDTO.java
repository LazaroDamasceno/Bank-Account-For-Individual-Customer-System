package com.api.v1.bank_account.deposit;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestBankAccountDTO(
    @NotBlank
    @Size(min=9, max=9, message="Ssn has 9 digits.")
    String ssn,

    @NotBlank
    String number
) {
    
}
