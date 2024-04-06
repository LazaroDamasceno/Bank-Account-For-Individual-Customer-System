package com.api.v1.customer.register;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.customer.Customer;
import com.api.v1.customer.CustomerRepository;
import com.api.v1.customer.exceptions.DuplicatedCustomerException;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterCustomerService implements RegisterCustomer {
    
    private final CustomerRepository repository;

    @Override
    @Transactional
    public ResponseEntity<Void> register(@NotNull RegisterCustomerDTO dto) {
        if (isCustomerAlreadyPersisted(dto.ssn())) throw new DuplicatedCustomerException(dto.ssn());
        Customer customer = new Customer(dto);
        repository.save(customer);
        return HttpStatusCodes.CREATED_201;
    }

    private boolean isCustomerAlreadyPersisted(String ssn) {
        return repository.findBySsn(ssn).isPresent();
    }

}
