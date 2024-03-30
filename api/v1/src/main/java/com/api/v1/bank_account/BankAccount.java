package com.api.v1.bank_account;

import java.util.UUID;

import com.api.v1.customer.Customer;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "v1_bank_account")
@Getter
@Setter
@NoArgsConstructor
public class BankAccount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private final UUID number = UUID.randomUUID();

    private double balance = 0.0;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "v1_customer")
    private Customer customer;

    public BankAccount(Customer customer) {
        this.customer = customer;
    }

}
