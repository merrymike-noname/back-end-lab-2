package com.kovalenko.backendlab2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "User ID is mandatory")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull(message = "Category ID is mandatory")
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @NotNull(message = "Currency is mandatory")
    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Min(value = 0, message = "Amount must be greater than or equal to 0")
    @Column(nullable = false)
    private double amount;

    public Record(User user, Category category, double amount, Currency currency) {
        this.user = user;
        this.category = category;
        this.createdAt = LocalDateTime.now();
        this.amount = amount;
        this.currency = currency;
    }
}
