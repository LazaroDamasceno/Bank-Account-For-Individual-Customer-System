package com.api.v1.bank_account.deposit;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Future;

@RestController
@RequestMapping("api/v1/bank-account")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class DepositCastController implements DepositCash {

    private final DepositCashService service;

    @Override
    @PatchMapping
    public Future<ResponseEntity<Void>> deposit(        
        @NotBlank
        @Size(min=9, max=9, message="Ssn has 9 digits.")
        @PathVariable
        String ssn,

        @NotBlank
        @PathVariable
        String number,

        @NotBlank
        @PathVariable
        double cash
    ) {
        return service.deposit(ssn, number, cash);
    }

}
