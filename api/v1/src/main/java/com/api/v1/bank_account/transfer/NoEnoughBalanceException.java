package com.api.v1.bank_account.transfer;

public class NoEnoughBalanceException extends RuntimeException {

    public NoEnoughBalanceException() {
        super("Balance is not enought to be withdrawn. Please, deposit enough cash to withdraw it.");
    }
    
}