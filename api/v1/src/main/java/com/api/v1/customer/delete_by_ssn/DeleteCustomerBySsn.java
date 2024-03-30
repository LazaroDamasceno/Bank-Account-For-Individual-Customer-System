package com.api.v1.customer.delete_by_ssn;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface DeleteCustomerBySsn {

    Future<ResponseEntity<Void>> deleteBySsn(       
        @NotBlank 
        @Size(min=9, max=9, message="Phone number has 9 digits.")
        String ssn
    );

}