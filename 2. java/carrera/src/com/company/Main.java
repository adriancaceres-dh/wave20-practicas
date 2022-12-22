package com.company;

import java.net.StandardSocketOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static Map<String, HashMap<String, Integer>> circuito = new HashMap<>();

    static int inscripcion = 1;

    static Map<Integer, String[]> participantes = new TreeMap<>();

    public static void main(String[] args) {
        //Configurar tarifas de cada uno de los circuitos
        configurarCircuitos();

        //Registro de particpantes
        registrarParticipante("1234999", "Ana", "Gonzalez", 23, "3214526369", "56789", "0+", "Avanzado");
        registrarParticipante("1236547", "Maria", "Ramirez", 44, "314563285", "845588", "0-", "Medio");
        registrarParticipante("9635588", "Andres", "Perez", 58, "3112596358", "5884477", "A+", "Chico");
        registrarParticipante("5869388", "Sofia", "Salgado", 16, "310265896", "567896889", "0+", "Medio");
        registrarParticipante("87455999", "Gustavo", "Ocampo", 35, "31025587", "565858789", "0+", "Chico");
        registrarParticipante("85825474", "Johan", "Martinez", 28, "31632585", "125467889", "0-", "Avanzado");

        //Particpante en categoria no valida
        registrarParticipante("858274", "Mario", "Gonzalez", 29, "32632585", "125889", "0-", "Extremo");

        //Listar inscritos por categoria
        listarParticipantes("Chico");
        listarParticipantes("Medio");
        listarParticipantes("Avanzado");

        //Eliminar a Gustavo Ocampo de los registros de inscripcion
        anularInscripcion(5);

        //Comprobacion de eliminacion de registro no existente
        anularInscripcion(64);

        //Comprobar que sea eliminado a Gustavo Ocampo de los inscritos del categoria Chico
        listarParticipantes("Chico");
    }

    public static void configurarCircuitos() {
        HashMap<String, Integer> valoresChico = new HashMap<>();
        valoresChico.put("menor", 1300);
        valoresChico.put("mayor", 1500);

        circuito.put("Chico", valoresChico);

        HashMap<String, Integer> valoresMedio = new HashMap<>();
        valoresMedio.put("menor", 2000);
        valoresMedio.put("mayor", 2300);

        circuito.put("Medio", valoresMedio);

        HashMap<String, Integer> valoresAvanzado = new HashMap<>();
        valoresAvanzado.put("mayor", 2800);

        circuito.put("Avanzado", valoresAvanzado);

    }

    public static void registrarParticipante(String dni, String nombre, String apellido, int edad, String celular, String numEmergencia, String rh, String categoria) {

        if (!categoria.equals("Chico") && !categoria.equals("Medio") && !categoria.equals("Avanzado")) {
            System.out.println("Categoria no identificada, No se puede inscribir");
            return;
        }

        String[] p = {dni, nombre, apellido, String.valueOf(edad), celular, numEmergencia, rh, categoria};
        participantes.put(inscripcion++, p);

        int valorPagar = 0;
        if (categoria.equals("Chico")) {
            if (edad < 18) {
                valorPagar = circuito.get(categoria).get("menor");
            } else {
                valorPagar = circuito.get(categoria).get("mayor");
            }
        } else if (categoria.equals("Medio")) {
            if (edad < 18) {
                valorPagar = circuito.get(categoria).get("menor");
            } else {
                valorPagar = circuito.get(categoria).get("mayor");
            }
        } else if (categoria.equals("Avanzado")) {
            if (edad < 18) {
                System.out.println("No se permiten inscripciones para la categoria avanzado a menores de edad");
            } else {
                valorPagar = circuito.get(categoria).get("mayor");
            }
        }
        if (valorPagar != 0) {
            System.out.println("El valor que debe pagar el participante "+nombre+" " + apellido + " es:" + valorPagar);
        }
    }

    public static void listarParticipantes(String categoria) {
        System.out.println("Participantes registrados en la categoria " + categoria);
        for (Integer llave : participantes.keySet()) {
            String[] valores = participantes.get(llave);
            if (categoria.equals(valores[7])) {
                String mensaje = "Participante: " + valores[1] + " " + valores[2] + " | Edad: " + valores[3] + " | Celular: " + valores[4] + " | No.Inscripcion " + llave;
                System.out.println(mensaje);
            }

        }
    }

    public static void anularInscripcion(int inscripcion) {
        if (participantes.containsKey(inscripcion)) {
            participantes.remove(inscripcion);
        }else{
            System.out.println("El participante no se encuentra en el sistema");
        }

    }
}

