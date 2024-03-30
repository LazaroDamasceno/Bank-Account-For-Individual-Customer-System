package com.api.v1.customer.update;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class UpdateCustomerController implements UpdateCustomer {
    
    private final UpdateCustomerService service;

    @Override
    @PutMapping("{ssn}")
    public Future<ResponseEntity<Void>> update(
        @NotBlank 
        @Size(min=9, max=9, message="Phone number has 9 digits.")
        @PathVariable 
        String ssn, 
        
        @NotNull 
        @RequestBody 
        UpdateCustomerDTO dto) 
    {
        return service.update(ssn, dto);
    }

}
