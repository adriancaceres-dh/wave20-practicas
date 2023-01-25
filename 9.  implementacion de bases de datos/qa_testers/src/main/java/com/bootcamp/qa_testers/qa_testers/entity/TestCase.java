package com.bootcamp.qa_testers.qa_testers.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TestCases")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long idCase;
    private String description;
    private boolean tested;
    private boolean passed;
    @Column(name = "number_of_tries")
    private Integer numberOfTries;
    @Column(name = "last_update")
    private LocalDate lastUpdate;
}
