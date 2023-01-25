package com.bootcamp.MiniSeries.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "miniserie")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private Long id;
    private String name;
    private Double rating;
    @Column(name= "amount_of_awards")
    private int amountOfAwards;

}
