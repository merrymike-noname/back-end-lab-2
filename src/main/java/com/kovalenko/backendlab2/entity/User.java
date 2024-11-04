package com.kovalenko.backendlab2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private int id;
    private String name;

    public User(String name) {
        this.name = name;
    }
}
