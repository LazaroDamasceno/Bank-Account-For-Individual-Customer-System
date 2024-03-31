package com.api.v1.bank_account.deposit;

import jakarta.validation.constraints.NotNull;
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
    public Future<ResponseEntity<Void>> deposit(@NotNull @RequestBody RequestBankAccountDTO dto) {
        return service.deposit(dto);
    }

}
