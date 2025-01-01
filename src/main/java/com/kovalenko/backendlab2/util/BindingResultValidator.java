package com.kovalenko.backendlab2.util;

import com.kovalenko.backendlab2.exception.InvalidDataException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BindingResultValidator {

    public void validate(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            String errorMessage = String.join(", ", errorMessages);
            throw new InvalidDataException(errorMessage);
        }
    }
}
