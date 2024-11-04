package com.kovalenko.backendlab2.service;

import com.kovalenko.backendlab2.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public User findById(int id) {
        return new User("name");
    }

    public List<User> findAll() {
        return List.of(new User("name"));
    }

    public User save(User user) {
        return user;
    }

    public void delete(int id) {
        System.out.println("user was deleted");
    }
}
