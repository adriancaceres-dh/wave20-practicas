package com.bootcamp.be_java_hisp_w20_g4_stocco.excepcion;

public class BadRequestException extends  RuntimeException{
    public BadRequestException() {
    }
    public BadRequestException(String message){
     super(message);

    }

}
