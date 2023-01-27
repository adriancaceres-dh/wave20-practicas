package com.bootcamp.employees.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Getter @Setter
@Document(indexName = "employees_spring")
@TypeAlias("employee")
public class Employee {

    @Id
    private Integer id;
    @Field("first_name")
    private String firstName;
    @Field("last_name")
    private String lastName;
    private Integer age;
    private String city;
    private String state;
}
