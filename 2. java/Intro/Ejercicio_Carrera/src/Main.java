import java.util.*;

public class Main {
    static Map<String, List<Map<String,Object>> > categorias = new HashMap<>();

    public static void main(String[] args) {

        // Creación de categorias con respectivas  inscripciones

        categorias.put("Circuito Chico", new ArrayList<Map<String,Object>>());
        categorias.put("Circuito Medio",new ArrayList<Map<String,Object>>());
        categorias.put("Circuito Avanzado",new ArrayList<Map<String,Object>>());

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

        inscribirCategoria("Circuito Avanzado",participante1);
        inscribirCategoria("Circuito Avanzado",participante2);

        mostrarInscritos("Circuito Avanzado");

        desinscribirCategoria("Circuito Avanzado",12343678);

        double monto = calcularMontoInscripcion("Circuito Medio",participante2);
        System.out.println("monto de inscripcion = "+monto);
        inscribirCategoria("Circuito Medio",participante2);

        mostrarInscritos("Circuito Chico");
        mostrarInscritos("Circuito Medio");
        mostrarInscritos("Circuito Avanzado");
    }

    public static boolean inscribirCategoria (String categoria,Map<String, Object> participante){

        if ((Integer)participante.get("edad")<18 && categoria.equals("Circuito Avanzado")){
            System.out.println("Inscrito no tiene edad suficiente para ingresar a categoria avanzada");
            return false;
        }

        List<Map<String,Object>> inscritos = categorias.get(categoria);
        Map<String, Object> inscripcion = new HashMap<>();
        inscripcion.put ("num_inscripcion", (Integer) participante.get("dni"));
        inscripcion.put("participante",participante); //Pendiente asignar autoincremento
        inscritos.add(inscripcion);

        return true;
    }

    public static void mostrarInscritos (String categoria){
        System.out.println(categorias.get(categoria));
    }

    public static void desinscribirCategoria (String categoria, int numero_inscripcion){
        Map<String, Object> desinscribir = null;

        for (Map<String,Object> inscripcion : categorias.get(categoria)) {
            if ((Integer)inscripcion.get("num_inscripcion")==numero_inscripcion){
                desinscribir = inscripcion;
                break;
            }
        }
        if (!desinscribir.isEmpty()){
            categorias.get(categoria).remove(desinscribir);
        }

        System.out.println(categorias.get(categoria));
    }

    public static double calcularMontoInscripcion (String categoria, Map<String, Object> participante){
        double monto = -1;
        int edad_participante = (Integer)participante.get("edad");

        if (categoria.equals("Circuito Chico")) {
            if (edad_participante<18) return 1300;
            else return 1500;
        }
        if (categoria.equals("Circuito Medio")) {
            if (edad_participante<18) return 2000;
            else return 2300;
        }
        if (categoria.equals("Circuito Avanzado") && edad_participante >= 18) {
            return 2800;
        }

        return monto;
    }
}