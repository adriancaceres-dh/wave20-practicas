package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Where;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
@Where(clause = "eliminado = false")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String patente;
    private String marca;
    private String modelo;
    private Long fabricacion;
    private Integer cantidad_ruedas;
    private boolean eliminado;
    @JsonIgnore
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    @Nullable
    private List<Sinister> sinisters;
    @OneToOne(mappedBy = "vehicle")
    private Person person;

}
