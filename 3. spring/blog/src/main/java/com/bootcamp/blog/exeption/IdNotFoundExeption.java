package com.bootcamp.blog.exeption;

import com.bootcamp.blog.dto.MensajeExeptionDto;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class IdNotFoundExeption extends RuntimeException{
    private MensajeExeptionDto mensajeExeptionDto;

    public IdNotFoundExeption(MensajeExeptionDto mensajeExeptionDto) {
        this.mensajeExeptionDto = mensajeExeptionDto;
    }

    public MensajeExeptionDto getMensajeExeptionDto() {
        return mensajeExeptionDto;
    }
}
