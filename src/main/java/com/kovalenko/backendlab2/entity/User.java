package com.kovalenko.backendlab2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "User's name is mandatory")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank(message = "Password is mandatory")
    @Size(max = 100, message = "Password must not exceed 100 characters")
    @Column(nullable = false, unique = true)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "default_currency_id", nullable = false)
    private Currency defaultCurrency;

    public User(String name, Currency defaultCurrency) {
        this.name = name;
        this.defaultCurrency = defaultCurrency;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return name;
    }
}
