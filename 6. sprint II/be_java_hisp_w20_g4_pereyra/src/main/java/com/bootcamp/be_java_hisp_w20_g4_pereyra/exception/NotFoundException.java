//package main.java.com.bootcamp.be_java_hisp_w20_g4.excepcion;
package com.bootcamp.be_java_hisp_w20_g4_pereyra.exception;
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }
    public NotFoundException(String message){
       super(message);
    }
}
