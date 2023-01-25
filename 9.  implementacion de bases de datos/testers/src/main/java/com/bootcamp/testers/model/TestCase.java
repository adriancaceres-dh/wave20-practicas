package com.bootcamp.testers.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Setter @Getter
@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCase;
    private String description;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
