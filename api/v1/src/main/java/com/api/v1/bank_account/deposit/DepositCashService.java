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
        double cash
    ) {
        if (isCustomerNotFound(ssn)) throw new CustomerNotFoundException(ssn);
        if (isBankAccountNotFound(number)) throw new BankAccountOwnershipException(number, ssn);
        if (cash <= 0.0) throw new DepositException();
        BankAccount bankAccount = bankAccountRepository.findByNumber(UUID.fromString(number)).get();
        bankAccount.depositCash(cash);
        bankAccountRepository.save(bankAccount);
        return HttpStatusCodes.NO_CONTENT_204;
    }

    private boolean isCustomerNotFound(String ssn) {
        return customerRepository.findBySsn(ssn).isEmpty();
    }

    private boolean isBankAccountNotFound(String number) {
        return bankAccountRepository.findByNumber(UUID.fromString(number)).isEmpty();
    }

}
