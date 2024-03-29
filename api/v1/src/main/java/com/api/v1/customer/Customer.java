package com.api.v1.customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.api.v1.customer.register.RegisterCustomerDTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "v1_customer")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String ssn;

    @Column(nullable = false)
    private LocalDate birthDay;
    
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    public Customer(RegisterCustomerDTO dto) {
        this.name = dto.name();
        this.ssn = dto.ssn();
        this.birthDay = LocalDate.parse(dto.birthDay(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.email = dto.email();
        this.address = dto.address();
        this.phoneNumber = dto.phoneNumber();
    }

}
