package com.bootcamp.ElasticSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private String id;

    private String name;

    private String lastname;

    private Integer age;

    private String city;

    private String state;

}
