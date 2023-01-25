package com.example.practicaHQL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.sql.Timestamp;

@Entity
public class PasswordReset {

    private Timestamp createdAt;
    @Column(length = 255)
    private String email;
    @Column(length = 255)
    private String token;
}
