import java.util.*;

public class Main {

    static List<Map<String, String>> chico = new ArrayList<>();
    static List<Map<String, String>> medio = new ArrayList<>();
    static List<Map<String, String>> avanzado = new ArrayList<>();
    public static void agregarParticipante(String circuito, int id, String dni, String nombre, String apellido, String edad) {
        Map<String, String> participante = new HashMap<>();
        participante.put("id", String.valueOf(id));
        participante.put("dni", dni);
        participante.put("nombre", nombre);
        participante.put("apellido", apellido);
        participante.put("edad", edad);
        if (circuito.equals("chico")){
            chico.add(participante);
        }
        else {
            if (circuito.equals("medio")) {
                medio.add(participante);
            }
            else {
                if(circuito.equals("avanzado")) {
                    avanzado.add(participante);
                }
            }
        }
    }

    public static void eliminarParticipante (int id) {
        chico.removeIf(participante -> Objects.equals(participante.get("id"), String.valueOf(id)));
        medio.removeIf(participante -> Objects.equals(participante.get("id"), String.valueOf(id)));
        avanzado.removeIf(participante -> Objects.equals(participante.get("id"), String.valueOf(id)));
    }
    public static void mostrarListas() {
        System.out.println("Chico: ");
        System.out.println(chico);
        System.out.println("Medio: ");
        System.out.println(medio);
        System.out.println("Avanzado: ");
        System.out.println(avanzado);
    }
    public static void main(String[] args) {

        Scanner participante_input = new Scanner(System.in);
        boolean flag = false;
        int id = 0;
        boolean eliminar = false;
        String dni;
        String nombre;
        String apellido;
        String edad;
        System.out.println(chico.size());



        while(!flag) {

            System.out.println("Ingrese los datos del participante.");
            System.out.println("Dni: ");
            dni = participante_input.nextLine();
            System.out.println("Nombre: ");
            nombre = participante_input.nextLine();
            System.out.println("Apellido: ");
            apellido = participante_input.nextLine();
            System.out.println("Edad: ");
            edad = participante_input.nextLine();
            id += 1;

            System.out.println("Seleccione a que circuito desea inscribirse.");
            System.out.println("1.- Chico");
            System.out.println("2.- Mediano");
            System.out.println("3.- Avanzado");
            System.out.println("4.- Salir");
            int selector = participante_input.nextInt();
            participante_input.nextLine();

            if(selector == 1) {
                agregarParticipante("chico", id, dni, nombre, apellido, edad);
            }
            else {
                if(selector == 2) {
                    agregarParticipante("medio", id, dni, nombre, apellido, edad);
                }
                else {
                    if(selector == 3) {
                        agregarParticipante("avanzado", id, dni, nombre, apellido, edad);
                    }
                    else {
                        flag = true;
                    }
                }
            }


            if(!flag) {
                System.out.println("Desea agregar otro participante?");
                System.out.println("1.- Si");
                System.out.println("2.- No");
                selector = participante_input.nextInt();
                participante_input.nextLine();
                if(selector != 1){
                    flag = true;
                }
            }

        }
        System.out.println("Listas de participantes agregados:");
        mostrarListas();

        flag = false;

        while (!flag) {
            System.out.println("Desea eliminar un participante?");
            System.out.println("1.- Si");
            System.out.println("2.- No");
            int selector = participante_input.nextInt();
            participante_input.nextLine();
            if (selector == 1) {
                System.out.println("Ingrese el id del participante que desea eliminar: ");
                id = participante_input.nextInt();
                participante_input.nextLine();
                eliminarParticipante(id);
                System.out.println("Listas de participantes restantes:");
                mostrarListas();
            }
            else {
                System.out.println("Gracias!");
                flag = true;
            }

        }
        System.out.println("Listas de participantes definitivas:");
        mostrarListas();
    }
}