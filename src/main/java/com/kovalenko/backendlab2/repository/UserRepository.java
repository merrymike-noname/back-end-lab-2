package com.kovalenko.backendlab2.repository;

import com.kovalenko.backendlab2.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    List<User> findAll();
    Optional<User> findByName(String name);
}
