import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;


public class Main {

    public static Map<String, List<List<String>>> circuitos = new HashMap<>();
    public static Integer contador = 0;


    public static void main(String[] args) {
        Date date = new Date();

        circuitos.put("chico", new ArrayList<>());
        circuitos.put("medio", new ArrayList<>());
        circuitos.put("avanzado", new ArrayList<>());

        agrgarParticipante("1007414252", "Tomas", "22", "3176000792", "3219235970", "+A", "chico");
        agrgarParticipante("0293749234", "Jhon", "17", "3176000792", "3219235970", "+A", "avanzado");
        agrgarParticipante("2437598023", "Ronald", "22", "3176000792", "3219235970", "+A", "avanzado");

        agrgarParticipante("9023847983", "Giovanny", "22", "3176000792", "3219235970", "+A", "chico");
        agrgarParticipante("9842379857", "Juliana", "22", "3176000792", "3219235970", "+A", "medio");
        agrgarParticipante("5423iu0982", "María", "22", "3176000792", "3219235970", "+A", "medio");

        agrgarParticipante("54233409u4", "Fernanda", "17", "3176000792", "3219235970", "+B", "chico");
        agrgarParticipante("8732848978", "Juan", "17", "3176000792", "3219235970", "+A", "medio");
        agrgarParticipante("4329893824", "Ricardo", "22", "3176000792", "3219235970", "+A", "avanzado");

        //listarParticipantesCircuitoChico();
        //listarParticipantesCircuitoMedio();
        //listarParticipantesCircuitoAvanzado();
        listarParticipantesCircuitos();

        eliminarParticipantePorCircuitoYIndex("chico", "1");
        eliminarParticipantePorId("9");

        listarParticipantesCircuitos();





    }

    // a) en esta funcion se reciben por parametros los datos del participante y el ultimo recibe el tipo de circuito (chico, medio, avanzado)
    // d) En la misma funcion de agregar participantes se hacen las respectivas validaciones de la edad
    public static void agrgarParticipante(String dni, String nombre, String edad, String celular, String numeroEmergencia, String grupoSanguineo, String circuito) {

        contador++;
        int edadAux= Integer.parseInt(edad);
        String monto;
        if (circuito.equals("chico")) {
            if(edadAux < 18){
                monto = "1300";
            } else {
                monto = "1500";
            }
            circuitos.get("chico").add(Arrays.asList(contador.toString(), dni, nombre, edad, celular, numeroEmergencia, grupoSanguineo, monto, circuito));
        } else if (circuito.equals("medio")) {
            if(edadAux < 18){
                monto = "2000";
            } else {
                monto = "2300";
            }
            circuitos.get("medio").add(Arrays.asList(contador.toString(), dni, nombre, edad, celular, numeroEmergencia, grupoSanguineo, monto, circuito));
        } else if (circuito.equals("avanzado")) {
            if(edadAux < 18){
                System.out.println("El participante debe ser mayor de edad para entrar en el Circuito avanzado");
                return;
            }
            monto = "2800";
            circuitos.get("avanzado").add(Arrays.asList(contador.toString(), dni, nombre, edad, celular, numeroEmergencia, grupoSanguineo, monto, circuito));
        } else {
            contador--;
            System.out.println("El circuito no existe");
        }
    }

    // b) se implementaron 3 metodos para listar los participantes por cada categoría y uno que lista todas las categoriass
    public static void listarParticipantesCircuitoChico() {
        System.out.println("********************************************");
        System.out.println("Participantes Circuito chico");
        System.out.println("********************************************");
        System.out.println( "[id, dni, nombre, apellido, edad, celular, número de emergencia, grupo sanguíneo, monto, circuito]");
        for (List<String> registro : circuitos.get("chico")) {
            System.out.println(registro);
        }
        System.out.println();
    }

    public static void listarParticipantesCircuitoMedio() {

        System.out.println("********************************************");
        System.out.println("Participantes Circuito medio");
        System.out.println("********************************************");
        System.out.println( "[id, dni, nombre, apellido, edad, celular, número de emergencia, grupo sanguíneo, monto, circuito]");

        for (List<String> registro : circuitos.get("medio")) {
            System.out.println(registro);
        }
        System.out.println();
    }

    public static void listarParticipantesCircuitoAvanzado() {
        System.out.println("********************************************");
        System.out.println("Participantes Circuito avanzado");
        System.out.println("********************************************");
        System.out.println( "[id, dni, nombre, apellido, edad, celular, número de emergencia, grupo sanguíneo, monto, circuito]");

        for (List<String> registro : circuitos.get("avanzado")) {
            System.out.println(registro);
        }
        System.out.println();

    }

    public static void listarParticipantesCircuitos() {
        listarParticipantesCircuitoChico();
        listarParticipantesCircuitoMedio();
        listarParticipantesCircuitoAvanzado();
    }

    // c) se implementaron 2 metodos uno elimina participantes pasando por parametros el circuito y el id, el otro pasando por parametro unicamente el id, pero es menos eficiente.
    public static void eliminarParticipantePorCircuitoYIndex(String circuito, String id) {

        if (!circuito.equals("chico") && !circuito.equals("medio") && !circuito.equals("avanzado")) {
            System.out.println("circuito no valido");
            return;
        }
        boolean flag = true;
        int index = 0;
        for (List<String> registro : circuitos.get(circuito)) {
            if (registro.get(0).equals(id)) {
                System.out.println("se eliminó el participante: " + registro);
                circuitos.get(circuito).remove(index);
                flag = false;
                break;
            }
            index++;
        }

        if (flag) {
            System.out.println("Participante no encontrado");
        }
    }

    public static void eliminarParticipantePorId(String id) {

        String[] nombresCircuitos = {"chico", "medio", "avanzado"};
        boolean flag = true;
        for (int i = 0; i < nombresCircuitos.length; i++) {
            List<List<String>> circuito = circuitos.get(nombresCircuitos[i]);
            for (int j = 0; j < circuito.size(); j++) {
                if (circuito.get(j).get(0).equals(id)) {
                    System.out.println("se eliminó el participante: " + circuitos.get(nombresCircuitos[i]).remove(j));
                    flag = false;
                    break;
                }
            }

        }

        if (flag) {
            System.out.println("Participante no encontrado");
        }

    }


    }


