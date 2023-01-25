package com.bootcamp.testers.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Setter @Getter
@NoArgsConstructor
@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_case")
    private Long idCase;
    private String description;
    private Boolean passed;
    @Column(name = "number_of_tries")
    private Integer numberOfTries;
    @Column(name = "last_update")
    private LocalDate lastUpdate;
}
