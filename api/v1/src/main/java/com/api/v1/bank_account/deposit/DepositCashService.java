package com.api.v1.bank_account.deposit;

import com.api.v1.bank_account.BankAccount;
import com.api.v1.bank_account.BankAccountRepository;
import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.customer.CustomerRepository;
import com.api.v1.customer.exceptions.CustomerNotFoundException;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class DepositCashService implements DepositCash {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public Future<ResponseEntity<Void>> deposit(        
        @NotBlank
        @Size(min=9, max=9, message="Ssn has 9 digits.")
        String ssn,

        @NotBlank
        String number,

        @NotNull
        @Positive
        double cash
    ) {
        validateInput(ssn, number, cash);
        BankAccount bankAccount = bankAccountRepository.findByNumber(UUID.fromString(number)).get();
        bankAccount.depositCash(cash);
        bankAccountRepository.save(bankAccount);
        return HttpStatusCodes.NO_CONTENT_204;
    }

    private void validateInput(String ssn, String number, double cash) {
        if (customerRepository.findBySsn(ssn).isPresent()) {
            throw new CustomerNotFoundException(ssn);
        }
        if (bankAccountRepository.findByNumber(UUID.fromString(number)).isEmpty()) {
            throw new BankAccountNotFoundException(number);
        }
        if (isCashLessOrEqualToZero(cash)) {
            throw new DepositException();
        }
    }

    private boolean isCashLessOrEqualToZero(double cash) {
        return cash <= 0.0;
    }

}
