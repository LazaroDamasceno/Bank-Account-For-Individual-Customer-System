package com.api.v1.bank_account.find_by_ssn;

import java.util.List;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.bank_account.BankAccount;
import com.api.v1.bank_account.BankAccountRepository;
import com.api.v1.customer.Customer;
import com.api.v1.customer.CustomerRepository;
import com.api.v1.customer.exceptions.CustomerNotFoundException;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindBankAccountsByCustomersService implements FindBankAccountsByCustomers {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRepository customerRepository;
    
    @Override
    public Future<ResponseEntity<List<BankAccount>>> findBySsn(
        @NotBlank 
        @Size(min = 9, max = 9, message = "SSN has 9 digits.") 
        String ssn
    ) {
        validateInput(ssn);
        Customer customer = customerRepository.findBySsn(ssn).get();
        return CompletableFuture.completedFuture(
            ResponseEntity.ok(
                bankAccountRepository
                    .findAll()
                    .stream()
                    .filter(e -> e.getCustomer().equals(customer))
                    .toList()
        ));
    }

    private void validateInput(String ssn) {
        if (customerRepository.findBySsn(ssn).isEmpty()) {
            throw new CustomerNotFoundException(ssn);
        }
    }
    
}
