package com.api.v1.bank_account.find_all;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;

import com.api.v1.bank_account.BankAccount;

public interface FindAllBankAccounts {
    
    Future<ResponseEntity<List<BankAccount>>> findAll();

}
