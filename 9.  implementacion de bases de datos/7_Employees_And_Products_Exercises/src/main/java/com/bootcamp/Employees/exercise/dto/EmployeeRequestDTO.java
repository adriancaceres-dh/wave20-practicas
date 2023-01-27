package com.bootcamp.Employees.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {

    private String name;

    private String age;

    private String city;

    private String provinceStateDepartment;
}
