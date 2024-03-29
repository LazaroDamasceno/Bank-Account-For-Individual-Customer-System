package com.api.v1.customer;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.validation.constraints.NotBlank;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Optional<Customer> findBySsn(@NotBlank String ssn);
    
}
