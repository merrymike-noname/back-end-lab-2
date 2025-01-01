package com.kovalenko.backendlab2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "User's name is mandatory")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "default_currency_id", nullable = false)
    private Currency defaultCurrency;

    public User(String name, Currency defaultCurrency) {
        this.name = name;
        this.defaultCurrency = defaultCurrency;
    }
}
