package com.tests;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {

    public static int[] burbuja(int[] array) {
        boolean bandera = true;
        while (bandera) {
            bandera = false;
            for(int i=0; i < array.length - 1; i++) {
                int actual = array[i];
                int siguiente = array[i + 1];

                if (actual > siguiente) {
                    array[i] = siguiente;
                    array[i + 1] = actual;
                    bandera = true;
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] numeros = {2,6,1};
        int[] result = new Ejercicio1().burbuja(numeros);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}






