package com.api.v1.bank_account.transfer;

import java.util.UUID;
import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.bank_account.BankAccount;
import com.api.v1.bank_account.BankAccountRepository;
import com.api.v1.bank_account.deposit.BankAccountNotFoundException;
import com.api.v1.bank_account.deposit.DepositException;
import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.customer.CustomerRepository;
import com.api.v1.customer.exceptions.CustomerNotFoundException;

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
    public Future<ResponseEntity<Void>> transfer(
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

            BankAccount bankAccount1 = bankAccountRepository.findByNumber(UUID.fromString(number1)).get();
            bankAccount1.withDrawnCash(cash);
            bankAccountRepository.save(bankAccount1);
            
            BankAccount bankAccount2 = bankAccountRepository.findByNumber(UUID.fromString(number2)).get();
            bankAccount2.depositCash(cash);
            bankAccountRepository.save(bankAccount2);
            
            return HttpStatusCodes.NO_CONTENT_204;
    }   

    private void validateInput(String ssn, String number1, double cash, String number2) {
        if (isCustomerNotFound(ssn)) throw new CustomerNotFoundException(ssn);
        if (isBankAccountNotFound(number1)) throw new BankAccountNotFoundException(number1);
        if (isCashLessOrEqualToZero(cash)) throw new DepositException();
        BankAccount bankAccount1 = bankAccountRepository.findByNumber(UUID.fromString(number1)).get();
        if (isBalanceZeroed(bankAccount1) || isBalanceNotEnough(bankAccount1, cash)) throw new NoEnoughBalanceException();
        if (isBankAccountNotFound(number2)) throw new BankAccountNotFoundException(number2);
    }

    private boolean isCustomerNotFound(String ssn) {
        return customerRepository.findBySsn(ssn).isEmpty();
    }

    private boolean isBankAccountNotFound(String number) {
        return bankAccountRepository.findByNumber(UUID.fromString(number)).isEmpty();
    }

    private boolean isCashLessOrEqualToZero(double cash) {
        return cash <= 0.0;
    }

    private boolean isBalanceZeroed(BankAccount bankAccount) {
        return bankAccount.getBalance() <= 0.0;
    }

    private boolean isBalanceNotEnough(BankAccount bankAccount, double cash) {
        return bankAccount.getBalance() < cash;
    }
    
}
