package com.kovalenko.backendlab2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Record {
    private int id;
    private int userId;
    private int categoryId;
    private LocalDateTime createdAt;
    private double amount;

    public Record(int userId, int categoryId, double amount) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.createdAt = LocalDateTime.now();
        this.amount = amount;
    }
}
