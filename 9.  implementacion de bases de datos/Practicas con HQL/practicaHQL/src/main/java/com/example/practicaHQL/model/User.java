package com.example.practicaHQL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class User {
    @Id
    private Integer id;
    /*private Timestamp createdAt;
    @Column(length = 255)
    private String email;
    @Column(length = 255)
    private String name;
    @Column(length = 255)
    private String password;
    @Column(length = 100)
    private String rememberToken;
    private Timestamp updatedAt;*/
}
