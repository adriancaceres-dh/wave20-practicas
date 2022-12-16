import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static final String DNI = "DNI";
    public static final String NOMBRE = "NOMBRE";
    public static final String APELLIDO = "APELLIDO";
    public static final String EDAD = "EDAD";
    public static final String CELULAR = "CELULAR";
    public static final String NUMERO_EMERGENCIA = "NUMERO_EMERGENCIA";
    public static final String GRUPO_SANGUINEO = "GRUPO_SANGUINEO";
    public static final String IDENTIFICADOR = "IDENTIFICADOR";

    private static HashMap<Integer, Map<String, Object>> participantes = new HashMap<>();

    private static HashMap<Integer, Integer> identificadorDniParticipantes = new HashMap<>();
    private static HashMap<String,List<Integer>> circuitos = new HashMap<>();
    private static List<Integer> circuitoChico = new ArrayList<>();
    private static List<Integer> circuitoMedio = new ArrayList<>();
    private static List<Integer> circuitoAvanzado = new ArrayList<>();
    private static int identificador = 1;
    public static void main(String[] args) {


        Map<String, Object> participante1 = new HashMap<>();
        participante1.put(DNI, 111111);
        participante1.put(NOMBRE, "Nombre1");
        participante1.put(APELLIDO, "Apellido1");
        participante1.put(EDAD, 1);
        participante1.put(CELULAR, 1);
        participante1.put(NUMERO_EMERGENCIA, 1);
        participante1.put(GRUPO_SANGUINEO, 1);
        participante1.put(IDENTIFICADOR,null);

        Map<String, Object> participante2 = new HashMap<>();
        participante2.put(DNI, 222222);
        participante2.put(NOMBRE, "Nombre2");
        participante2.put(APELLIDO, "Apellido2");
        participante2.put(EDAD, 2);
        participante2.put(CELULAR, 2);
        participante2.put(NUMERO_EMERGENCIA, 2);
        participante2.put(GRUPO_SANGUINEO, 2);
        participante2.put(IDENTIFICADOR,null);

        Map<String, Object> participante3 = new HashMap<>();
        participante3.put(DNI, 333333);
        participante3.put(NOMBRE, "Nombre3");
        participante3.put(APELLIDO, "Apellido3");
        participante3.put(EDAD, 18);
        participante3.put(CELULAR, 3);
        participante3.put(NUMERO_EMERGENCIA, 3);
        participante3.put(GRUPO_SANGUINEO, 3);
        participante3.put(IDENTIFICADOR,null);

        inscribirParticipante("1", participante1);
        inscribirParticipante("2", participante2);
        inscribirParticipante("3", participante3);


        circuitos.put("Circuito Chico", circuitoChico);
        circuitos.put("Circuito Medio", circuitoMedio);
        circuitos.put("Circuito Avanzado",circuitoAvanzado);

        imprimirParticipantesPorCircuitos();

        desinscribirParticipante(participante1);
        System.out.println("se desincribe participante 1");
        imprimirParticipantesPorCircuitos();
    }

    public static void inscribirParticipante(String circuito, Map<String, Object> participante){
        if(circuito.equals("3") && ((Integer)participante.get(EDAD) < 18)) {
            System.out.println("Este participante no puede inscribirse a este circuito por su edad");
        }else{
            if (participantes.get(participante) == null) {
                participantes.put((Integer) participante.get(DNI), participante);
                identificadorDniParticipantes.put(identificador, (Integer) participante.get(DNI));
                participante.put(IDENTIFICADOR, identificador);
                switch (circuito) {
                    case "1":
                        circuitoChico.add(identificador);
                        System.out.println("El participante "+ participante.get(NOMBRE) + " debera abonar: " + ((Integer) participante.get(EDAD) >= 18 ? "1500" : "1300"));
                        break;
                    case "2":
                        circuitoMedio.add(identificador);
                        System.out.println("El participante "+ participante.get(NOMBRE) + " debera abonar: " + ((Integer) participante.get(EDAD) >= 18 ? "2300" : "2000"));
                        break;
                    case "3":
                        circuitoAvanzado.add(identificador);
                        System.out.println("El participante "+ participante.get(NOMBRE) + " debera abonar: 2800");
                        break;
                }
                identificador++;
            } else {
                System.out.println("El participante ya esta registrado");
            }
        }
    }
    public static void desinscribirParticipante(Map<String, Object> participante){
        if(participantes.get(participante.get(DNI)) != null){
            participantes.remove(participante.get(DNI));
            identificadorDniParticipantes.remove(participante.get(IDENTIFICADOR));
            for(String circuito : circuitos.keySet()){
                int i=0;
                for(Integer identificadorParticipante : circuitos.get(circuito)){
                    if(identificadorParticipante == participante.get(IDENTIFICADOR)){
                        circuitos.get(circuito).remove(i);
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public static void imprimirParticipantesPorCircuitos(){
        for(String circuito : circuitos.keySet()){
            System.out.println("Los participantes del " + circuito + " son:");
            for(Integer identificadorParticipante : circuitos.get(circuito)){
                int dniParticipante = identificadorDniParticipantes.get(identificadorParticipante);
                System.out.println("Participante: " + identificadorParticipante + ", " + participantes.get(dniParticipante));
            }
        }
    }

}