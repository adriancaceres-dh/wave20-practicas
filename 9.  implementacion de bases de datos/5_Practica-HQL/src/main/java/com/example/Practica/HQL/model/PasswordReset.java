package com.example.Practica.HQL.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="password_resets")
public class PasswordReset {

    @Column(nullable = false, length = 255)
    private String email;
    @Column(nullable = false, length = 255)
    private String token;
    @Column(columnDefinition = "timestamp")
    private LocalDate createdAt;

}
