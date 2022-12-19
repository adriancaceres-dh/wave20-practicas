package com.bootcamp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a = 0;
        try{
            PracticaExepciones.dividir(a);
        }catch (IllegalArgumentException i){
            System.out.println("No se puede dividir por 0");
        }

    }
}