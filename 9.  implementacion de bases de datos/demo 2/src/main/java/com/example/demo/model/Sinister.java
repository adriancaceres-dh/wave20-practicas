package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "siniestros")
@Where(clause = "eliminado = false")
public class Sinister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fecha;
    private Double perdida_economica;
    private boolean eliminado;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Vehicle vehicle;

}
