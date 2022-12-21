package com.bootcamp.clases;

import com.bootcamp.interfaces.IImpresora;

import java.util.ArrayList;

public class Curriculum implements IImpresora {
    private String nombre;
    private String apellido;
    private int annnos;
    private ArrayList<String> habilidades;

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Curriculum");
    }
}
