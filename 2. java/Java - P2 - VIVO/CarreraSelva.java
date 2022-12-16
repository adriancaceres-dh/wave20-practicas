package com.bootcamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarreraSelva {

    static Map<Integer, List<Object>> circuitoChico = new HashMap<>();
    static Map<Integer, List<Object>> circuitoMedio = new HashMap<>();
    static Map<Integer, List<Object>> circuitoAvanzado = new HashMap<>();

    public static void main(String[] args) {
        inscribirParticipante(1, "Circuito Chico", "6578147-0", "Luis", "Pérez", 21, "093478132", "098254148", "AB");
        inscribirParticipante(2, "Circuito Medio", "5874562-2", "María", "Rodríguez", 16, "095214569", "98536742", "B+");
        inscribirParticipante(3, "Circuito Chico", "4125874-1", "Antonio", "Orozco", 35, "093124785", "09632148", "O");
        inscribirParticipante(4, "Circuito Avanzado", "5968542-0", "Ernesto", "Matos", 24, "092365214", "09852475", "O-");
        inscribirParticipante(5, "Circuito Chico", "6523145-2", "Lazaro", "Fuentes", 15, "098214763", "097456325", "AB+");

        mostrarInscritos("Circuito Chico");

        desinscribirParticipante("Circuito Chico", 5);

        System.out.println("-----------------");
        mostrarInscritos("Circuito Chico");
    }

    // Método para desinscribir a un participante de una categoría.
    public static void mostrarInscritos(String categoria) {
        if (categoria == "Circuito Chico") {
            for (Map.Entry<Integer, List<Object>> participante: circuitoChico.entrySet()) {
                System.out.println(participante.getKey() + " -> " + participante.getValue());
            }
        } else if (categoria == "Circuito Medio") {
            for (Map.Entry<Integer, List<Object>> participante: circuitoMedio.entrySet()) {
                System.out.println(participante.getKey() + " -> " + participante.getValue());
            }
        } else {
            for (Map.Entry<Integer, List<Object>> participante: circuitoAvanzado.entrySet()) {
                System.out.println(participante.getKey() + " -> " + participante.getValue());
            }
        }
    }

    // Método para inscribir a un participante en una categoría.
    public static void inscribirParticipante(int id, String categoria, String dni, String nombre, String apellido, int edad, String celular, String numero_emergencia, String grupo_sanguineo) {
        List<Object> datosParticipante = new ArrayList<>();
        datosParticipante.add(dni);
        datosParticipante.add(nombre);
        datosParticipante.add(apellido);
        datosParticipante.add(edad);
        datosParticipante.add(celular);
        datosParticipante.add(numero_emergencia);
        datosParticipante.add(grupo_sanguineo);
        if (categoria == "Circuito Chico") {
            circuitoChico.put(id, datosParticipante);
        } else if (categoria == "Circuito Medio") {
            circuitoMedio.put(id, datosParticipante);
        } else {
            circuitoAvanzado.put(id, datosParticipante);
        }
        System.out.println(montoAbonar(categoria, edad));
    }

    // Método para desinscribir a un participante de una categoría.
    public static void desinscribirParticipante(String categoria, int id) {
        if (categoria == "Circuito Chico") {
            if (circuitoChico.containsKey(id)) {
                circuitoChico.remove(id);
            }
        } else if (categoria == "Circuito Medio") {
            if (circuitoMedio.containsKey(id)) {
                circuitoMedio.remove(id);
            }
        } else {
            if (circuitoAvanzado.containsKey(id)) {
                circuitoAvanzado.remove(id);
            }
        }
    }

    // Método para calcular el monto a abonar a la hora de inscribirse un participante en una determinada categoría
    public static int montoAbonar(String categoria, int edad) {
        int monto_abonar = -1;
        if (categoria == "Circuito Chico") {
            if (edad < 18) {
                monto_abonar = 1300;
            } else {
                monto_abonar = 1500;
            }
        } else if (categoria == "Circuito Medio") {
            if (edad < 18) {
                monto_abonar = 2000;
            } else {
                monto_abonar = 2300;
            }
        } else {
            if (edad >= 18) {
                monto_abonar = 2800;
            }
        }
        return monto_abonar;
    }
}
