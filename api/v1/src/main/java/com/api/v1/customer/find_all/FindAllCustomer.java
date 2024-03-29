package com.api.v1.customer.find_all;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;

import com.api.v1.customer.Customer;

public interface FindAllCustomer {

    Future<ResponseEntity<List<Customer>>> findAll();
    
}
