package com.bootcamp.blog.exceptions;

import com.bootcamp.blog.dto.MensajeEntradaBlogResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IdAreadyExist extends RuntimeException {

    MensajeEntradaBlogResponseDto mensajeEntradaBlogResponseDto;


}
