package com.api.v1.bank_account.find_by_ssn;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;

import com.api.v1.bank_account.BankAccount;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface FindBankAccountsByCustomers {

    Future<ResponseEntity<List<BankAccount>>> findBySsn(
        @NotBlank
        @Size(min=9, max=9, message="SSN has 9 digits.")
        String ssn
    );
    
}
