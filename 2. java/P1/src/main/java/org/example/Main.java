package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String[] vectorCiudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] arr = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int min = arr[0][0];
        int indmin = 0;
        int max = arr[0][1];
        int indmax = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] < min) {
                min = arr[i][0];
                indmin = i;
            }
            if (arr[i][1] > max) {
                max = arr[i][1];
                indmax = i;
            }
        }
        System.out.println("La minima temperatura fue " + min + " y ocurrio en " + vectorCiudades[indmin]);
        System.out.println("La maxima temperatura fue " + max + " y ocurrio en " + vectorCiudades[indmax]);

    }
}