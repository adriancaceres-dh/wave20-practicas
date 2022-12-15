package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    String newLine = System.getProperty("line.separator");

    private Map<Integer, Inscripcion> inscripciones = new HashMap<>();
    private int current = 0;

    void printMenu() {
        System.out.println( "Ingrese su opcion: " + newLine +
                "0-Inscribir participante" + newLine +
                "1-Mostrar inscriptos" + newLine +
                "2-Desinscribir participante" + newLine +
                "3-Calcular costo" + newLine +
                "4-Salir");
    }

    int obtenerCircuito() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese circuito: 0-chico, 1-medio, 2-avanzado");
        int circuito = teclado.nextInt();
        return circuito;
    }

    int obtenerInt() {
        Scanner teclado = new Scanner(System.in);
        int num = teclado.nextInt();
        return num;
    }

    String obtenerString() {
        Scanner teclado = new Scanner(System.in);
        String str = teclado.nextLine();
        return str;
    }

    void casoInscribir() {
        System.out.println("Ingresar DNI: ");
        int dni = obtenerInt();
        //obtener datos
        if (!inscripciones.containsKey(dni)) {
            current++;
            //obtener datos
            int circuito = obtenerCircuito();
            System.out.println("Ingresar nombre: ");
            String nombre = obtenerString();
            System.out.println("Ingresar apellido: ");
            String apellido = obtenerString();
            System.out.println("Ingresar celular: ");
            String celular = obtenerString();
            System.out.println("Ingresar edad: ");
            int edad = obtenerInt();

            Inscripcion nueva = new Inscripcion(dni, current, circuito, nombre, apellido, edad, celular);
            inscripciones.put(dni, nueva);

        }
    }

    void casoBorrar() {
        System.out.println("Ingresar DNI: ");
        int dni = obtenerInt();
        if (inscripciones.containsKey(dni)) {
            inscripciones.remove(dni);
        }
    }

    void casoListar() {
        int circuito = obtenerCircuito();
        for (Map.Entry<Integer, Inscripcion> entry: inscripciones.entrySet()) {
            if (entry.getValue().getCircuito() == circuito) {
                System.out.println(
                        "Num inscripcion: " + entry.getValue().getNumInscripcion() + newLine +
                        "DNI: " + entry.getValue().getDni() + newLine +
                                "Nombre: " + entry.getValue().getNombre() + newLine +
                                "Apellido: " + entry.getValue().getApellido() + newLine +
                                "Circuito: " + entry.getValue().getCircuito() + newLine
                );
            }
        }
    }

    int casoCalcular() {

        System.out.println("Ingresar DNI: ");
        int dni = obtenerInt();
        int edad = inscripciones.get(dni).getEdad();
        int circuito = inscripciones.get(dni).getCircuito();
        if (edad < 18) {
            if (circuito == 0) {
                return 1300;
            } else if (circuito == 1) {
                return 2000;
            } else {
                System.out.println("No se permite inscripcion de menores a circuito avanzado");
                return -1;
            }
        } else {

            if (circuito == 0) {
                return 1500;
            } else if (circuito == 1) {
                return 2300;
            } else {
                return 2800;
            }
        }
    }

    void run() {
        boolean flag = true;
        while (flag) {
            printMenu();
            int opcion = obtenerInt();
            switch (opcion) {
                case 0: {
                    casoInscribir();
                    break;
                }
                case 1: {
                    casoListar();
                    break;
                }
                case 2: {
                    casoBorrar();
                    break;
                }
                case 3: {
                    casoCalcular();
                    break;
                }
                case 4: {
                    flag = false;
                    break;
                }
                default:
                    System.out.println("Opcion equivocada");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }

}