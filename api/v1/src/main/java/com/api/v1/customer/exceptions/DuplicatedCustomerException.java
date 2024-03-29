package com.api.v1.customer.exceptions;

public class DuplicatedCustomerException  extends RuntimeException {
    
    public DuplicatedCustomerException(String ssn) {
        super("Customer whose ssn is %salready exist.".formatted(ssn));
    }

}
