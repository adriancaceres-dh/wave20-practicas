package com.example.demoarquitectura.exceptions;


import org.springframework.web.bind.annotation.ExceptionHandler;

public class NotFoundName extends RuntimeException{

    public NotFoundName (){

    }
    public NotFoundName (String message){
        super(message);
    }


}
