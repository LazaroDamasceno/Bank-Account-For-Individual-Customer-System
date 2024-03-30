package com.api.v1.bank_account.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.bank_account.BankAccount;
import com.api.v1.bank_account.BankAccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllBankAccountsService implements FindAllBankAccounts {

    private final BankAccountRepository repository;

    @Override
    public Future<ResponseEntity<List<BankAccount>>> findAll() {
        return CompletableFuture.completedFuture(
            ResponseEntity.ok(
                repository.findAll()
            )
        );
    }
    
}
