package com.example.MapeoClaveCompuesta.model.keys;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter @EqualsAndHashCode
public class CompraKey implements Serializable {

    private Long clienteId;
    private LocalDate fecha;


}
