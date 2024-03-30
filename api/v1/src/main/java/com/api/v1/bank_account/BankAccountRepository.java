package com.api.v1.bank_account;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, UUID> {
    
}
