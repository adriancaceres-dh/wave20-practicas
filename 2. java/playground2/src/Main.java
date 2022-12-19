import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int nro_de_inscriptos = 0;
    static List<Map<String, Object>> circuito_chico = new ArrayList<>();
    static List<Map<String, Object>> circuito_medio = new ArrayList<>();
    static List<Map<String, Object>> circuito_grande = new ArrayList<>();

    public static void inscribirParticipante(Map<String, Object> participante){
        System.out.print("Eligir circuito (1- Chico 2- Mediano 3- Grande): ");
        int opcion_elegida = scanner.nextInt();
        participante.put("nro_inscripto", ++nro_de_inscriptos);
        switch (opcion_elegida){
            case 1:
                circuito_chico.add(participante);
                break;
            case 2:
                circuito_medio.add(participante);
                break;
            case 3:
                circuito_grande.add(participante);
                break;
            default:
                System.out.println("Valor incorrecto");
                nro_de_inscriptos--;
        }
    }

    public static void desinscribirParticipante(int nro_inscripto, int cod_circuito){
        //cod_circuito: 1- Chico 2- Mediano 3- Grande
        List<Map<String, Object>> auxiliarList = new ArrayList<>();
        switch (cod_circuito){
            case 1:
                for(Map<String, Object> participante: circuito_chico){
                    if(!participante.get("nro_inscripto").equals(nro_inscripto)) auxiliarList.add(participante);
                }
                circuito_chico = auxiliarList;
                break;
            case 2:
                for(Map<String, Object> participante: circuito_medio){
                    if(!participante.get("nro_inscripto").equals(nro_inscripto)) auxiliarList.add(participante);
                }
                circuito_medio = auxiliarList;
                break;
            case 3:
                for(Map<String, Object> participante: circuito_grande){
                    if(!participante.get("nro_inscripto").equals(nro_inscripto)) auxiliarList.add(participante);
                }
                circuito_grande = auxiliarList;
                break;
        }
    }

    public static void determinarMonto(int edad, int cod_circuito){
        //cod_circuito: 1- Chico 2- Mediano 3- Grande
        switch (cod_circuito){
            case 1:
                if (edad<18) System.out.println(1300);
                else System.out.println(1500);
                break;
            case 2:
                if (edad<18) System.out.println(2000);
                else System.out.println(2300);
                break;
            case 3:
                if (edad<18) System.out.println("No puedes inscribirte en esta categoría");
                else System.out.println(2800);
                break;
        }

    }

    public static void listarParticipantes(List<Map<String, Object>> circuito){
        for (Map<String, Object> participante: circuito){
            System.out.println(participante);
        }
    }

    public static void main(String[] args) {

        Map<String, Object> participante1 = new HashMap<>();
        participante1.put("dni", 12345678);
        participante1.put("nombre", "juan");
        participante1.put("apellido", "perez");
        participante1.put("edad", 20);
        participante1.put("celular", 11111111);
        participante1.put("nro_emergencia", 22222222);
        participante1.put("grupo_sangre", "B+");

        Map<String, Object> participante2 = new HashMap<>();
        participante2.put("dni", 12343678);
        participante2.put("nombre", "rodolfo");
        participante2.put("apellido", "hernandez");
        participante2.put("edad", 25);
        participante2.put("celular", 22111111);
        participante2.put("nro_emergencia", 22332222);
        participante2.put("grupo_sangre", "B-");

        //dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo

        inscribirParticipante(participante1);
        inscribirParticipante(participante2);
        desinscribirParticipante(1, 1);
        listarParticipantes(circuito_chico);
    }
}
