package com.api.v1.customer.update;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateCustomerDTO(
    @NotBlank
    String name,

    @NotBlank
    Date birthDay,

    @NotBlank
    String email,

    @NotBlank
    String address,

    @NotBlank
    @Size(min=10, max=10, message="Phone number has 10 digits.")
    String phoneNumber
) {
    
}
