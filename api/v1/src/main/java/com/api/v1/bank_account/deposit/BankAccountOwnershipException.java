package com.api.v1.bank_account.deposit;

public class BankAccountOwnershipException extends RuntimeException {
    
    public BankAccountOwnershipException(String ssn, String number) {
        super("Bank account whose number is %s is not owned by customer whose ssn is %s".formatted(number, ssn));
    }

}
