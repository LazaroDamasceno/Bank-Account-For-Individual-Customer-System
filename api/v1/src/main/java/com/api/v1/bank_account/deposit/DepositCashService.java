package com.api.v1.bank_account.deposit;

import com.api.v1.bank_account.BankAccount;
import com.api.v1.bank_account.BankAccountRepository;
import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.customer.CustomerRepository;
import com.api.v1.customer.exceptions.CustomerNotFoundException;

import jakarta.validation.constraints.NotBlank;
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

        @NotBlank
        String cash
    ) {
        validateInput(ssn, number, cash);
        BankAccount bankAccount = bankAccountRepository.findByNumber(UUID.fromString(number)).get();
        bankAccount.depositCash(cash);
        bankAccountRepository.save(bankAccount);
        return HttpStatusCodes.NO_CONTENT_204;
    }

    private void validateInput(String ssn, String number, String cash) {
        if (isCustomerNotFound(ssn)) throw new CustomerNotFoundException(ssn);
        if (isBankAccountNotFound(number)) throw new BankAccountNotFoundException(number);
        if (isCashLessOrEqualToZero(cash)) throw new DepositException();
    }

    private boolean isCustomerNotFound(String ssn) {
        return customerRepository.findBySsn(ssn).isEmpty();
    }

    private boolean isBankAccountNotFound(String number) {
        return bankAccountRepository.findByNumber(UUID.fromString(number)).isEmpty();
    }

    private boolean isCashLessOrEqualToZero(String cash) {
        return Double.parseDouble(cash) <= 0.0;
    }

}
