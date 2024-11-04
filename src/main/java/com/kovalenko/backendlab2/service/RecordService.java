package com.kovalenko.backendlab2.service;

import com.kovalenko.backendlab2.entity.Record;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {
    public Record findById(int id) {
        return new Record(1, 1, 10);
    }

    public Record save(Record record) {
        return record;
    }

    public void delete(int id) {
        System.out.println("record was deleted");
    }

    public List<Record> filterRecords(Optional<Integer> userId, Optional<Integer> categoryId) {
        return List.of(new Record(1, 1, 10));
    }
}
