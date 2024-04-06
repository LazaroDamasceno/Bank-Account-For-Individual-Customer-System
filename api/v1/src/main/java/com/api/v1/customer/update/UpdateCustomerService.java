package com.api.v1.customer.update;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.customer.Customer;
import com.api.v1.customer.CustomerRepository;
import com.api.v1.customer.exceptions.CustomerNotFoundException;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateCustomerService implements UpdateCustomer {
    
    private final CustomerRepository repository;
    
    @Override
    @Transactional
    public ResponseEntity<Void> update(
        @NotBlank 
        @Size(min=9, max=9, message="Phone number has 9 digits.") 
        String ssn, 
        
        @NotNull UpdateCustomerDTO dto
    ) {
        Customer customer = findCustomerBySsn(ssn);
        customer.setName(dto.name());
        customer.setBirthDay(dto.birthDay());
        customer.setEmail(dto.email());
        customer.setAddress(dto.address());
        customer.setPhoneNumber(dto.phoneNumber());
        repository.save(customer);
        return HttpStatusCodes.NO_CONTENT_204;
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
