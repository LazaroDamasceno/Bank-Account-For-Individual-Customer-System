package com.api.v1.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    
    public CustomerNotFoundException(String ssn) {
        super("Customer whose ssn is %s was not found.".formatted(ssn));
    }

}
