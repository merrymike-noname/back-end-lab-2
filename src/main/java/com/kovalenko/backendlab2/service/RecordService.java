package com.kovalenko.backendlab2.service;

import com.kovalenko.backendlab2.entity.Record;
import com.kovalenko.backendlab2.exception.EmptyParametersException;
import com.kovalenko.backendlab2.exception.RecordNotFoundException;
import com.kovalenko.backendlab2.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;

    public Record findById(int id) {
        return recordRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No record with id " + id));
    }

    public Record save(Record record) {
        return recordRepository.save(record);
    }

    public void delete(int id) {
        recordRepository.delete(id);
    }

    public List<Record> filterRecords(Optional<Integer> userId, Optional<Integer> categoryId) {
        if (userId.isEmpty() && categoryId.isEmpty()) {
            throw new EmptyParametersException("Both filter parameters are empty");
        }
        return recordRepository.filterRecords(userId, categoryId);
    }
}
