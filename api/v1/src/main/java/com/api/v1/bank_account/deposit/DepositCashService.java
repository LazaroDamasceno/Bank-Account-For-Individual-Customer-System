package com.api.v1.bank_account.deposit;

import com.api.v1.bank_account.BankAccount;
import com.api.v1.bank_account.BankAccountRepository;
import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.customer.CustomerRepository;
import com.api.v1.customer.exceptions.CustomerNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class 3efdffb2-e303-4a70-9c90-f7dda5023511 implements DepositCash {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public Future<ResponseEntity<Void>> deposit(@NotNull RequestBankAccountDTO dto) {
        if (isCustomerNotFound(dto.ssn())) throw new CustomerNotFoundException(dto.ssn());
        if (isBankAccountNotFound(dto.number())) throw new BankAccountOwnershipException(dto);
        BankAccount bankAccount = bankAccountRepository.findByNumber(UUID.fromString(dto.number())).get();
        bankAccount.depositCash(dto.cash());
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
