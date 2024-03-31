package com.api.v1.bank_account.transfer;

public class ZeroedBalanceException extends RuntimeException {

    public ZeroedBalanceException() {
        super("Balance is zeroed. Please, deposit enough cash to withdraw it.");
    }
    
}
