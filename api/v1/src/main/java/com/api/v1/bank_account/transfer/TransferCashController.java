package com.api.v1.bank_account.transfer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/bank-account")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class TransferCashController implements TransferCash {

    private final TransferCashService service;

    @Override
    @Transactional
    @PatchMapping("{ssn}/{number1}/{cash}/{number2}")
    public ResponseEntity<Void> transfer(
            @NotBlank @Size(min = 9, max = 9, message = "SSN has 9 digits.") 
            @PathVariable
            String ssn, 
            
            @NotBlank 
            @PathVariable
            String number1,

            @NotNull
            @Positive
            @PathVariable
            double cash, 
            
            @NotBlank 
            @PathVariable
            String number2
    ) {
        return service.transfer(ssn, number1, cash, number2);
    }
    
}
