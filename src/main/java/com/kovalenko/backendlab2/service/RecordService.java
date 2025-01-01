package com.kovalenko.backendlab2.service;

import com.kovalenko.backendlab2.entity.Category;
import com.kovalenko.backendlab2.entity.Currency;
import com.kovalenko.backendlab2.entity.Record;
import com.kovalenko.backendlab2.entity.User;
import com.kovalenko.backendlab2.exception.*;
import com.kovalenko.backendlab2.repository.CategoryRepository;
import com.kovalenko.backendlab2.repository.CurrencyRepository;
import com.kovalenko.backendlab2.repository.RecordRepository;
import com.kovalenko.backendlab2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final CurrencyRepository currencyRepository;

    public Record findById(int id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No record with id " + id));
    }

    public Record save(Record record) {
        User user = userRepository.findById(record.getUser().getId())
                .orElseThrow(() -> new UserNotFoundException("No user with id " + record.getUser().getId()));
        record.setUser(user);
        if (record.getCurrency() == null) {
            record.setCurrency(user.getDefaultCurrency());
        } else {
            record.setCurrency(currencyRepository.findById(record.getCurrency().getId())
                    .orElseThrow(() -> new CurrencyNotFountException("No currency with id " + record.getCurrency().getId())));
        }
        Category category = categoryRepository.findById(record.getCategory().getId())
                .orElseThrow(() -> new CategoryNotFoundException("No category with id " + record.getCategory().getId()));
        record.setCategory(category);
        record.setCreatedAt(LocalDateTime.now());
        return recordRepository.save(record);
    }

    public void delete(int id) {
        recordRepository.deleteById(id);
    }

    public List<Record> filterRecords(Optional<Integer> userId, Optional<Integer> categoryId) {
        if (userId.isEmpty() && categoryId.isEmpty()) {
            throw new EmptyParametersException("Both filter parameters are empty");
        }
        return recordRepository.filterRecords(userId.orElse(null), categoryId.orElse(null));
    }
}
