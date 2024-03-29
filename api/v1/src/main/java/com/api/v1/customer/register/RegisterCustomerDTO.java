package com.api.v1.customer.register;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterCustomerDTO(
    @NotBlank
    String name,

    @NotBlank
    @Size(min=9, max=9, message="Phone number has 9 digits.")
    String ssn,

    @NotBlank
    String birthDay,

    @NotBlank
    String email,

    @NotBlank
    @Size(min=10, max=10, message="Phone number has 10 digits.")
    String phoneNumber,

    @NotBlank
    String address
) {
    
}
