package com.kovalenko.backendlab2.repository;

import com.kovalenko.backendlab2.entity.Record;
import com.kovalenko.backendlab2.exception.CategoryNotFoundException;
import com.kovalenko.backendlab2.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RecordRepository {
    private int id;
    private final Map<Integer, Record> db = new HashMap<>();
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public Optional<Record> findById(int id) {
        try {
            return Optional.of(db.get(id));
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    public Record save(Record record) {
        userRepository.findById(record.getUserId())
                .orElseThrow(() -> new UserNotFoundException("No user with id " + record.getUserId()));
        categoryRepository.findById(record.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("No category with id " + record.getCategoryId()));
        Record savedRecord = new Record(record.getUserId(), record.getCategoryId(), record.getAmount());
        savedRecord.setId(id++);
        db.put(savedRecord.getId(), savedRecord);
        return savedRecord;
    }

    public void delete(int id) {
        db.remove(id);
    }

    public List<Record> filterRecords(Optional<Integer> userId, Optional<Integer> categoryId) {
        return db.values().stream()
                .filter(record -> userId.map(id -> id == record.getUserId()).orElse(true))
                .filter(record -> categoryId.map(id -> id == record.getCategoryId()).orElse(true))
                .collect(Collectors.toList());
    }
}
