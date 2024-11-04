package com.kovalenko.backendlab2.service;

import com.kovalenko.backendlab2.entity.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    public Category findById(int id) {
        return new Category("name");
    }

    public Category save(Category category) {
        return category;
    }

    public void delete(int id) {
        System.out.println("category was deleted");
    }
}
