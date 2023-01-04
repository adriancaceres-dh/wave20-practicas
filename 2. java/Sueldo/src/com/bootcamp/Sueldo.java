package com.bootcamp;

import java.util.Scanner;

public class Sueldo {

    String dni ; // dni de ejemplo
    double sueldoBase;  // monto de ejemplo
    double sueldoConAumento;

    Scanner teclado = new Scanner(System.in);

    public void calcularAumento() {


        System.out.println("Ingrese su número de documento: ");
        dni = teclado.next();
        System.out.println("Ingrese su sueldo base: ");
        sueldoBase = teclado.nextDouble();

        if (sueldoBase<=20000) {
            sueldoConAumento = sueldoBase * 1.20;
            System.out.println ("El nuevo sueldo del empleado con dni " + dni + " es de: " + sueldoConAumento);

        }
        else {
            if (20000<sueldoBase && sueldoBase<=45000){
                sueldoConAumento = sueldoBase * 1.10;
                System.out.println ("El nuevo sueldo del empleado con dni " + dni + " es de: " + sueldoConAumento);
            }
            else {
                sueldoConAumento= sueldoBase * 1.05;
                System.out.println ("El nuevo sueldo del empleado con dni " + dni + " es de: " + sueldoConAumento);
            }
        }
    }

    public static void main(String[] args) {
        new Sueldo().calcularAumento();
    }

}