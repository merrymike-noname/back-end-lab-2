package com.kovalenko.backendlab2.repository;

import com.kovalenko.backendlab2.entity.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Integer> {
    Optional<Currency> findCurrencyByCode(String code);
}
