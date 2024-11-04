package com.kovalenko.backendlab2.repository;

import com.kovalenko.backendlab2.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private int id;
    private final Map<Integer, User> db = new HashMap<>();

    public Optional<User> findById(int id) {
        try {
            return Optional.of(db.get(id));
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    public List<User> findAll() {
        return db.values().stream().toList();
    }

    public User save(User user) {
        user.setId(id++);
        db.put(user.getId(), user);
        return user;
    }

    public void delete(int id) {
        db.remove(id);
    }
}
