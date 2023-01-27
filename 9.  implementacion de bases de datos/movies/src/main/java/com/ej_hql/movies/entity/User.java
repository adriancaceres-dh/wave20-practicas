package com.ej_hql.movies.entity;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class User {

    @Id
    private Integer id;

    //varchar(255)
    private String name;

    //varchar(255)
    private String email;

    //varchar(255)
    private String password;

    //varchar(100)
    private String rememberToken;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
