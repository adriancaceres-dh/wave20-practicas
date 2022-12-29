package com.bootcamp.blog.exeption;

import com.bootcamp.blog.dto.MensajeEntradaBlogResponseDto;
import com.bootcamp.blog.dto.MensajeExeptionDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter @Setter
public class IdExistExeption extends RuntimeException{

    private MensajeExeptionDto mensajeExeptionDto;

    public IdExistExeption(MensajeExeptionDto mensajeExeptionDto) {
        this.mensajeExeptionDto = mensajeExeptionDto;
    }

    public IdExistExeption(String message) {
        super(message);
    }

}
