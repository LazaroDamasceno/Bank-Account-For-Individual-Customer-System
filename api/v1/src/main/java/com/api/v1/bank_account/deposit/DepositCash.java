package com.api.v1.bank_account.deposit;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface DepositCash {
    
    Future<ResponseEntity<Void>> deposit(@NotNull RequestBankAccountDTO dto);

}
