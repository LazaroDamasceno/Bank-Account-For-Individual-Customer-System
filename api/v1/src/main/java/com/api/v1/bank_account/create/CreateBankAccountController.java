package com.api.v1.bank_account.create;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/bank-account")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class CreateBankAccountController implements CreateBankAccount {

    private final CreateBankAccountService service;

    @Override
    @PostMapping("{ssn}")
    @Transactional
    public ResponseEntity<Void> create(
        @NotBlank
        @Size(min=9, max=9, message="Phone number has 9 digits.")
        @PathVariable
        String ssn
    ) {
        return service.create(ssn);
    }

}
