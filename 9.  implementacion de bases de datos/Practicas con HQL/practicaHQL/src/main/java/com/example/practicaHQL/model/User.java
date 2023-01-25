package com.example.practicaHQL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class User {
    private Timestamp createdAt;
    @Column(length = 255)
    private String email;
    private Integer id;
    @Column(length = 255)
    private String name;
    @Column(length = 255)
    private String password;
    @Column(length = 100)
    private String rememberToken;
    private Timestamp updatedAt;
}
