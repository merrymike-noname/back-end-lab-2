package com.kovalenko.backendlab2.service;

import com.kovalenko.backendlab2.entity.Currency;
import com.kovalenko.backendlab2.exception.CurrencyNotFountException;
import com.kovalenko.backendlab2.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    public Currency findById(int id) {
        return currencyRepository.findById(id).orElseThrow(() -> new CurrencyNotFountException("No currency with id " + id));
    }

    public Currency findByCode(String code) {
        return currencyRepository.findCurrencyByCode(code).orElseThrow(() -> new CurrencyNotFountException("No currency with code: " + code));
    }

    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }

    public void delete(int id) {
        currencyRepository.deleteById(id);
    }
}
