package com.api.v1.customer.register;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.customer.Customer;
import com.api.v1.customer.CustomerRepository;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterCustomerService implements RegisterCustomer {
    
    private final CustomerRepository repository;

    @Override
    public Future<ResponseEntity<Void>> register(@NotNull RegisterCustomerDTO dto) {
        Customer customer = new Customer(dto);
        repository.save(customer);
        return HttpStatusCodes.CREATED_201;
    }

}
