package com.example.segurosvehiculos.dtos.response;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatenteMarcaModeloResponseDTO {
  private String patente;
  private String marca;
  private String modelo;
}
