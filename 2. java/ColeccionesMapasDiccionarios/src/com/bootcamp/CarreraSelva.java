package com.bootcamp;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CarreraSelva {

    public static int identificadorActual = 0;
    public static Map<String, Map<Integer,Map<String,String>>> circuitos = new HashMap<>();
    public static Map<Integer,Map<String,String>> participanteCC = new HashMap<>();
    public static Map<Integer,Map<String,String>> participanteCM = new HashMap<>();
    public static Map<Integer,Map<String,String>> participanteCA = new HashMap<>();
    static Scanner leer = new Scanner(System.in);

    public static void inscribirParticipante(){
        System.out.println("Ingresa el nombre del participante:");
        String nombre = leer.next();
        System.out.println("Ingresa el apellido del participante:");
        String apellido = leer.next();
        System.out.println("Ingresa el dni del participante:");
        String dni = leer.next();
        System.out.println("Ingresa la edad del participante:");
        String edad = leer.next();
        System.out.println("Ingresa el celular del participante:");
        String celular = leer.next();
        System.out.println("Ingresa el numero de emergencia del participante:");
        String numEmergencia = leer.next();
        System.out.println("Ingresa el grupo sanguineo del participante:");
        String grupSanguineo = leer.next();
        int circuito = 0;
        while (true){
            System.out.println("Ingresa 1 para el circuito chico, 2 para el medio y 3 para el avanzado");
            circuito = leer.nextInt();;
            if(circuito < 0 || circuito > 3){
                System.out.println("Ingresa una cantidad válida");
            } else if(Integer.parseInt(edad) < 18 && circuito == 3){
                System.out.println("En este circuito no se permiten menores de edad, seleccione otro");
            }else {
                break;
            }
        }
        identificadorActual++;

        Map<String,String> participanteInfo = new HashMap<>();
        participanteInfo.put("nombre",nombre);
        participanteInfo.put("apellido",apellido);
        participanteInfo.put("dni",dni);
        participanteInfo.put("edad",edad);
        participanteInfo.put("celular",celular);
        participanteInfo.put("numero emergencia",numEmergencia);
        participanteInfo.put("grupo sanguineo",grupSanguineo);


        switch (circuito){
            case 1:
                participanteCC.put(identificadorActual,participanteInfo);
                circuitos.put("circuito chico",participanteCC);
                if(Integer.parseInt(edad)>18){
                    System.out.println("El paricipante debe pagar $1500");
                }else{
                    System.out.println("El paricipante debe pagar $1300");
                }
                break;
            case 2:
                participanteCM.put(identificadorActual,participanteInfo);
                circuitos.put("circuito medio",participanteCM);
                if(Integer.parseInt(edad)>18){
                    System.out.println("El paricipante debe pagar $2300");
                }else{
                    System.out.println("El paricipante debe pagar $2000");
                }
                break;
            case 3:
                participanteCA.put(identificadorActual,participanteInfo);
                circuitos.put("circuito avanzado",participanteCA);
                System.out.println("El paricipante debe pagar $2800");
                break;
        }

        System.out.println(circuitos);

    }



    public static void main(String[] args) {

        circuitos.put("circuito chico",participanteCC);
        circuitos.put("circuito medio",participanteCC);
        circuitos.put("circuito avanzado",participanteCC);

        int opcion = 10;
        while (true){
            System.out.println("Escribe 0 para salir");
            System.out.println("Escribe 1 para inscribir un participante");
            System.out.println("Escribe 2 para mostrar los participantes de una categoria");
            System.out.println("Escribe 3 para eliminar a un participante");
            opcion = leer.nextInt();

            if(opcion == 0){
                break;
            }else{
                int circuito = 0;
                switch (opcion){
                case 1:
                    inscribirParticipante();
                    break;
                case 2:
                    while (true){
                        System.out.println("Ingresa 1 para el circuito chico, 2 para el medio y 3 para el avanzado");
                        circuito = leer.nextInt();;
                        if(circuito < 0 || circuito > 3){
                            System.out.println("Ingresa una cantidad válida");
                        }else {
                            break;
                        }
                    }

                    switch (circuito){
                        case 1:
                            System.out.println(circuitos.get("circuito chico"));
                            break;
                        case 2:
                            System.out.println(circuitos.get("circuito medio"));
                            break;
                        case 3:
                            System.out.println(circuitos.get("circuito avanzado"));
                            break;
                    }
                    break;
                case 3:
                    int id = 0;
                    while (true){
                        System.out.println("Ingresa 1 para el circuito chico, 2 para el medio y 3 para el avanzado");
                        circuito = leer.nextInt();;
                        if(circuito < 0 || circuito > 3){
                            System.out.println("Ingresa una cantidad válida");
                        }else {
                            break;
                        }
                    }

                    switch (circuito){
                        case 1:
                            System.out.println("Ingresa el id del participante");
                            id = leer.nextInt();
                            participanteCC.remove(id);
                            break;
                        case 2:
                            System.out.println("Ingresa el id del participante");
                            id = leer.nextInt();
                            participanteCM.remove(id);
                            break;
                        case 3:
                            System.out.println("Ingresa el id del participante");
                            id = leer.nextInt();
                            participanteCA.remove(id);
                            break;
                    }
                    break;
                default:
                    System.out.println("Selecciona una opcion valida");
                    break;
                }
            }

        }



    }
}
