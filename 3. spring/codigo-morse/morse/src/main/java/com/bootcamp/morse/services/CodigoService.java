package com.bootcamp.morse.services;

import com.bootcamp.morse.repository.CodigoMorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class CodigoService {


    @Autowired
    CodigoMorseRepository codigoMorseRepository;


    public String getCodigo(String codeMorse){

        String[] codes = codeMorse.split("   ");


        StringBuilder salida = new StringBuilder();


        Arrays.stream(codes)
                .map(e -> generarPalabra(e))
                .forEach(e -> salida.append(e + " "));

        return salida.toString();


    }


    private String generarPalabra (String palabraMorse){

        // Generar un arreglo de caracteres codigo morse
        String[] codigosMorse = palabraMorse.split(" ");

        StringBuilder palabra = new StringBuilder();

        // Iterar sobre cada caracter y obtener su letra equivalente, concatenar en la salida
        Arrays.stream(codigosMorse)
                .map(e -> codigoMorseRepository.getCodigo(e))
                .forEach(palabra::append);

        return palabra.toString();
    }










    

}
