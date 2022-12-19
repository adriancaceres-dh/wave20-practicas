import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int circuito = 0;
        Scanner sc = new Scanner(System.in);
        int numParticipante = 0;
        Map<Integer, List<String>> circuitoChico = new TreeMap<>();
        Map<Integer, List<String>> circuitoMediado = new TreeMap<>();
        Map<Integer, List<String>> circuitoAvanzado = new TreeMap<>();
        while (true) {
            System.out.println("Menu");
            System.out.println("1-Incripcionn\n2-Ver listas\n3-Dar de baja\n4-Salir");
            int num = sc.nextInt();
            if (num != 4){
                System.out.println("Tipo de circuito:\n1-Chico\n2-Mediano\n3-Avanzado");
                circuito = sc.nextInt();
                Map c = choose(sc, circuitoChico, circuitoMediado, circuitoAvanzado, circuito);
                switch (num) {
                    case 1:
                        inscripcion(sc, numParticipante, c, circuito);
                        numParticipante++;
                        break;
                    case 2:
                        circuitoAll(c);
                        break;
                    case 3:
                        System.out.println("ingrese numero de participante");
                        int id = sc.nextInt();
                        delete(id, c);
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
            }else{
                break;
            }

        }
    }
    public static Map<Integer, List<String>> choose(Scanner sc, Map circuitoChico, Map circuitoMediado, Map circuitoAvanzado, int circuito) {
        Map c = null;
        switch (circuito) {
            case 1:
                c = circuitoChico;
                break;
            case 2:
                c = circuitoMediado;
                break;
            case 3:
                c = circuitoAvanzado;
                break;
        }
        return c;
    }
    public static int inscripcion(Scanner sc, int numParticipante, Map<Integer, List<String>> circuito, int c) {
        circuito.put(numParticipante, cargarUsuario(sc));
        int edad = Integer.parseInt(circuito.get(numParticipante).get(1));
        System.out.println("DATOS DEL INSCRIPTO");
        System.out.println("ID: "+ numParticipante+" "+ circuito.get(numParticipante));
        if (c == 1) {
            if (edad > 18) {
                System.out.println("Debe pagar $1500");
            } else {
                System.out.println("Debe pagar $1300");
            }
        } else if (c == 2) {
            if (edad > 18) {
                System.out.println("Debe pagar $2300");
            } else {
                System.out.println("Debe pagar $2000");
            }
        } else if (c == 3 && edad > 18) {
            System.out.println("Debe pagar $2800");
        } else {
            System.out.println("No se permite inscripción");
            delete(numParticipante, circuito);
        }

        return numParticipante ++;
    }
    public static List<String> cargarUsuario(Scanner sc) {
        List<String> usuario = new ArrayList<>();
        System.out.println("Ingresar nombre");
        String nombre = sc.nextLine();
        nombre = sc.nextLine();
        System.out.println("Ingresar edad");
        String edad = sc.nextLine();
        Collections.addAll(usuario, nombre, edad);
        return usuario;
    }
    public static void circuitoAll(Map<Integer, List<String>> circuito) {
        for (Map.Entry<Integer, List<String>> c : circuito.entrySet())
            System.out.println("Participante: " + c.getKey() + " " + c.getValue());
    }
    public static void delete(Integer id, Map<Integer, List<String>> circuito) {
        boolean check = false;
        for (Map.Entry<Integer, List<String>> c : circuito.entrySet()) {
            if (c.getKey() == id) {
                circuito.remove(id);
                System.out.println("SE ELIMINO CORRECTAMENTE");
                check = true;
            }
            if(!check){
                System.out.println("NO SE ENCONTRO EL USUARIO");
            }
        }

    }
}




