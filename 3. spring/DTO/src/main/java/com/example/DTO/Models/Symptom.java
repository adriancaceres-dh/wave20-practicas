package com.example.DTO.Models;

import lombok.Data;

@Data
public class Symptom {
    private int code;
    private String name;
    private String severity_level;

    public Symptom(int code, String name, String severity_level) {
        this.code = code;
        this.name = name;
        this.severity_level = severity_level;
    }
}
