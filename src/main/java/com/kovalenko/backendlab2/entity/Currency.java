package com.kovalenko.backendlab2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Currency code is mandatory")
    @Size(max = 3, message = "Currency code must have 3 letters (ISO code format)")
    @Column(nullable = false, unique = true, length = 3)
    private String code; // "USD", "EUR"

    @NotBlank(message = "Currency name is mandatory")
    @Size(max = 100, message = "Currency name must not exceed 100 characters")
    @Column(nullable = false, unique = true)
    private String name; // "US Dollar", "Euro"

    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
