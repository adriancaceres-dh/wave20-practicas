package Bootcamp;

import java.util.HashMap;
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
                                anadirParticipante(entrada, nroCompetidores, tipoCircuito, datosParticipante);
                                nroCompetidores++;
                            }
                            else {
                                try {
                                    System.out.println("Digite su edad");
                                    int edad = entrada.nextInt();
                                    if(edad < 18) throw new Exception();
                                    anadirParticipante(entrada, nroCompetidores, tipoCircuito, datosParticipante);
                                } catch(Exception e) {
                                    System.out.println("Tiene que ser mayor de edad");
                                }
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    
                }
            }
        } while(opcion != 0);
    }

    private static void anadirParticipante(Scanner entrada, int nroCompetidores, int tipoCircuito, Object[] datosParticipante) {
        String dni;
        System.out.println("Digite su DNI");
        dni = entrada.nextLine();
        System.out.println("Digite su Nombre");
        datosParticipante[0] = entrada.nextLine();
        System.out.println("Digite su apellido");
        datosParticipante[1] = entrada.nextLine();
        System.out.println("Digite su edad");
        datosParticipante[2] = entrada.nextInt();
        System.out.println("Digite su celular");
        datosParticipante[3] = entrada.nextLine();
        System.out.println("Digite un número para casos de emergencia");
        datosParticipante[4] = entrada.nextLine();
        System.out.println("Digite su grupo sanguíneo");
        datosParticipante[5] = entrada.nextLine();
        datosParticipante[6] = tipoCircuito;
        datosParticipante[7] = nroCompetidores;
    }
}