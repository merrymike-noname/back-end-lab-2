package com.kovalenko.backendlab2.security.structs;

import com.kovalenko.backendlab2.entity.CurrencyDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "User's name is mandatory")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "Password is mandatory")
    @Size(max = 100, message = "Password must not exceed 100 characters")
    private String password;

    private CurrencyDto defaultCurrency;
}
