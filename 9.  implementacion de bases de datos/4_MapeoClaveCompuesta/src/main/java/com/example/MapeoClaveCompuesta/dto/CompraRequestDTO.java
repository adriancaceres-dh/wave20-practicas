package com.example.MapeoClaveCompuesta.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
@Data
public class CompraRequestDTO {
    Long clienteId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    LocalDate fecha;
    Double total;
}
