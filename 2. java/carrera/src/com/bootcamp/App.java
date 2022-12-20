package com.bootcamp;

import java.util.*;

public class App {

    static void calcularMonto (Map<String,String> participante , String categoria){
        Integer edad = Integer.parseInt(participante.get("edad"));
        switch (categoria){
            case "1":
                if (edad < 18){
                    participante.put("monto","1300");
                } else {
                    participante.put("monto","1500");
                }
                break;
            case "2":
                if (edad < 18){
                    participante.put("monto","2000");
                } else {
                    participante.put("monto","2300");
                }
                break;
            case "3":
                if (edad > 18){
                    participante.put("monto","2800");
                }
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Map<Integer,Map<String,String>>> participantesCategoriaChico = new ArrayList<>();
        List<Map<Integer,Map<String,String>>> participantesCategoriaMediano = new ArrayList<>();
        List<Map<Integer,Map<String,String>>> participantesCategoriaAvanzado = new ArrayList<>();

        int numeroParticipante = 0;
        int opcion;

        do {

            System.out.println("Ingresar una opcion: ");
            System.out.println("1: Agregar un participante ");
            System.out.println("2: Mostrar participantes de una categoria ");
            System.out.println("3: Desinscribir un participante ");
            System.out.println("0: Salir  ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresar una categoria (1: chico / 2: mediano / 3: avanzado): ");
                    String categoria = sc.next();
                    System.out.print("Ingresar dni: ");
                    String dni = sc.next();
                    System.out.print("Ingresar nombre: ");
                    String nombre = sc.next();
                    System.out.print("Ingresar apellido: ");
                    String apellido = sc.next();
                    System.out.print("Ingresar edad: ");
                    String edad = sc.next();
                    System.out.print("Ingresar celular: ");
                    String celular = sc.next();
                    System.out.print("Ingresar numero de emergencia: ");
                    String numeroDeEmergencia = sc.next();
                    System.out.print("Ingresar grupo sanguineo: ");
                    String grupoSanguineo = sc.next();

                    // mapa de participante
                    Map<String, String> datosParticipante = new HashMap<>();
                    datosParticipante.put("dni",dni);
                    datosParticipante.put("nombre", nombre);
                    datosParticipante.put("apellido", apellido);
                    datosParticipante.put("edad", edad);
                    datosParticipante.put("celular",celular);
                    datosParticipante.put("numeroDeEmergencia",numeroDeEmergencia);
                    datosParticipante.put("grupoSanguineo",grupoSanguineo);

                    calcularMonto(datosParticipante, categoria);

                    // mapa de participante junto a su numero de participante
                    Map<Integer, Map<String, String>> participante = new HashMap<>();
                    participante.put(++numeroParticipante, datosParticipante);

                    switch (categoria) {
                        case "1":
                            participantesCategoriaChico.add(participante);
                            break;
                        case "2":
                            participantesCategoriaMediano.add(participante);
                            break;
                        case "3":
                            if (Integer.parseInt(datosParticipante.get("edad")) < 18 ){
                                System.out.println("Los participantes menores de 18 años no pueden inscribirse en esta categoria");
                            } else {
                                participantesCategoriaAvanzado.add(participante);
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Ingresar la categoria a mostrar (1: chico / 2: mediano / 3: avanzado): ");
                    int opcionCategoria = sc.nextInt();
                    switch (opcionCategoria) {
                        case 1:
                            System.out.println(participantesCategoriaChico);
                            break;
                        case 2:
                            System.out.println(participantesCategoriaMediano);
                            break;
                        case 3:
                            System.out.println(participantesCategoriaAvanzado);
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Ingresar la categoria a la que desea desinscribir el ultimo participante (1: chico / 2: mediano / 3: avanzado): ");
                    int opcionEliminar = sc.nextInt();
                    switch (opcionEliminar) {
                        case 1:
                            int tamañoListaChico = participantesCategoriaChico.size();
                            if (tamañoListaChico > 0){
                                participantesCategoriaChico.remove(tamañoListaChico-1);
                            } else {
                                System.out.println("La categoria ingresada no contiene participantes.");
                            }
                            break;
                        case 2:
                            int tamañoListaMediano = participantesCategoriaMediano.size();
                            if (tamañoListaMediano > 0){
                                participantesCategoriaMediano.remove(tamañoListaMediano-1);
                            } else {
                                System.out.println("La categoria ingresada no contiene participantes.");
                            }
                            break;
                        case 3:
                            int tamañoListaAvanzado = participantesCategoriaAvanzado.size();
                            if (tamañoListaAvanzado > 0){
                                participantesCategoriaAvanzado.remove(tamañoListaAvanzado-1);
                            } else {
                                System.out.println("La categoria ingresada no contiene participantes.");
                            }
                            break;
                        default:
                            break;
                    }
                    break;
            }
        } while (opcion != 0) ;
    }
}
