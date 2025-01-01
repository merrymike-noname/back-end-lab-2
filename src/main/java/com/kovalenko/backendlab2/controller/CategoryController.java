package com.kovalenko.backendlab2.controller;

import com.kovalenko.backendlab2.entity.Category;
import com.kovalenko.backendlab2.service.CategoryService;
import com.kovalenko.backendlab2.util.BindingResultValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final BindingResultValidator validator;

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") int id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public Category saveCategory(@Valid @RequestBody Category category, BindingResult bindingResult) {
        validator.validate(bindingResult);
        return categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        categoryService.delete(id);
    }
}
