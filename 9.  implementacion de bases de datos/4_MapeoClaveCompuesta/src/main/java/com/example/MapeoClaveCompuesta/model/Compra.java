package com.example.MapeoClaveCompuesta.model;

import com.example.MapeoClaveCompuesta.model.keys.CompraKey;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Compras")
@IdClass(value= CompraKey.class)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Compra {
    @Id
    private Long clienteId;
    @Id
    private LocalDate fecha;
    private double total;
}
