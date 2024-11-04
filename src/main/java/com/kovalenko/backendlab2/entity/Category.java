package com.kovalenko.backendlab2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Category {
    private int id;
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
