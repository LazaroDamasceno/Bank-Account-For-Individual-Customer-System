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
public class DepositCashService implements DepositCash {

    private final BankAccountRepository repository;
    private final CustomerRepository customerRepository;

    @Override
    public Future<ResponseEntity<Void>> deposit(@NotNull RequestBankAccountDTO dto) {
        if (isCustomerNotFound(dto.ssn())) throw new CustomerNotFoundException(dto.ssn());
        if (isBankAccountNotFound(dto.number())) throw new BankAccountOwnershipException(dto);
        BankAccount bankAccount = repository.findByNumber(UUID.fromString(dto.number())).get();
        bankAccount.depositCash(dto.cash());
        repository.save(bankAccount);
        return HttpStatusCodes.NO_CONTENT_204;
    }

    private boolean isCustomerNotFound(String ssn) {
        return customerRepository.findBySsn(ssn).isEmpty();
    }

    private boolean isBankAccountNotFound(String number) {
        return repository.findByNumber(UUID.fromString(number)).isEmpty();
    }

}
