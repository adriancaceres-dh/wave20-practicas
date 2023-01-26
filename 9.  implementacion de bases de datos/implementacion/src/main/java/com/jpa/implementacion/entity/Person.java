package com.jpa.implementacion.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "fist_name", length = 20)
    private String name;

    @Column(length = 2)
    private Integer age;
    @Column(length = 30)
    private String city;


}
