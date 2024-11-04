package com.kovalenko.backendlab2.repository;

import com.kovalenko.backendlab2.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class CategoryRepository {
    private int id;
    private final Map<Integer, Category> db = new HashMap<>();

    public Optional<Category> findById(int id) {
        try {
            return Optional.of(db.get(id));
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    public Category save(Category category) {
        category.setId(id++);
        db.put(category.getId(), category);
        return category;
    }

    public void delete(int id) {
        db.remove(id);
    }
}
