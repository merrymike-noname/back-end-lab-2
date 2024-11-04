package com.kovalenko.backendlab2.service;

import com.kovalenko.backendlab2.entity.Category;
import com.kovalenko.backendlab2.exception.CategoryNotFoundException;
import com.kovalenko.backendlab2.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category findById(int id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("No category with id " + id));
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(int id) {
        categoryRepository.delete(id);
    }
}
