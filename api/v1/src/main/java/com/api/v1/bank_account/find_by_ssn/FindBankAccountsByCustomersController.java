package com.api.v1.bank_account.find_by_ssn;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.bank_account.BankAccount;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/bank-accounts")
@RequiredArgsConstructor
public class FindBankAccountsByCustomersController implements FindBankAccountsByCustomers {

    private final FindBankAccountsByCustomersService service;

    @Override
    @GetMapping("{ssn}")
    public Future<ResponseEntity<List<BankAccount>>> findBySsn(
            @NotBlank 
            @Size(min = 9, max = 9, message = "SSN has 9 digits.") 
            @PathVariable
            String ssn
    ) {
        return service.findBySsn(ssn);
    }
    
}
