package com.api.v1.bank_account.transfer;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.bank_account.BankAccount;
import com.api.v1.bank_account.BankAccountRepository;
import com.api.v1.bank_account.deposit.BankAccountNotFoundException;
import com.api.v1.bank_account.deposit.BankAccountOwnershipException;
import com.api.v1.bank_account.deposit.DepositException;
import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.customer.CustomerRepository;
import com.api.v1.customer.exceptions.CustomerNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferCashService implements TransferCash {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public ResponseEntity<Void> transfer(
            @NotBlank 
            @Size(min = 9, max = 9, message = "SSN has 9 digits.") 
            String ssn, 
            
            @NotBlank 
            String number1,

            @NotNull
            @Positive
            double cash, 
            
            @NotBlank 
            String number2
        ) {
            validateInput(ssn, number1, cash, number2);

            BankAccount bankAccount1 = getBankAccount(number1);
            bankAccount1.withDrawnCash(cash);
            bankAccountRepository.save(bankAccount1);
            
            BankAccount bankAccount2 = getBankAccount(number2);
            bankAccount2.depositCash(cash);
            bankAccountRepository.save(bankAccount2);
            
            return HttpStatusCodes.NO_CONTENT_204;
    }   

    private void validateInput(String ssn, String number1, double cash, String number2) {
        if (customerRepository.findBySsn(ssn).isEmpty()) {
            throw new CustomerNotFoundException(ssn);
        }
        if (cash <= 0.0) {
            throw new DepositException();
        }
        validateBankAccount(ssn, number1, cash);
        if (bankAccountRepository.findByNumber(UUID.fromString(number2)).isEmpty()) {
            throw new BankAccountNotFoundException(number2);
        }
    }

    private void validateBankAccount(String ssn, String number, double cash) {
        if (bankAccountRepository.findByNumber(UUID.fromString(number)).isEmpty()) {
            throw new BankAccountNotFoundException(number);
        }
        if (bankAccountRepository.getBankAccount(ssn, UUID.fromString(number)) == null) {
            throw new BankAccountOwnershipException(ssn, number);
        }
        BankAccount bankAccount = bankAccountRepository.findByNumber(UUID.fromString(number)).get();
        if (bankAccount.getBalance() < cash) {
            throw new NotEnoughBalanceException();
        }
    }

    private BankAccount getBankAccount(String number) {
        return bankAccountRepository.findByNumber(UUID.fromString(number)).orElseThrow(() -> new BankAccountNotFoundException(number));
    }
}
