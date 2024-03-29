package com.api.v1.customer.delete_all;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;

public interface DeleteAll {

    Future<ResponseEntity<Void>> deleteAll();
    
}
