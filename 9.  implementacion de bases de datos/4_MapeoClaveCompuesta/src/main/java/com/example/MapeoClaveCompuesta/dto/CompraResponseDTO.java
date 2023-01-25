package com.example.MapeoClaveCompuesta.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CompraResponseDTO {
    Long clienteId;
    LocalDate fecha;
    Double total;
}
