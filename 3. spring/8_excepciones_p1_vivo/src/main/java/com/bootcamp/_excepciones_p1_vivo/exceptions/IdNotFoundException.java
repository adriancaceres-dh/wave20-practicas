package com.bootcamp._excepciones_p1_vivo.exceptions;

import org.springframework.http.ResponseEntity;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException(){}

    public IdNotFoundException(String message){super(message);}

}
