package com.api.v1.constants;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpStatusCodes {
    
    public static final ResponseEntity<Void> CREATED_201 = new ResponseEntity<>(HttpStatus.CREATED);

    public static final ResponseEntity<Void> NO_CONTENT_204 = new ResponseEntity<>(HttpStatus.NO_CONTENT);

}
