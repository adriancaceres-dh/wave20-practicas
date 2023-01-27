package com.example.MapeoDeUnaClaveCompuesta.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {

    private Integer clientid;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    private String articulo;
}
