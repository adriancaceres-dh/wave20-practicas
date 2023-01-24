package com.example.Joyeria_Las_Perlas.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
@Getter
public class JoyaCreatedDto {
    private Integer nro_identificatorio;

    public JoyaCreatedDto(Integer nro_identificatorio) {
        this.nro_identificatorio = nro_identificatorio;
    }
}
