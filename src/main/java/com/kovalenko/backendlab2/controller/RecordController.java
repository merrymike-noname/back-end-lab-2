package com.kovalenko.backendlab2.controller;

import com.kovalenko.backendlab2.entity.Record;
import com.kovalenko.backendlab2.service.RecordService;
import com.kovalenko.backendlab2.util.BindingResultValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;
    private final BindingResultValidator validator;

    @GetMapping("/record/{id}")
    public Record getRecordById(@PathVariable("id") int id) {
        return recordService.findById(id);
    }

    @PostMapping("/record")
    public Record saveRecord(@Valid @RequestBody Record record, BindingResult bindingResult) {
        validator.validate(bindingResult);
        return recordService.save(record);
    }

    @DeleteMapping("/record/{id}")
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
