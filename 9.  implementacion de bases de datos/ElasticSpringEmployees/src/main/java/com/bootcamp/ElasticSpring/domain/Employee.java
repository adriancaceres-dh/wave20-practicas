package com.bootcamp.ElasticSpring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "employees")
@TypeAlias("employee")
public class Employee {

    @Id
    private String id;

    private String name;

    private String lastname;

    private Integer age;

    private String city;

    private String state;

}
