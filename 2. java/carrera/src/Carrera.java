import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Carrera {

    static Map<String, HashSet<Integer>> circuitos;
    static Map<Integer, Map<String, Object>> participantes;
    static HashSet<String> inscritos;
    static int numeroUltimoParticipante;

    public static void inscribirParticipante(Map<String,Object> participante, String categoria) {
        if(inscritos.contains(participante.get("dni"))) {
            System.out.println("El participante ya está inscrito.");
            return;
        }

        int montoAbono = calcularMontoAbono(categoria, (Integer)participante.get("edad"));

        if(montoAbono == 0) {
            System.out.println("El participante no puede participar en esta categoría.");
            return;
        }

        participante.put("montoAbono", montoAbono);
        numeroUltimoParticipante++;

        participantes.put(numeroUltimoParticipante, participante);
        circuitos.get(categoria).add(numeroUltimoParticipante);
        inscritos.add((String)participante.get("dni"));
    }

    public static void mostrarParticipantesPorCategoria(String categoria) {
        HashSet<Integer> participantesCategoria = circuitos.get(categoria);

        for(Integer numero : participantesCategoria) {
            System.out.println("Participante número " + numero + ": " + participantes.get(numero));
        }
    }

    public static void desinscribirParticipante(int numeroParticipante, String categoria) {
        if(!participantes.containsKey(numeroParticipante))  return;

        Map<String, Object> participante = participantes.get(numeroParticipante);

        if(circuitos.get(categoria).remove(numeroParticipante)) {
            inscritos.remove(participante.get("dni"));
            participantes.remove(numeroParticipante);
        }
    }

    private static int calcularMontoAbono(String circuito, int edad) {
        switch (circuito) {
            case "chico":
                return edad < 18 ? 1300 : 1500;
            case "medio":
                return edad < 18 ? 2000 : 2300;
            case "avanzado":
                return edad < 18 ? 0 : 2800;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        // Inicializar colecciones
        circuitos = new HashMap<>();
        participantes = new HashMap<>();
        inscritos = new HashSet<>();

        // Inicializar circuitos
        circuitos.put("chico", new HashSet<>());
        circuitos.put("medio", new HashSet<>());
        circuitos.put("avanzado", new HashSet<>());

        // Agregar participantes
        HashMap<String, Object> participante1 = new HashMap<>() {{
            put("dni", "DNI1");
            put("nombre", "Nombre1");
            put("apellido", "Apellido1");
            put("edad", 34);
            put("celular", "1234567890");
            put("numerEmergencia","1236543456");
            put("grupoSanguineo","A+");
        }};

        HashMap<String, Object> participante2 = new HashMap<>() {{
            put("dni", "DNI2");
            put("nombre", "Nombre2");
            put("apellido", "Apellido2");
            put("edad", 14);
            put("celular", "1234567890");
            put("numerEmergencia","1236543456");
            put("grupoSanguineo","A+");
        }};

        HashMap<String, Object> participante3 = new HashMap<>() {{
            put("dni", "DNI3");
            put("nombre", "Nombre3");
            put("apellido", "Apellido3");
            put("edad", 23);
            put("celular", "1234567890");
            put("numerEmergencia","1236543456");
            put("grupoSanguineo","A+");
        }};

        HashMap<String, Object> participante4 = new HashMap<>() {{
            put("dni", "DNI4");
            put("nombre", "Nombre4");
            put("apellido", "Apellido4");
            put("edad", 18);
            put("celular", "1234567890");
            put("numerEmergencia","1236543456");
            put("grupoSanguineo","A+");
        }};

        HashMap<String, Object> participante5 = new HashMap<>() {{
            put("dni", "DNI5");
            put("nombre", "Nombre5");
            put("apellido", "Apellido5");
            put("edad", 8);
            put("celular", "1234567890");
            put("numerEmergencia","1236543456");
            put("grupoSanguineo","A+");
        }};

        // Inscribir a categorías
        inscribirParticipante(participante1, "chico");
        inscribirParticipante(participante2, "avanzado");
        inscribirParticipante(participante3, "medio");
        inscribirParticipante(participante4, "avanzado");
        inscribirParticipante(participante5, "chico");
        inscribirParticipante(participante3, "medio");

        // Ver inscritos por categoría
        System.out.println("Inscritos a la categoría 'Chico':");
        mostrarParticipantesPorCategoria("chico");

        System.out.println("Inscritos a la categoría 'Medio':");
        mostrarParticipantesPorCategoria("medio");

        System.out.println("Inscritos a la categoría 'Avanzado':");
        mostrarParticipantesPorCategoria("avanzado");

        // Desinscribir de categorías
        desinscribirParticipante(4, "chico");
        System.out.println("Inscritos a la categoría 'Chico':");
        mostrarParticipantesPorCategoria("chico");

        desinscribirParticipante(1, "avanzado");
        System.out.println("Inscritos a la categoría 'Avanzado':");
        mostrarParticipantesPorCategoria("avanzado");
    }
}
