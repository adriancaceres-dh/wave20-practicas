package com.bootcamp.testing.dto;

import com.bootcamp.testing.entity.Student;

import lombok.Data;
import lombok.Getter;

@Data
public class StudentResponseDto {
    
    private String id;
    private String name;
    private int edad;

    public StudentResponseDto(Student student) {
       this.id = student.getId();
       this.edad = student.getEdad();
       this.name = student.getName();
    }
}
