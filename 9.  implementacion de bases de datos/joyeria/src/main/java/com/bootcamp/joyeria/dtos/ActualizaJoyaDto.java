package com.bootcamp.joyeria.dtos;

import com.bootcamp.joyeria.util.Params;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
@NoArgsConstructor
public class ActualizaJoyaDto extends MensajeDto {
    private JoyaResponseDto joyaActualizada;

    public ActualizaJoyaDto(JoyaResponseDto joyaResponseDto) {
        super(Params.obtenerString("JoyaActualizada"), HttpStatus.OK.value());
        this.joyaActualizada = joyaResponseDto;
    }
}
