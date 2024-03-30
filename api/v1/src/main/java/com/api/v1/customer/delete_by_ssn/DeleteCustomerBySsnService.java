package com.api.v1.customer.delete_by_ssn;

import java.util.Optional;
import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.customer.Customer;
import com.api.v1.customer.CustomerRepository;
import com.api.v1.customer.exceptions.CustomerNotFoundException;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteCustomerBySsnService implements DeleteCustomerBySsn {

    private final CustomerRepository repository;

    @Override
    public Future<ResponseEntity<Void>> deleteBySsn(
        @NotBlank 
        @Size(min=9, max=9, message="Phone number has 9 digits.")
        String ssn 
    ) {
        Customer customer = findCustomerBySsn(ssn);
        if (customer == null) throw new CustomerNotFoundException(ssn);
        repository.delete(customer);
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
