package com.example.QATesters.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @Column(name = "id_case")
    private Long idCase;

    private String description;

    private Boolean tested;

    private Boolean passed;

    @Column(name = "number_of_tries")
    private Integer numberOfTries;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

}
