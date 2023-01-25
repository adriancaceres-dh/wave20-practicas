package com.example.practicaClaveCompuestasYRelaciones.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class CompraKey implements Serializable {
    private Date fecha;
    private Integer clienteId;
    private String cajero;
    private Integer numCaja;
}
