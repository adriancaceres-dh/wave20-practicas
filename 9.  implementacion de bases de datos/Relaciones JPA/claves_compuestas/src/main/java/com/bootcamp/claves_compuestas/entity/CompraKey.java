package com.bootcamp.claves_compuestas.entity;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CompraKey implements Serializable {

    private Integer clienteId;
    private LocalDate fecha;
}
