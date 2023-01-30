package com.bootcamp.MiniSeries.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // Levantar un objeto base de esta clase en el contenedor de Spring
@Table(name = "mini_series") // Configuraciones de esta tabla, como por ejemplo un nombre diferente
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", length = 20)
    private String name;

    private Double rating;
    private Integer amountOfAwards;
}

