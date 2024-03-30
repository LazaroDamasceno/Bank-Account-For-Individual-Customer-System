package com.api.v1.bank_account.find_all;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.bank_account.BankAccount;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/bank-accounts")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class FindAllBankAccountsController implements FindAllBankAccounts {
    
    private final FindAllBankAccountsService service;
    
    @Override
    @GetMapping
    public Future<ResponseEntity<List<BankAccount>>> findAll() {
        return service.findAll();
    }
    
}
