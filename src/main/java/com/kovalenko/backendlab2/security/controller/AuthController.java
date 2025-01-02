package com.kovalenko.backendlab2.security.controller;

import com.kovalenko.backendlab2.security.service.AuthService;
import com.kovalenko.backendlab2.security.structs.AuthenticationRequest;
import com.kovalenko.backendlab2.security.structs.AuthenticationResponse;
import com.kovalenko.backendlab2.security.structs.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @Valid @RequestBody RegisterRequest request,
            BindingResult bindingResult
    ) {
        return ResponseEntity.ok(authService.register(request, bindingResult));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @Valid @RequestBody AuthenticationRequest request,
            BindingResult bindingResult
    ) {
        return ResponseEntity.ok(authService.authenticate(request, bindingResult));
    }
}
