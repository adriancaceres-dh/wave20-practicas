package com.bootcamp;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("Juego de adivinanzas");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Ingrese un nro. (0-Termina)");
            int numero = scanner.nextInt();
            if(numero==0) break;
            Persona turista = new Turista("Carlos");
            boolean resultadoTurista = turista.jugar(numero);
            Persona banca = new Banca("Jose");
            boolean resultadoBanca = banca.jugar(numero);
            if(resultadoTurista == resultadoBanca) {
                System.out.println("Empate, gana banca");
            } else {
                if (resultadoBanca) {
                    System.out.println("Gana banca");
                } else {
                    System.out.println("Gana turista");
                }
            }
        }


    }
}
