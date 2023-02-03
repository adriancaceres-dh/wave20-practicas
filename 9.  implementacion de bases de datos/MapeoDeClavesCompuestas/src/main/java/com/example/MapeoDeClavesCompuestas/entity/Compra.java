package com.example.MapeoDeClavesCompuestas.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Compra {
    @Id
    int id;

    @Column
    int costo;

    @Column()
    LocalDate fecha;

}
