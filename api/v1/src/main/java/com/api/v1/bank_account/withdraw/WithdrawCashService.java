package com.api.v1.bank_account.withdraw;

import com.api.v1.bank_account.BankAccount;
import com.api.v1.bank_account.BankAccountRepository;
import com.api.v1.bank_account.deposit.BankAccountNotFoundException;
import com.api.v1.bank_account.deposit.BankAccountOwnershipException;
import com.api.v1.bank_account.deposit.DepositException;
import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.customer.CustomerRepository;
import com.api.v1.customer.exceptions.CustomerNotFoundException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class WithdrawCashService implements WithdrawCash  {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public Future<ResponseEntity<Void>> withdraw(
            @NotBlank
            @Size(min=9, max=9, message="SSN has 9 digits.")
            String ssn,

            @NotBlank
            String number,

            @NotNull
            @Positive
            double cash
    ) {
        validateInput(ssn, number, cash);
        BankAccount bankAccount = getBankAccount(number);
        bankAccount.withDrawnCash(cash);
        bankAccount.depositCash(cash);
        bankAccountRepository.save(bankAccount);
        return HttpStatusCodes.NO_CONTENT_204;
    }

    private void validateInput(String ssn, String number, double cash) {
        if (customerRepository.findBySsn(ssn).isEmpty()) {
            throw new CustomerNotFoundException(ssn);
        }
        validateBankAccount(ssn, number, cash);
    }

    private void validateBankAccount(String ssn, String number, double cash) {
        if (bankAccountRepository.findByNumber(UUID.fromString(number)).isEmpty()) {
            throw new BankAccountNotFoundException(number);
        }
        if (bankAccountRepository.getBankAccount(ssn, UUID.fromString(number)) == null) {
            throw new BankAccountOwnershipException(ssn, number);
        }
        if (cash <= 0.0) {
            throw new DepositException();
        }
    }

    private BankAccount getBankAccount(String number) {
        return bankAccountRepository.findByNumber(UUID.fromString(number)).orElseThrow(() -> new BankAccountNotFoundException(number));
    }

}
