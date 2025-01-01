package com.kovalenko.backendlab2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Category name is mandatory")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    @Column(nullable = false, unique = true)
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
