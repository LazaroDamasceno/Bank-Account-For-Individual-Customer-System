package com.api.v1.bank_account.withdraw;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/bank-account")
@CrossOrigin("http://localhost:5173/")
public class WithdrawCashController implements WithdrawCash {

    private final WithdrawCashService service;

    @Override
    @Transactional
    @PatchMapping("ssn/{ssn}/number/{number}/cash/{cash}")
    public ResponseEntity<Void> withdraw(
            @NotBlank
            @Size(min=9, max=9, message="SSN has 9 digits.")
            @PathVariable
            String ssn,

            @NotBlank
            @PathVariable
            String number,

            @NotNull
            @Positive
            @PathVariable
            double cash
    ) {
        return service.withdraw(ssn, number, cash);
    }
}
