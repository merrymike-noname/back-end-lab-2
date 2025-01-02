package com.kovalenko.backendlab2.security.structs;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    @NotBlank(message = "User's name is mandatory")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "Password is mandatory")
    @Size(max = 100, message = "Password must not exceed 100 characters")
    private String password;
}
