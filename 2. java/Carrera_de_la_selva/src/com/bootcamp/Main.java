package com.bootcamp;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String dni, nombre, apellido, celular, fijo, grupo_sanguineo, carrera;
        int edad;

        Scanner teclado = new Scanner(System.in);
        String eliminar;
        int numeroEliminado;
        String seguir = "si";

        Map<Integer, List<String>> circuitoChico = new HashMap<>();
        Map<Integer, List<String>> circuitoMedio = new HashMap<>();
        Map<Integer, List<String>> circuitoAvanzado = new HashMap<>();

        int partCircuitoChico = 0;
        int partCircuitoMedio = 0;
        int partCircuitoAvanzado = 0;

        while (seguir.equals("si")){

            System.out.println("Ingrese su DNI");
            dni = teclado.next();
            System.out.println("Ingrese su nombre");
            nombre = teclado.next();
            System.out.println("Ingrese su apellido");
            apellido = teclado.next();
            System.out.println("Ingrese su número de celular");
            celular = teclado.next();
            System.out.println("Ingrese un telefono fijo");
            fijo = teclado.next();
            System.out.println("Ingrese su grupo sanguíneo");
            grupo_sanguineo = teclado.next();
            System.out.println("Ingrese el circuito al que se quiere anotar (chico - medio - avanzado)");
            carrera = teclado.next();
            System.out.println("Por último ingrese su edad");
            edad = teclado.nextInt();

            List<String> participante = new ArrayList<>();
            participante.add(dni);
            participante.add(nombre);
            participante.add(apellido);
            participante.add(celular);
            participante.add(fijo);
            participante.add(grupo_sanguineo);

            if(carrera.equals("chico") && edad >= 18){
                circuitoChico.put(circuitoChico.size()+1,participante);
                partCircuitoChico++;
                System.out.println("El participante Nº" + partCircuitoChico + " - " + apellido + " se anoto al circuito " + carrera + " y debe abonar $1500");
                for( Map.Entry<Integer, List<String>> entradas : circuitoChico.entrySet() ) {
                    System.out.println(entradas.getKey() + " - " +
                            entradas.getValue());
                }
            }
            if(carrera.equals("chico") && edad < 18){
                circuitoChico.put(circuitoChico.size()+1,participante);
                partCircuitoChico++;
                System.out.println("El participante Nº" + partCircuitoChico + " - " + apellido + " se anoto al circuito " + carrera + " y debe abonar $1300");
                for( Map.Entry<Integer, List<String>> entradas : circuitoChico.entrySet() ) {
                    System.out.println(entradas.getKey() + " - " +
                            entradas.getValue());
                }
            }
            if(carrera.equals("medio") && edad >= 18){
                circuitoMedio.put(circuitoMedio.size()+1,participante);
                partCircuitoMedio++;
                System.out.println("El participante Nº" + partCircuitoMedio + " - " + apellido + " se anoto al circuito " + carrera + " y debe abonar $2300");
                for( Map.Entry<Integer, List<String>> entradas : circuitoMedio.entrySet() ) {
                    System.out.println(entradas.getKey() + " - " +
                            entradas.getValue());
                }
            }
            if(carrera.equals("medio") && edad < 18){
                circuitoMedio.put(circuitoMedio.size()+1,participante);
                partCircuitoMedio++;
                System.out.println("El participante Nº" + partCircuitoMedio + " - " + apellido + " se anoto al circuito " + carrera + " y debe abonar $2000");
                for( Map.Entry<Integer, List<String>> entradas : circuitoMedio.entrySet() ) {
                    System.out.println(entradas.getKey() + " - " +
                            entradas.getValue());
                }
            }
            if(carrera.equals("avanzado") && edad >= 18){
                circuitoAvanzado.put(circuitoAvanzado.size()+1,participante);
                partCircuitoAvanzado++;
                System.out.println("El participante Nº" + partCircuitoAvanzado + " - " + apellido + " se anoto al circuito " + carrera + " y debe abonar $2800");
                for( Map.Entry<Integer, List<String>> entradas : circuitoAvanzado.entrySet() ) {
                    System.out.println(entradas.getKey() + " - " +
                            entradas.getValue());
                }
            }
            if(carrera.equals("avanzado") && edad < 18){
                System.out.println("No se permiten menores de edad para este circuito");
            }

            System.out.println("Desea eliminar algún participante (si - no)");
            eliminar = teclado.next();
            if(eliminar.equals("si")){
                System.out.println("Ingrese el número del participante que desea eliminar");
                numeroEliminado = teclado.nextInt();
                if(carrera.equals("chico")){
                    circuitoChico.remove(numeroEliminado);
                }
                if (carrera.equals("medio")){
                    circuitoMedio.remove(numeroEliminado);
                }
                if (carrera.equals("avanzado")){
                    circuitoAvanzado.remove(numeroEliminado);
                }
                System.out.println("Participante eliminado");
            }

            System.out.println("Ingresar nuevo participante (si - no)");
            seguir = teclado.next();

        }


    }
}