package com.example.DTO.Models;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private int id;
    private String name;
    private String last_name;
    private int age;
    private int[] symptoms;

    public Person(int id, String name, String last_name, int age, int[] symptoms) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.symptoms=symptoms;
    }
}
