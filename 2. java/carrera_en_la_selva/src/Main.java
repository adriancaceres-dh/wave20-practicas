import java.util.*;

public class Main {
    static int counter = 0;
    static HashMap<String, HashMap<Integer, String[]>> categorias = new HashMap<>();
    static Set<String> dnisDeParticipantes = new HashSet<>();

    public static void main(String[] args) {
        inicilizarCategorias();
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("\nQué desea hacer? \n" +
                    "1) Inscribir participante\n" +
                    "2) Mostrar participantes en categoria\n" +
                    "3) Desinscribir participante \n" +
                    "4) Salir");
            switch (s.nextInt()){
                case 1:
                    agregarParticipante();
                    break;
                case 2:
                    String categoria = getCategoria();
                    mostrarPorCategoria(categoria);
                    break;
                case 3:
                    borrarParticipante();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Por favor seleccione una opción válida.");
            }
        }
    }

    static void mostrarPorCategoria(String categoria) {
        for (Map.Entry<Integer, String[]> participante : categorias.get(categoria).entrySet())
            System.out.println(participante.getKey() + ": "
                    + participante.getValue()[1] + ", " + participante.getValue()[0]);
    }

    static void borrarParticipante() {
        Scanner s = new Scanner(System.in);

        System.out.println("En que categoria se encuentra el participante que desea eliminar?");
        String categoria = getCategoria();
        System.out.println("Que participante desea eliminar?");
        mostrarPorCategoria(categoria);
        Integer idAEliminar = s.nextInt();
        var participantesDeCategoria = categorias.get(categoria);
        if (participantesDeCategoria.remove(idAEliminar) == null) {
            System.out.println("No se encontro el participante en la categoria seleccionada.");
        }
    }

    static String getCategoria() {
        System.out.println("Categoria: 1 (Chico), 2 (Medio), 3 (Avanzado)");
        Scanner s = new Scanner(System.in);

        boolean check = false;
        String categoria = "";
        while (!check) {
            switch (s.nextLine()) {
                case "Chico":
                case "1":
                    categoria = "Chico";
                    check = true;
                    break;
                case "Medio":
                case "2":
                    categoria = "Medio";
                    check = true;
                    break;
                case "Avanzado":
                case "3":
                    categoria = "Avanzado";
                    check = true;
                    break;
                default:
            }
        }
        return categoria;
    }

    static double calcularMonto(String circuito, String cadena_edad) {
        int edad = Integer.parseInt(cadena_edad);
        switch (circuito) {
            case "Chico":
                return edad < 18 ? 1300 : 1500;
            case "Medio":
                return edad < 18 ? 2000 : 2300;
            case "Avanzado":
                return 2800;
            default:
                throw new RuntimeException();
        }
    }

    static boolean realizarValidaciones(String[] participante, String categoria) {
        if (Integer.parseInt(participante[3]) < 18 && categoria.equals("Avanzado")) {
            System.out.println("Se debe se mayor de edad para inscribirse en esta categoría");
            return false;
        }
        if (!dnisDeParticipantes.add(participante[2])) {
            System.out.println("El participante ya se encuentra inscripto.");
            return false;
        }
        return true;
    }

    static void inicilizarCategorias(){
        categorias.put("Chico", new HashMap<>());
        categorias.put("Medio", new HashMap<>());
        categorias.put("Avanzado", new HashMap<>());
    }

    static void agregarParticipante() {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        String nombre = s.nextLine();
        System.out.println("Ingrese el apellido:");
        String apellido = s.nextLine();
        System.out.println("Ingrese el dni:");
        String dni = s.nextLine();
        System.out.println("Ingrese la edad:");
        String edad = s.nextLine();
        String categoria = getCategoria();

        String[] participante = {nombre, apellido, dni, edad};
        if (realizarValidaciones(participante, categoria)) {
            var participantesPorCategoria = categorias.get(categoria);
            participantesPorCategoria.put(counter++, participante);
            System.out.println("El monto a pagar es " + calcularMonto(categoria, edad));
        }
    }
}