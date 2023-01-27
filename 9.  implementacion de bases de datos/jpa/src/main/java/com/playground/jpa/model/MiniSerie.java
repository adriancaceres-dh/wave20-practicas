package com.playground.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 5. Crear una clase MiniSerie dentro del paquete “model”, que tenga los atributos Long id, String name, Double rating e int amount_of_awards.
// 6. Para la clase del MiniSerie, generar sus métodos Getters y Setters y anotarla con @Entity. Anotar también el atributo id con @Id y su correspondiente estrategia de @GeneratedValue.

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double rating;
    private int amount_of_awards;
}
