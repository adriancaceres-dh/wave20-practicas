package main;
import java.util.*;

public class EjercicioCarreraDeLaSelva {
    public static TreeMap<Integer,Map<String,String>> inscriptos = new TreeMap<>();
    public static void main(String[] args){
        Map<String,String> participante_uno = crearParticipante("Ignacio","Tornati","17","1140828295","0+", "42192987");
        Map<String,String> participante_dos = crearParticipante("Julian","Alvarez","24","1156020869","0+","46567876");
        Map<String,String> participante_tres = crearParticipante("Agustin","Tornati","23","1140828295","0+", "42192987");
        Map<String,String> participante_cuatro = crearParticipante("Lautaro","Martinez","23","1140828295","0+", "42192987");

        Map<String, Object> circuitoChico = crearCategoria(1500,1300, "Circuito Chico");
        Map<String, Object> circuitoMedio = crearCategoria(2300,2000, "Circuito Medio");
        Map<String, Object> circuitoAvanzado = crearCategoria(2000, "Circuito Avanzado");

        inscribirParticipante(circuitoChico, participante_tres);
        inscribirParticipante(circuitoAvanzado, participante_uno);
        inscribirParticipante(circuitoMedio, participante_uno);
        inscribirParticipante(circuitoMedio, participante_tres);
        inscribirParticipante(circuitoMedio, participante_dos);
        inscribirParticipante(circuitoAvanzado, participante_cuatro);

        listarInscriptosCategoria(circuitoChico);
        listarInscriptosCategoria(circuitoMedio);
        listarInscriptosCategoria(circuitoAvanzado);

    }

    public static void inscribirParticipante(Map<String, Object> categoria,Map<String,String> participante){
        if(!inscriptos.containsValue(participante)){
            if((Boolean)categoria.get("aceptaMenores")){
                int montoAPagar = calcularMontoAPagar(categoria,participante);
                Integer id = inscriptos.isEmpty() ? 0 : inscriptos.lastKey() + 1;
                inscriptos.put(id, participante);
                ((ArrayList<Map<String,String>>) categoria.get("participantes")).add(participante);
                System.out.println("El participante " + participante.get("nombre") + " " + participante.get("apellido") + " ha sido inscripto a la carrera "+ categoria.get("nombre") + " con el id " + id + " y el monto a pagar es " + montoAPagar);

            }else{
                if((Integer.parseInt(participante.get("edad")))>=18){
                    int montoAPagar = calcularMontoAPagar(categoria,participante);
                    Integer id = inscriptos.isEmpty() ? 0 : inscriptos.lastKey() + 1;
                    inscriptos.put(id, participante);
                    ((ArrayList<Map<String,String>>) categoria.get("participantes")).add(participante);
                    System.out.println("El participante " + participante.get("nombre") + " " + participante.get("apellido") + " ha sido inscripto a la carrera "+ categoria.get("nombre") + " con el id " + id + " y el monto a pagar es " + montoAPagar);
                }else{
                    System.out.println("No se puede inscribir el participante " + participante.get("nombre") + " " + participante.get("apellido") + " a la categoria porque no cumple con la mayoria de edad");
                }
            }
        }else{
            System.out.println("No se puede inscribir el participante " + participante.get("nombre") + " " + participante.get("apellido") + " a la categoria porque ya se encuentra inscripto en ese u otro circuito");        }
    }

    public static Map<String,String> crearParticipante(String nombre, String apellido, String edad, String telefono, String sangre, String dni){
        Map<String,String> participante = new HashMap<>();
        participante.put("dni",dni);
        participante.put("nombre",nombre);
        participante.put("apellido",apellido);
        participante.put("edad", edad);
        participante.put("celular", telefono);
        participante.put("sangre", sangre);

        return participante;
    }

    public static int calcularMontoAPagar(Map<String, Object> categoria,Map<String,String> participante){
        int montoAPagar;
        if ((Integer.parseInt(participante.get("edad")))>=18){
            montoAPagar = (int) categoria.get("precioMayores");
        }else{
            montoAPagar = (int) categoria.get("precioMenores");
        }

        return montoAPagar;
    }

    public static Map<String, Object> crearCategoria (int precioMayores, int precioMenores, String nombre){
        Map<String, Object> categoria = new HashMap<>();
        categoria.put("nombre",nombre);
        categoria.put("participantes",new ArrayList<Map<String,String>>());
        categoria.put("precioMenores",precioMenores);
        categoria.put("precioMayores",precioMayores);
        categoria.put("aceptaMenores",true);

        return categoria;
    }

    public static Map<String, Object> crearCategoria (int precioMayores, String nombre){
        Map<String, Object> categoria = new HashMap<>();
        categoria.put("nombre",nombre);
        categoria.put("participantes",new ArrayList<Map<String,String>>());
        categoria.put("precioMayores",precioMayores);
        categoria.put("aceptaMenores",false);

        return categoria;
    }



    public static void listarInscriptosCategoria (Map<String, Object> categoria){
        ArrayList<Map<String,String>> participantes = (ArrayList<Map<String,String>>) categoria.get("participantes");
        System.out.println("----------Inscriptos en " + categoria.get("nombre") + " ------------------------------------");
        for(Map<String,String> participante : participantes){
            System.out.println(participante);
        }
        System.out.println("-------------------------------------------------------------------------");
    }
}
