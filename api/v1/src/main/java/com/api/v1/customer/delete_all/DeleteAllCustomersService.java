package com.api.v1.customer.delete_all;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.bank_account.BankAccountRepository;
import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.customer.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteAllCustomersService implements DeleteAllCustomers {

    private final CustomerRepository customerRepository;
    private final BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public ResponseEntity<Void> deleteAll() {
        bankAccountRepository.deleteAll();
        customerRepository.deleteAll();
        return HttpStatusCodes.NO_CONTENT_204;
    }
    
}
