package com.example.practicaHQL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

import java.sql.Timestamp;


@Table(name = "password_resets")
public class PasswordReset {
    private Timestamp createdAt;
    @Column(length = 255)
    private String email;
    @Column(length = 255)
    private String token;
}
