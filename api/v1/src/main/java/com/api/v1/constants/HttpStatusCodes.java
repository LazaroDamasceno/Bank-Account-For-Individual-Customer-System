package com.api.v1.constants;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpStatusCodes {
    
    public static final CompletableFuture<ResponseEntity<Void>> CREATED_201 = CompletableFuture
        .completedFuture(
            new ResponseEntity<>(HttpStatus.CREATED)
    );

    public static final CompletableFuture<ResponseEntity<Void>> NO_CONTENT_204 = CompletableFuture
    .completedFuture(
        new ResponseEntity<>(HttpStatus.NO_CONTENT)
    );

}
