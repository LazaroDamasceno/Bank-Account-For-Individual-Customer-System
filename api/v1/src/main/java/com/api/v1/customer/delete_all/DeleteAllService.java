package com.api.v1.customer.delete_all;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.customer.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteAllService implements DeleteAll {

    private final CustomerRepository repository;

    @Override
    public Future<ResponseEntity<Void>> deleteAll() {
        repository.deleteAll();
        return HttpStatusCodes.NO_CONTENT_204;
    }
    
}
