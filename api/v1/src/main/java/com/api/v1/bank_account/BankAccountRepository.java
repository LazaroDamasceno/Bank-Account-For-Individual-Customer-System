package com.api.v1.bank_account;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BankAccountRepository extends JpaRepository<BankAccount, UUID> {

    Optional<BankAccount> findByNumber(UUID number);

    @Query("""
        select bk from BankAccount bk
        where bk.number = :number 
        and bk.customer.ssn = :ssn
    """)
    BankAccount getBankAccount(@Param(value = "ssn") String ssn, @Param(value = "number") UUID number);

}
