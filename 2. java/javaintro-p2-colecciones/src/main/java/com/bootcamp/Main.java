package com.bootcamp;

import org.javatuples.Octet;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static int nroParticipante = 1;
    public static final String[] opciones = {"Inscribir participante", "Ver inscriptos a circuito", "Desinscribir participante", "Salir"};
    public static final String[] nombreCircuitos = {"Circuito Chico", "Circuito Medio", "Circuito Avanzado", "Volver al Menú Principal"};
    public static List<Map<String, Octet<Integer,String, String, Integer, String, String, String, Integer>>> circuitos = new ArrayList<>();
    public static Map<String, Octet<Integer,String, String, Integer, String, String, String, Integer>> circuitoChico = new HashMap<>();
    public static Map<String, Octet<Integer,String, String, Integer, String, String, String, Integer>> circuitoMedio = new HashMap<>();
    public static Map<String, Octet<Integer,String, String, Integer, String, String, String, Integer>> circuitoAvanzado = new HashMap<>();
    public static void main(String[] args) {
        circuitos.add(circuitoChico);
        circuitos.add(circuitoMedio);
        circuitos.add(circuitoAvanzado);

        mostrarMenuPrincipal();
    }

    private static void mostrarMenuPrincipal() {
        boolean salir = false;

        while (!salir) {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println();
            System.out.println("Seleccione una opcion:");
            for (int i = 0; i < opciones.length; i++) {
                System.out.println(String.format("%d. %s", i+1, opciones[i]));
            }
            Scanner input = new Scanner(System.in);

            //Validar opción seleccionada por usuario
            try {
                int option = input.nextInt();
                //Ir a selección de usuario
                switch (option) {
                    case 1 -> mostrarMenuInscripciones();
                    case 2 -> mostrarMenuInscriptos();
                    case 3 -> mostrarMenuDesinscripciones();
                    case 4 -> {salir = true;
                        System.out.println("Gracias por visitarnos!");}
                    default -> throw new Exception();
                }
            }
            catch (Exception e) {
                System.out.println(String.format("Seleccione una opción válida, del 1 al %d", opciones.length));
            }
        }
    }

    private static void mostrarMenuInscripciones() {
        System.out.println("INSCRIBIR PARTICIPANTE");

        //Se solicita el circuito a inscribirse y se valida
        while (true){
            System.out.println();
            System.out.println("Ingrese el número de circuito al que desea inscribirse:");
            for (int i = 0; i < nombreCircuitos.length; i++) {
                System.out.println(String.format("%d. %s", i+1, nombreCircuitos[i]));
            }
            Scanner input = new Scanner(System.in);

            try {
                int circuito = input.nextInt() - 1;
                if (circuito == nombreCircuitos.length - 1) return;

                //Se solicita datos del participante
                String[] rotulos = {"DNI", "Nombre", "Apellido", "Celular", "Contacto de Emergencia", "Grupo Sanguíneo"};
                String[] datos = new String[rotulos.length];
                System.out.println();
                int i = 0;
                while (i < rotulos.length) {
                    System.out.println();
                    System.out.println(String.format("Ingrese %s. Ingrese 'q' para volver al menú principal.",rotulos[i]));
                    input = new Scanner(System.in);

                    try {
                        String text = input.next();
                        if (text.equalsIgnoreCase("q")) return;
                        datos[i] = text;
                        i++;
                    }
                    catch (Exception e) {}
                }

                //Se solicita edad del participante
                int edad;
                while (true) {
                    System.out.println();
                    System.out.println("Ingrese su edad. Ingrese 'q' para volver al menú principal.");
                    input = new Scanner(System.in);

                    try {
                        String text = input.next();
                        if (text.equalsIgnoreCase("q")) return;
                        edad = Integer.parseInt(text);
                        if (edad > 0) break;
                        System.out.println("Edad no válida.");
                    }
                    catch (Exception e) {
                        System.out.println("Ingrese un valor válido.");
                    }
                }

                inscribir(datos[0], circuito, datos[1], datos[2], edad, datos[3], datos[4], datos[5]);
                return;
            }
            catch (Exception e) {
                System.out.println(String.format("Ingrese un número del 1 al %d", nombreCircuitos.length));
            }
        }
    }

    private static void mostrarMenuInscriptos() {
        System.out.println("MOSTRAR INSCRIPTOS");

        //Se solicita el circuito a inscribirse y se valida
        while (true){
            System.out.println();
            System.out.println("Ingrese el número de circuito del que desee ver los inscriptos:");
            for (int i = 0; i < nombreCircuitos.length; i++) {
                System.out.println(String.format("%d. %s", i+1, nombreCircuitos[i]));
            }
            Scanner input = new Scanner(System.in);
            try {
                int option = input.nextInt() - 1;
                if (option == nombreCircuitos.length - 1) return;
                Map<String, Octet<Integer,String, String, Integer, String, String, String, Integer>> circuito = circuitos.get(option);

                System.out.println();
                if (circuito.size() == 0) System.out.println("Actualmente no hay participantes inscriptos en este circuito. Sé el primero!");
                for (Map.Entry<String, Octet<Integer,String, String, Integer, String, String, String, Integer>> inscripto: circuito.entrySet()) {
                    System.out.println(String.format("Nro: %3d Nombre: %-10s, %-10s | DNI: %-10s", inscripto.getValue().getValue(0), inscripto.getValue().getValue(2).toString().toUpperCase(), inscripto.getValue().getValue(1), inscripto.getKey()));
                }

                System.out.println();
                System.out.println("Ingrese 'q' para volver al menú principal, o 'c' para ver los inscriptos a otro circuito");
                while (true) {
                    input = new Scanner(System.in);
                    try {
                        String text = input.next();
                        if (text.equalsIgnoreCase("q")) return;
                        if (text.equalsIgnoreCase("c")) break;
                    }
                    catch (Exception e) {}
                }
            }
            catch (Exception e) {
                System.out.println(String.format("Ingrese un número del 1 al %d", nombreCircuitos.length));
            }
        }
    }

    private static void mostrarMenuDesinscripciones() {
        System.out.println("DESINSCRIBIR PARTICIPANTE");

        //Se solicita el DNI y se busca el participante
        while (true) {
            System.out.println();
            System.out.println("Ingrese el DNI del participante. Ingrese 'q' para volver al menú principal.");
            Scanner input = new Scanner(System.in);
            try {
                String dni = input.next();
                if (dni.equalsIgnoreCase("q")) return;;
                if (eliminarParticipante(dni)) {
                    System.out.println(String.format("El participante con el DNI %s ha sido dado de baja correctamente.", dni));
                } else {
                    System.out.println(String.format("No hay nigún participante registrado con el DNI ingresado. Intente nuevamente."));
                }
            }
            catch (Exception e) {};
        }
    }

    private static void inscribir(String dni, Integer circuito, String nombre, String apellido, Integer edad, String celular, String numeroEmergencia, String grupoSanguineo) {
        //Participante ya inscripto
        if (buscarParticipante(dni) != null) {
            System.out.println("El participante ya se encuentra inscripto.");
            return;
        }

        //Circuito avanzado solo para mayores de 18 años
        //Calculo monto según circuito y edad
        int monto;
        if (circuito == 0) {
            monto = edad < 18 ? 1300 : 1500; 
        } else if (circuito == 1) {
            monto = edad < 18 ? 2000 : 2300;
        } else {
            if (edad < 18) {
                System.out.println("Para poder inscribirte al circuito avanzado debes ser mayor de edad.");
                return;
            }
            monto = 2800;
        }

        //Desplegar monto y solicitar confirmación
        String[] nombresCircuitos = {"Chico", "Medio", "Avanzado"};
        System.out.println(String.format("Se inscribirá al participante con DNI %s al Circuito %s. El costo de la inscripción es de $ %d. Presione 'S' para confirmar o cualquier otra tecla para cancelar", dni, nombresCircuitos[circuito], monto));
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                String text = input.next();
                if (text.equalsIgnoreCase("s")) {
                    circuitos.get(circuito).put(dni, new Octet<>(nroParticipante, nombre, apellido, edad, celular, numeroEmergencia, grupoSanguineo, monto));
                    System.out.println(String.format("Te has inscripto al Circuito %s con el número %d. Suerte en la carrera!", nombresCircuitos[circuito], nroParticipante));
                    nroParticipante++;
                }
                return;
            }
            catch (Exception e) {}
        }

    }

    private static Octet<Integer,String, String, Integer, String, String, String, Integer> buscarParticipante (String dni) {
        for (Map<String, Octet<Integer,String, String, Integer, String, String, String, Integer>> c : circuitos) {
            if (c.containsKey(dni)) return c.get(dni);
        }
        return null;
    }

    private static boolean eliminarParticipante (String dni) {
        for (Map<String, Octet<Integer,String, String, Integer, String, String, String, Integer>> c : circuitos) {
            if (c.containsKey(dni)) {
                c.remove(dni);
                return true;
            }
        }
        return false;
    }
}