package com.JPA.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Persona")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "primer_nombre", length = 20)
    private String firstname;

    @Column(name = "apellido", length = 20)
    private String lastname;

    @Column(length = 10)
    private String dni;

    @Column(name = "fecha_nacimiento")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @Column(name = "edad", length = 2)
    private Short age;

    @Column(name = "salario", precision = 2)
    private Double salary;

    /*@OneToOne(mappedBy = "person")
    private Client client;*/
}
