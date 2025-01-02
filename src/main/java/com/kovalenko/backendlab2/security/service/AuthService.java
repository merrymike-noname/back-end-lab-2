package com.kovalenko.backendlab2.security.service;

import com.kovalenko.backendlab2.entity.Currency;
import com.kovalenko.backendlab2.entity.Role;
import com.kovalenko.backendlab2.entity.User;
import com.kovalenko.backendlab2.exception.CurrencyNotFountException;
import com.kovalenko.backendlab2.exception.UserNotFoundException;
import com.kovalenko.backendlab2.repository.CurrencyRepository;
import com.kovalenko.backendlab2.repository.UserRepository;
import com.kovalenko.backendlab2.security.structs.AuthenticationRequest;
import com.kovalenko.backendlab2.security.structs.AuthenticationResponse;
import com.kovalenko.backendlab2.security.structs.RegisterRequest;
import com.kovalenko.backendlab2.util.BindingResultValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final CurrencyRepository currencyRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final BindingResultValidator validator;

    public AuthenticationResponse register(RegisterRequest request,
                                           BindingResult bindingResult) {
        validator.validate(bindingResult);
        Currency currency;
        if (currencyRepository.findCurrencyByCode(request.getDefaultCurrency().getCode()).isPresent()) {
            currency = currencyRepository.findCurrencyByCode(request.getDefaultCurrency().getCode()).get();
        } else {
            currency = currencyRepository.save(
                    new Currency(request.getDefaultCurrency().getCode(), request.getDefaultCurrency().getName()));
        }

        var user = User.builder()
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .defaultCurrency(currency)
                .build();
        repository.save(user);
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request,
                                               BindingResult bindingResult) {
        validator.validate(bindingResult);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getName(),
                        request.getPassword()
                )
        );
        var user = repository.findByName(request.getName())
                .orElseThrow(() -> new UserNotFoundException("No user found with name: " + request.getName()));
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }
}
