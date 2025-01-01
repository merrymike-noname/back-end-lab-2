package com.kovalenko.backendlab2.service;

import com.kovalenko.backendlab2.entity.User;
import com.kovalenko.backendlab2.exception.UserNotFoundException;
import com.kovalenko.backendlab2.repository.CurrencyRepository;
import com.kovalenko.backendlab2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No user with id " + id));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        User saved = userRepository.save(user);
        saved.setDefaultCurrency(currencyRepository.findById(user.getDefaultCurrency().getId()).get());
        return userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
