package com.api.v1.customer.delete_by_ssn;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class DeleteCustomerBySsnController implements DeleteCustomerBySsn {
    
    private final DeleteCustomerBySsnService service;
    
    @Override
    @DeleteMapping("{ssn}")
    public Future<ResponseEntity<Void>> deleteBySsn(
            @NotBlank 
            @Size(min = 9, max = 9, message = "Phone number has 9 digits.") 
            @PathVariable
            String ssn
    ) {
        return service.deleteBySsn(ssn);
    }
    
}
