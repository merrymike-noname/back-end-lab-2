package com.kovalenko.backendlab2.controller;

import com.kovalenko.backendlab2.entity.Record;
import com.kovalenko.backendlab2.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @GetMapping("/{id}")
    public Record getRecordById(@PathVariable("id") int id) {
        return recordService.findById(id);
    }

    @PostMapping
    public Record saveRecord(@RequestBody Record record) {
        return recordService.save(record);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable("id") int id) {
        recordService.delete(id);
    }

    @GetMapping("/records")
    public List<Record> getFilteredRecords(
            @RequestParam(required = false) Integer userId,
            @RequestParam(required = false) Integer categoryId) {
        return recordService.filterRecords(
                Optional.ofNullable(userId),
                Optional.ofNullable(categoryId));
    }
}
