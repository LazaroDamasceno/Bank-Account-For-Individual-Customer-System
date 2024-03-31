package com.api.v1.bank_account.deposit;

public class DepositException extends RuntimeException {

    public DepositException() {
        super("The cash to be deposited must me motr than 0.0");
    }
    
}
