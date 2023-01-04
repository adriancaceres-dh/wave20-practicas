package com.bootcamp;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    public static boolean checkearEdad (int edad) {
        if (edad < 18) return true;
        else return false;
    }

    public static int agregarParticipante(int contParticipantes, Map<String, ArrayList<Participante>> carreraSelva,
                                           ArrayList<Participante>participantesChico, ArrayList<Participante> participantesMedio,
                                           ArrayList<Participante>participantesAvanzado ,Participante participante) {
        Scanner scan = new Scanner(System.in);
        String circuito;
        int monto;
        participante.setNroParticipante(++contParticipantes);

        System.out.println("-----------------------------------------------------------------------------");
        System.out.print("A que circuito se quiere inscribir? (Opciones: 'Chico', 'Medio', 'Avanzado'): ");
        circuito = scan.nextLine();
        System.out.print("Indicar nombre: ");
        participante.setNombre(scan.nextLine());
        System.out.print("Indicar apellido: ");
        participante.setApellido(scan.nextLine());
        System.out.print("Indicar DNI: ");
        participante.setDni(scan.nextLine());
        System.out.print("Indicar celular: ");
        participante.setCelular(scan.nextLine());
        System.out.print("Indicar número de emergencia: ");
        participante.setNroEmergencia(scan.nextLine());
        System.out.print("Indicar grupo sanguineo: ");
        participante.setGrupoSanguineo(scan.nextLine());
        System.out.print("Indicar edad: ");
        participante.setEdad(scan.nextInt());
        switch (circuito.toLowerCase()) {
            case "chico":
                if (checkearEdad(participante.getEdad())) monto = 1300;
                else monto =1500;
                participante.setMonto(monto);
                participantesChico.add(participante);
                carreraSelva.put("Circuito Chico", participantesChico);
                break;
            case "medio":
                if (checkearEdad(participante.getEdad())) monto = 2000;
                else monto =2300;
                participante.setMonto(monto);
                participantesMedio.add(participante);
                carreraSelva.put("Circuito Medio", participantesMedio);
                break;
            case "avanzado":
                if (checkearEdad(participante.getEdad())) System.out.println("Tiene que ser mayor de edad para participar en el circuito avanzado");
                else {
                    monto =2800;
                    participante.setMonto(monto);
                    participantesAvanzado.add(participante);
                    carreraSelva.put("Circuito Avanzado", participantesAvanzado);
                }
                break;
        }
        System.out.println("Participante Inscripto:\n " + participante);
        return participante.getNroParticipante();
    }

    public static void main(String[] args) {
        Map<String, ArrayList<Participante>> carreraSelva = new HashMap<>();
        ArrayList<Participante> participantesChico = new ArrayList<>();
        ArrayList<Participante> participantesMedio = new ArrayList<>();
        ArrayList<Participante> participantesAvanzado = new ArrayList<>();

        int contParticipantes = 0;

        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("                Bienvenido a La Carrera de la Selva...");
        for (int i = 0; i < 6; i++) {
            agregarParticipante(i, carreraSelva, participantesChico, participantesMedio, participantesAvanzado
                    , new Participante());
        }

        System.out.println("Lista de participantes por circuito");
        for (Map.Entry<String, ArrayList<Participante>> circuitos:
             carreraSelva.entrySet()) {
            System.out.println(circuitos.getKey()+" "+circuitos.getValue());
            System.out.println("-------------------------------------------");
        }
    }
}
