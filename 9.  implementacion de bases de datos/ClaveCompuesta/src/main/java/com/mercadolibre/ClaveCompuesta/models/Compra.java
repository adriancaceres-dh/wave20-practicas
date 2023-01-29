package com.mercadolibre.ClaveCompuesta.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@IdClass(value = Compra.class)
public class Compra implements Serializable {
    @Id
    private String clienteId;
    @Id
    private LocalDate fecha;


}
