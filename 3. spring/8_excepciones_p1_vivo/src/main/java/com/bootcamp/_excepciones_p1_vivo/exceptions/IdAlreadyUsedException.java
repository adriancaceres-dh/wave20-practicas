package com.bootcamp._excepciones_p1_vivo.exceptions;

public class IdAlreadyUsedException extends RuntimeException{

    public IdAlreadyUsedException(){

    }

    public IdAlreadyUsedException(String message){
        super(message);
    }

}
