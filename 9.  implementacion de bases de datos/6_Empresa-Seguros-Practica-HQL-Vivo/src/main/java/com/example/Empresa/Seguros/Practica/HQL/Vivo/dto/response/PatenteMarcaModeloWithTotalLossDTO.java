package com.example.Empresa.Seguros.Practica.HQL.Vivo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaModeloWithTotalLossDTO {

    private Double totalLoss;
    private List<PatenteMarcaModeloDTO> lista;

}
