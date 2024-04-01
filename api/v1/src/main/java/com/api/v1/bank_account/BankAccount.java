package com.api.v1.bank_account;

import java.math.BigDecimal;
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

    private BigDecimal balance = BigDecimal.ZERO;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "v1_customer")
    private Customer customer;

    public BankAccount(Customer customer) {
        this.customer = customer;
    }

    public void depositCash(String cash) {
        this.balance = this.balance.add(new BigDecimal(cash));
    }

    public void withDrawnCash(String cash) {
        this.balance = this.balance.subtract(new BigDecimal(cash));
    }

}
