import java.util.*;

public class Main {

    static int[] participantes = {0,0,0}; //participantes circuito chico, circuito medio y circuito avanzado

    static Map<String, Map<String, Map<String, String>>> circuitos = new HashMap<>();

    static Map<String,Map<String,Integer>> precios = new HashMap<>();

    static Map<String,Map<String,String>> participantesCircuitoChico = new HashMap<>();
    static Map<String,Map<String,String>> participantesCircuitoMedio = new HashMap<>();
    static Map<String,Map<String,String>> participantesCircuitoAvanzado = new HashMap<>();

    static Map<String,Integer> preciosCircuitoChico = new HashMap<>();
    static Map<String,Integer> preciosCircuitoMedio = new HashMap<>();
    static Map<String,Integer> preciosCircuitoAvanzado = new HashMap<>();


    // Verificar si usuario ya esta registrado
    static boolean participanteYaRegistrado(String dni){
        for (String circuito: circuitos.keySet()) {
            if((circuitos.get(circuito).get(dni)) != null){
                return true;
            }
        }
        return false;
    }

    // Precio de inscripcion
    static Integer obtenerPrecio(String circuito, Integer edad){

        if (edad < 18){
            if (precios.get(circuito).get("menores") != null) {
                return (precios.get(circuito).get("menores"));
            }
            else {
                return null;
            }
        }
        return (precios.get(circuito).get("adultos"));
    }

    static int obtenerNumeroParticipante(String circuito){
        switch (String.valueOf(circuito)) {
            case "circuito chico":
                return (++participantes[0]);
            case "circuito medio":
                return (++participantes[1]);
            case "circuito avanzado":
                return (++participantes[2]);
            default:
                return -1;
        }
    }

    static void inscribirParticipante(String dni, Integer edad, String nombre, String apellido, String celular,
                                      String telefonoDeEmergencia, String grupoSanguineo, String circuito){

        Map<String, Map<String, String>> participantesCircuito = circuitos.get(circuito);
        Integer precio = obtenerPrecio(circuito,edad);

        int participanteNumero = obtenerNumeroParticipante(circuito);


        if (!participanteYaRegistrado(dni) && precio != null){
            Map<String,String> participante = new HashMap<>();
            participante.put("dni",dni);
            participante.put("edad",edad+" años");
            participante.put("nombre",nombre);
            participante.put("apellido",apellido);
            participante.put("celular", celular);
            participante.put("numero emergencia", telefonoDeEmergencia);
            participante.put("grupo sanguineo", grupoSanguineo);
            participante.put("numero de participante",participanteNumero + "");
            participantesCircuito.put(dni,participante);
            System.out.println("agregado exitosamente, debera abonar $" + precio);
        }
        else{
            if (precio == null){
                System.out.println("No se pudo agregar al participante - Este circuito no admite menores");
            }
            else {
                    System.out.println("No se pudo agregar al participante - Ya se registro un participante con este DNI");
            }

        }

    }

    public static void mostrarParticipantes(String circuito){
        switch(circuito){
            case "circuito chico":
                System.out.println("participantes Circuito Chico: " + participantesCircuitoChico.toString());
                break;
            case "circuito medio":
                System.out.println("participantes Circuito Medio: " + participantesCircuitoMedio.toString());
                break;
            case "circuito avanzado":
                System.out.println("participantes Circuito Avanzado: " + participantesCircuitoAvanzado.toString());
                break;
        }
    }


    static void eliminarParticipante(String dni){
        if (participantesCircuitoChico.get(dni) != null){
            participantesCircuitoChico.remove(dni);
            System.out.println("Se elimino correctamente al participante con dni "+dni);
        }
        else if (participantesCircuitoMedio.get(dni) != null){
            participantesCircuitoMedio.remove(dni);
            System.out.println("Se elimino correctamente al participante con dni "+dni);
        }
        else if (participantesCircuitoAvanzado.get(dni) != null) {
            participantesCircuitoAvanzado.remove(dni);
            System.out.println("Se elimino correctamente al participante con dni "+dni);
        }
        else {
            System.out.println("No hay ningun participante inscripto con dni " + dni);
        }

    }

    public static void main(String[] args) {

        Integer PRECIOS_CIRCUITOCHICO_MENORES = 1300;
        Integer PRECIOS_CIRCUITOCHICO_ADULTOS = 1500;
        Integer PRECIOS_CIRCUITOMEDIO_MENORES = 2000;
        Integer  PRECIOS_CIRTCUITOMEDIO_ADULTOS = 2300;
        Integer PRECIOS_CIRCUITOAVANZADO_ADULTOS = 2800;


        circuitos.put("circuito chico", participantesCircuitoChico);
        circuitos.put("circuito medio", participantesCircuitoMedio);
        circuitos.put("circuito avanzado",participantesCircuitoAvanzado);

        preciosCircuitoChico.put("menores", PRECIOS_CIRCUITOCHICO_MENORES);
        preciosCircuitoChico.put("adultos", PRECIOS_CIRCUITOCHICO_ADULTOS);
        preciosCircuitoMedio.put("menores", PRECIOS_CIRCUITOMEDIO_MENORES);
        preciosCircuitoMedio.put("adultos", PRECIOS_CIRTCUITOMEDIO_ADULTOS);
        preciosCircuitoAvanzado.put("adultos", PRECIOS_CIRCUITOAVANZADO_ADULTOS);

        precios.put("circuito chico",preciosCircuitoChico);
        precios.put("circuito medio",preciosCircuitoMedio);
        precios.put("circuito avanzado",preciosCircuitoAvanzado);

        // Caso 1 - Deberia inscribir a los participantes
        System.out.println("----- 1- Deberia inscribir a los participantes ");
        inscribirParticipante("37550240",28,"francisco","berthet","1138175764",
                "1138175764","O+","circuito chico");
        inscribirParticipante("34567894",30,"francisco","berthet","1138175764",
                "1138175764","O+","circuito chico");
        inscribirParticipante("37550270",28,"nahuel","test","1138175764",
                "1138175764","O+","circuito chico");
        inscribirParticipante("99999999",12,"test","apellido","1138175764",
                "1138175764","O+","circuito medio");
        inscribirParticipante("77777777",22,"test","apellido","1138175764",
                "1138175764","O+","circuito avanzado");

        // Caso 1 - Bis - no deberia poder registrarse en avanzado siendo menor
        System.out.println("----- 1 bis - no deberia poder registrarse en avanzado siendo menor ");
        inscribirParticipante("11111111",12,"nombre","apellido","1138175764",
                "1138175764","O+","circuito avanzado");

        // Caso 2 - No deberia dejar agregar a un participante ya inscripto
        System.out.println("----- 2 - No deberia dejar agregar a un participante ya inscripto");
        inscribirParticipante("37550240",28,"francisco","berthet","1138175764",
                "1138175764","O+","circuito chico");

        System.out.println("----- 3 - No deberia agregar a un participante ya inscripto en otro circuito ");
        // Caso 3 - No deberia agregar a un participante ya inscripto en otro circuito
          inscribirParticipante("37550240",28,"francisco","berthet","1138175764",
                  "1138175764","O+","circuito medio");


        //mostrar participantes
        System.out.println("----- 4 - Deberia mostrar los participantes de todos los circuitos ");
        mostrarParticipantes("circuito chico");
        mostrarParticipantes("circuito medio");
        mostrarParticipantes("circuito avanzado");

        //eliminar participantes
        System.out.println("----- 5 - Deberia eliminar un participante si esta inscripto en alguna categoria ");
        eliminarParticipante("37550240");
        eliminarParticipante("2345678");

    }
}