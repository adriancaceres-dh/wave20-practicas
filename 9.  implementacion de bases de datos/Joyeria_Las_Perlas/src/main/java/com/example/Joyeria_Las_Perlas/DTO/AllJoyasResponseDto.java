package com.example.Joyeria_Las_Perlas.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
@Getter
public class AllJoyasResponseDto {
    private List<JoyaDto> listaJoyas;

    public AllJoyasResponseDto(List<JoyaDto> listaJoyas) {
        this.listaJoyas = listaJoyas;
    }
}
