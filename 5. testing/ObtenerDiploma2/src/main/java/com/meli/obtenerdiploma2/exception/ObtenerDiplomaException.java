package com.meli.obtenerdiploma2.exception;


import com.meli.obtenerdiploma2.model.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ObtenerDiplomaException extends RuntimeException {

    private final ErrorDTO error;
    private final HttpStatus status;

    public ObtenerDiplomaException(String message, HttpStatus status) {
        super(message);
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }

}