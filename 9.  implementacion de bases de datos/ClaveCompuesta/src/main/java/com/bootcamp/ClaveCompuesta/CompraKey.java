package com.bootcamp.ClaveCompuesta;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
public class CompraKey implements Serializable {
    private Long clienteId;
    private LocalDate fecha;
}
