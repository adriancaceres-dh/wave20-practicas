package com.bootcamp.covid.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GrupoRiesgoResponseDto {
   private String nombre;
   private String apellido;
}
