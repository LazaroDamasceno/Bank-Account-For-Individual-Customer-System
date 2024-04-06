package com.api.v1.customer.delete_all;

import org.springframework.http.ResponseEntity;

public interface DeleteAllCustomers {

    ResponseEntity<Void> deleteAll();
    
}
