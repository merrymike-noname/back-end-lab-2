package com.kovalenko.backendlab2.repository;

import com.kovalenko.backendlab2.entity.Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends CrudRepository<Record, Integer> {
    @Query("SELECT r FROM Record r WHERE " +
            "(:userId IS NULL OR r.user.id = :userId) AND " +
            "(:categoryId IS NULL OR r.category.id = :categoryId)")
    List<Record> filterRecords(@Param("userId") Integer userId, @Param("categoryId") Integer categoryId);
}
