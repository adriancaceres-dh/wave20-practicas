package com.jpa.la_perla.excepcion;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class NotFound extends Exception{

    private int status;
    private String message;
}
