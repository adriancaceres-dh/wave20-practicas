package com.bootcamp;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Ejercicio_2 {

    public static void registrarParticipante(Map<String, Map<String, String>> participantes, Scanner sc,
                                             int[] circuito_chico, int[] circuito_medio, int circuito_avanzado,
                                             int identificador, int option) {

        System.out.println("DNI");
        String dni = sc.nextLine();
        System.out.println("Nombre");
        String nombre = sc.nextLine();
        System.out.println("Apellido");
        String apellido = sc.nextLine();
        System.out.println("Edad");
        String edad = sc.nextLine();
        System.out.println("Celular");
        String celular = sc.nextLine();
        System.out.println("Numero de emergencia");
        String emergencia = sc.nextLine();
        System.out.println("Grupo Sanguineo");
        String grupo_sanguineo = sc.nextLine();


        Map<String, String> datos = new TreeMap<>();

        datos.put("identificador", Integer.toString(++identificador));
        datos.put("dni", dni);
        datos.put("apellido", apellido);
        datos.put("edad", edad);
        datos.put("celular", celular);
        datos.put("emergencia", emergencia);
        datos.put("grupo_sanguineo", grupo_sanguineo);
        switch (option){
            case(1):
                datos.put("circuito", "chico");

        }

        participantes.put(nombre, datos);

        System.out.println("El participante: " + nombre + " con los datos:");
        for (Map.Entry<String, String> dato : datos.entrySet()) {
            System.out.println(dato.getKey() + ": " + dato.getValue());
        }
        System.out.println("Se ha registrado correctamente");

    }

    public static void main (String[] args) {
        Map<String, Map<String, String>> participantes = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int identificador = 0;
        int[] circuito_chico= {1300, 1500};
        int[] circuito_medio= {2000, 2300};
        int circuito_avanzado= 2800;

        while(true){
            System.out.println("Elija una opcion:");
            System.out.println("1. Registrar un participante");
            System.out.println("2. Salir");
            int option = Integer.parseInt(sc.nextLine());
            switch(option){
                case(1):
                    System.out.println("Elija un circuito");
                    System.out.println("1. Circuito Chico");
                    System.out.println("2. Circuito Medio");
                    System.out.println("3. Circuito Avanzado");
                    option = Integer.parseInt(sc.nextLine());
                    switch (option){
                        case(1):
                            registrarParticipante(participantes, sc, circuito_chico, circuito_medio, circuito_avanzado,
                            identificador, option);
                    }
                case(2):
                    return;
            }

        }


    }
}
