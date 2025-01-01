package com.kovalenko.backendlab2.controller;

import com.kovalenko.backendlab2.entity.User;
import com.kovalenko.backendlab2.service.UserService;
import com.kovalenko.backendlab2.util.BindingResultValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final BindingResultValidator validator;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public User saveUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        validator.validate(bindingResult);
        return userService.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
    }
}
