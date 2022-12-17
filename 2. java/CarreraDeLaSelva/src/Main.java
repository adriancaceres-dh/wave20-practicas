import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    final static int COD_CIRCUITO_CHICO = 0;
    final static int COD_CIRCUITO_MEDIO = 1;
    final static int COD_CIRCUITO_AVANZADO = 2;

    public static void main(String[] args) {

        //Map de participantes
        //Los participantes deberian ser arrays con datos, los circuitos maps con el numero de inscripcion como key
        ArrayList<String[]> participantes = new ArrayList<>();
        int numeroDeInscripto = 1;

        //Maps de circuitos
        Map<Integer, String[]> circuitoChico = new HashMap<Integer, String[]>();
        Map<Integer, String[]> circuitoMedio = new HashMap<Integer, String[]>();
        Map<Integer, String[]> circuitoAvanzado = new HashMap<Integer, String[]>();

        //declaracion de participantes

        String[] participante1 = new String[8];
        participante1[0] = "Lautaro";
        participante1[1] = "Walsh";
        participante1[2] = "27";
        participante1[3] = "A";
        participante1[4] = "1123444567";
        participante1[5] = "1123345567";
        participante1[6] = "39106633";

        String[] participante2 = new String[8];
        participante2[0] = "Patricio";
        participante2[1] = "Estrella";
        participante2[2] = "18";
        participante2[3] = "0";
        participante2[4] = "1123444567";
        participante2[5] = "1123345567";
        participante2[6] = "39654778";

        String[] participante3 = new String[8];
        participante3[0] = "Bob";
        participante3[1] = "Esponja";
        participante3[2] = "12";
        participante3[3] = "0-";
        participante3[4] = "1123444567";
        participante3[5] = "1123345567";
        participante3[6] = "43556123";

        //ingreso 2 veces un participante con el mismo dni para forzar el error

        participantes.add(participante1);
        participantes.add(participante2);
        participantes.add(participante3);
        participantes.add(participante3);

        //Almacenamiento de participantes en circuitos
        for (String[] participante : participantes) {

            if (verificarParticipanteAnotado(participante[6], circuitoChico)
                    && verificarParticipanteAnotado(participante[6], circuitoMedio)
                    && verificarParticipanteAnotado(participante[6], circuitoAvanzado)) {

                //Asigno participantes aleatoriamente a circuitos

                int codigoCircuito = (int) (Math.random() * 3);
                if (codigoCircuito == COD_CIRCUITO_CHICO) {
                    participante[7] = "" + COD_CIRCUITO_CHICO;
                    circuitoChico.put(numeroDeInscripto, participante);
                    System.out.println("Se ingreso a participante nro " + numeroDeInscripto + ", " + participante[0] + " " + participante[1] + " en circuito chico");
                    numeroDeInscripto++;
                } else if (codigoCircuito == COD_CIRCUITO_MEDIO) {
                    participante[7] = "" + COD_CIRCUITO_MEDIO;
                    circuitoMedio.put(numeroDeInscripto, participante);
                    System.out.println("Se ingreso a participante nro " + numeroDeInscripto + ", " + participante[0] + " " + participante[1] + " en circuito medio");
                    numeroDeInscripto++;
                } else {
                    if (Integer.parseInt(participante[2]) >= 18) {
                        participante[7] = "" + COD_CIRCUITO_AVANZADO;
                        circuitoAvanzado.put(numeroDeInscripto, participante);
                        System.out.println("Se ingreso a participante nro " + numeroDeInscripto + ", " + participante[0] + " " + participante[1] + " en circuito avanzado");
                        numeroDeInscripto++;
                    } else {
                        System.out.println("No se pudo ingresar a " + participante[0] + " " + participante[1] + " al circuito AVANZADO debido a que es menor de edad");
                    }
                }
            } else {
                System.out.println("No se pudo ingresar a " + participante[0] + " " + participante[1] + " porque ya se encontraba anotado en otro circuito");
            }
        }

        //muestro datos de cada circuito
        System.out.println("CIRCUITO CHICO:");
        mostrarDatosCircuito(circuitoChico);
        System.out.println("CIRCUITO MEDIANO:");
        mostrarDatosCircuito(circuitoMedio);
        System.out.println("CIRCUITO AVANZADO:");
        mostrarDatosCircuito(circuitoAvanzado);

        //elimino participante de un circuito (podria mejorarse mucho)
        Map.Entry<Integer, String[]> participanteEliminado;
        String participanteEliminadoNombre;

        if (!circuitoAvanzado.isEmpty()) {

            participanteEliminado = circuitoAvanzado.entrySet().iterator().next();
            participanteEliminadoNombre = participanteEliminado.getValue()[0] + " " + participanteEliminado.getValue()[1];
            circuitoAvanzado.remove(participanteEliminado.getKey());
            System.out.println(participanteEliminadoNombre + " ha sido removido del circuito avanzado");

        } else if (!circuitoMedio.isEmpty()) {

            participanteEliminado = circuitoMedio.entrySet().iterator().next();
            participanteEliminadoNombre = participanteEliminado.getValue()[0] + " " + participanteEliminado.getValue()[1];
            circuitoMedio.remove(participanteEliminado.getKey());
            System.out.println(participanteEliminadoNombre + " ha sido removido del circuito medio");

        } else if (!circuitoChico.isEmpty()) {

            participanteEliminado = circuitoChico.entrySet().iterator().next();
            participanteEliminadoNombre = participanteEliminado.getValue()[0] + " " + participanteEliminado.getValue()[1];
            circuitoChico.remove(participanteEliminado.getKey());
            System.out.println(participanteEliminadoNombre + " ha sido removido del circuito chico");

        }
    }

    public static int obtenerPrecio(Map.Entry<Integer, String[]> participante) {
        int codigoCircuito = Integer.parseInt(participante.getValue()[7]);
        int edadParticipante = Integer.parseInt(participante.getValue()[2]);
        if (codigoCircuito == COD_CIRCUITO_CHICO) {
            if (edadParticipante >= 18) {
                return 1500;
            }
            return 1300;

        } else if (codigoCircuito == COD_CIRCUITO_MEDIO) {
            if (edadParticipante >= 18) {
                return 2300;
            }
            return 2000;
        } else {
            return 2800;
        }
    }

    public static void mostrarDatosCircuito(Map<Integer, String[]> circuito) {
        System.out.println("-----------------------------------------");
        for (var participante : circuito.entrySet()) {
            System.out.println("participante nro " + participante.getKey());
            System.out.println(participante.getValue()[0] + " " + participante.getValue()[1]);
            System.out.println(participante.getValue()[2] + " anios");
            System.out.println("sangre tipo " + participante.getValue()[3]);
            System.out.println("numeros de telefono: " + participante.getValue()[4] + ", " + participante.getValue()[5]);
            System.out.println("DNI: " + participante.getValue()[6]);
            System.out.println("Precio a pagar: $" + obtenerPrecio(participante));
            System.out.println("-----------------------------------------");

        }
    }

    public static Boolean verificarParticipanteAnotado(String dni, Map<Integer, String[]> circuito) {
        for (String[] participante : circuito.values()) {
            if (participante[6] == dni) {
                return false;
            }
        }
        return true;
    }

}