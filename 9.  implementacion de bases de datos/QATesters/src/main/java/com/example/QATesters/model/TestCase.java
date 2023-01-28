package com.example.QATesters.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "caso_prueba")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @Column(name = "number_of_tries")
    private int numberOfTries;
    @Column(name = "last_update")
    private LocalDate lastUpdate;
}
