package Bootcamp;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Object[]> participantes = new HashMap<>();
        Scanner entrada  = new Scanner(System.in);
        int opcion;
        int nroCompetidores = 1;
        do {
            System.out.println("Digite la opción deseada" +
                    "\n1. Inscribir un nuevo participante" +
                    "\n2. Revisar participantes inscritos por categoría" +
                    "\n3. Desinscribir participante" +
                    "\n4. Determinar el monto a cancelar por el participante a consultar" +
                    "\n0. Salir del programa");
            opcion = entrada.nextInt();

            switch(opcion) {
                case 1: {
                    boolean bandera = true;
                    int tipoCircuito;
                    Object[] datosParticipante = new Object[8];
                    String dni;
                    while(bandera) {
                        System.out.println("Digite el tipo de circuito al que desea inscribirse" +
                                "\n1. Circuito chico" +
                                "\n2. Circuito medio" +
                                "\n3. Circuito avanzado");
                        tipoCircuito = entrada.nextInt();
                        if(tipoCircuito > 3 || tipoCircuito < 1);
                        else{
                            if(tipoCircuito != 3) {
                                try {
                                    annadirParticipante(participantes, entrada, nroCompetidores, tipoCircuito, datosParticipante);
                                } catch(InputMismatchException e) {
                                    System.out.println("Ingrese un número válido");
                                }
                                nroCompetidores++;
                                bandera = false;
                            }
                            else {
                                try {
                                    System.out.println("Digite su edad");
                                    int edad = entrada.nextInt();
                                    if(edad < 18) throw new Exception();
                                    annadirParticipante(participantes, entrada, nroCompetidores, tipoCircuito, datosParticipante);
                                    nroCompetidores++;
                                    bandera = false;
                                } catch(InputMismatchException e) {
                                    System.out.println("Ingrese un número valido");
                                } catch(Exception e) {
                                    System.out.println("Tiene que ser mayor de edad para inscribirse en este circuito");
                                }
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    int tipoCircuito;
                    System.out.println("Digite el tipo de circuito al que desea inscribirse" +
                            "\n1. Circuito chico" +
                            "\n2. Circuito medio" +
                            "\n3. Circuito avanzado");
                    tipoCircuito = entrada.nextInt();
                    for(Map.Entry<String, Object[]> entry : participantes.entrySet()) {
                        if((int) entry.getValue()[6] == tipoCircuito) {
                            System.out.println("DNI: " + String.valueOf(entry.getKey()));
                            System.out.println("Nombre: " + String.valueOf(entry.getValue()[0]));
                            System.out.println("Apellido: " + String.valueOf(entry.getValue()[1]));
                            System.out.println("Edad: " + String.valueOf(entry.getValue()[2]));
                            System.out.println("Celular: " + String.valueOf(entry.getValue()[3]));
                            System.out.println("Nro Emergencia: " + String.valueOf(entry.getValue()[4]));
                            System.out.println("Tipo de sangre: " + String.valueOf(entry.getValue()[5]));
                            System.out.println("Numero de inscripcion: " + String.valueOf(entry.getValue()[7]));
                            System.out.println();
                        }
                    }
                    break;
                }
                case 3: {
                    String dni;
                    System.out.print("Digite el DNI del participante a eliminar: ");
                    entrada.nextLine();
                    dni = entrada.nextLine();
                    participantes.remove(dni);
                    break;
                }
                case 4: {
                    String dni;
                    System.out.println("Digite el DNI del participante a consultar");
                    entrada.nextLine();
                    dni = entrada.nextLine();
                    int tipoCircuito = (int) participantes.get(dni)[6];
                    int edad = (int) participantes.get(dni)[2];
                    int totalACancelar= 0;
                    switch(tipoCircuito) {
                        case 1: {
                            if(edad >= 18) {
                                totalACancelar = 1500;
                            }
                            else {
                                totalACancelar = 1300;
                            }
                            break;
                        }
                        case 2: {
                            if (edad >= 18) {
                                totalACancelar = 2300;
                            }
                            else {
                                totalACancelar = 2000;
                            }
                            break;
                        }
                        case 3: {
                            totalACancelar = 2800;
                            break;
                        }
                    }
                    String mensaje = totalACancelar == 0 ? "Ud no se encuentra inscrito" : "Su total a cancelar es: " + totalACancelar;
                    System.out.println(mensaje);
                }
            }
        } while(opcion != 0);
    }

    private static void annadirParticipante(Map<String, Object[]> participantes, Scanner entrada, int nroCompetidores, int tipoCircuito, Object[] datosParticipante) {
        String dni;
        System.out.print("Digite su DNI: ");
        dni = entrada.next();
        System.out.print("Digite su Nombre: ");
        entrada.nextLine();
        datosParticipante[0] = entrada.nextLine();
        System.out.print("Digite su apellido: ");
        datosParticipante[1] = entrada.nextLine();
        System.out.print("Digite su edad: ");
        datosParticipante[2] = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Digite su celular: ");
        datosParticipante[3] = entrada.nextLine();
        System.out.print("Digite un número para casos de emergencia: ");
        datosParticipante[4] = entrada.nextLine();
        System.out.print("Digite su grupo sanguíneo: ");
        datosParticipante[5] = entrada.nextLine();
        datosParticipante[6] = tipoCircuito;
        datosParticipante[7] = nroCompetidores;
        participantes.put(dni, datosParticipante);
    }
}