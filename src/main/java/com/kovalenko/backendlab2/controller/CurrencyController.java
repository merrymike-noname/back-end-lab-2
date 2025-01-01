package com.kovalenko.backendlab2.controller;

import com.kovalenko.backendlab2.entity.Currency;
import com.kovalenko.backendlab2.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping("/{id}")
    public Currency getCurrencyById(@PathVariable("id") int id) {
        return currencyService.findById(id);
    }

    @GetMapping
    public Currency getCurrencyByCode(@RequestParam(value = "code") String code) {
        return currencyService.findByCode(code);
    }

    @PostMapping
    public Currency saveCurrency(@RequestBody Currency currency) {
        return currencyService.save(currency);
    }

    @DeleteMapping("/{id}")
    public void deleteCurrency(@PathVariable("id") int id) {
        currencyService.delete(id);
    }
}
