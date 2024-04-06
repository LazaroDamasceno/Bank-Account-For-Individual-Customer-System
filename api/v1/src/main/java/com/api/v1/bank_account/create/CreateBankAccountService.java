package com.api.v1.bank_account.create;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.bank_account.BankAccount;
import com.api.v1.bank_account.BankAccountRepository;
import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.customer.Customer;
import com.api.v1.customer.CustomerRepository;
import com.api.v1.customer.exceptions.CustomerNotFoundException;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateBankAccountService implements CreateBankAccount {

    private final CustomerRepository repository;
    private final BankAccountRepository bankAccountRepository;
    
    @Override
    @Transactional
    public ResponseEntity<Void> create(
        @NotBlank
        @Size(min=9, max=9, message="Phone number has 9 digits.")
        String ssn
    ) {
        Customer customer = findCustomerBySsn(ssn);
        BankAccount bankAccount = new BankAccount(customer);
        bankAccountRepository.save(bankAccount);
        return HttpStatusCodes.CREATED_201;
    }

    private Customer findCustomerBySsn(
            @NotBlank 
            @Size(min=9, max=9, message="Phone number has 9 digits.") 
            String ssn
    ) {
        Optional<Customer> optional = repository.findBySsn(ssn);
        if (optional.isEmpty()) throw new CustomerNotFoundException(ssn);
        return optional.get();
    }

}
