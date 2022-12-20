import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String opcion;
        int numeroConsecutivoCChico = 1, numeroConsecutivoCMedio = 1, numeroConsecutivoCAvanzado = 1;
        double montoAbonar;
        int salir = 1;

        //Lista de Participantes
        List<String> participantes;

        //Declaracion de mapas que van a contener una lista de participantes
        Map<Integer, List<String>> circuitoChico = new TreeMap<>();
        Map<Integer, List<String>> circuitoMedio = new TreeMap<>();
        Map<Integer, List<String>> circuitoAvanzado = new TreeMap<>();

        while (salir == 1) {
            System.out.println("************************** Bienvenido al Menu - Carrera de la Selva ************************+**");
            System.out.println("-> Por favor selecciona una de las siguientes opciones (1-11)");
            System.out.println("1. Inscribir participante a la categoria Circuito Chico");
            System.out.println("2. Inscribir participante a la categoria Circuito Medio");
            System.out.println("3. Inscribir participante a la categoria Circuito Avanzado");
            System.out.println("4. Mostrar participantes categoria Circuito Chico");
            System.out.println("5. Mostrar participantes categoria Circuito Medio");
            System.out.println("6. Mostrar participantes categoria Circuito Avanzado");
            System.out.println("7. Eliminar participante categoria Circuito Chico");
            System.out.println("8. Eliminar participante categoria Circuito Medio");
            System.out.println("9. Eliminar participante categoria Circuito Avanzado");
            System.out.println("10. Informacion de la carrera");
            System.out.println("11. Salir");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    participantes = registrarParticipante();
                    String edadCircuitoChico = participantes.get(3);
                    //Validar el monto a abonar segun la edad
                    if (Integer.parseInt(edadCircuitoChico) < 18) {
                        montoAbonar = 1300;
                        agregarMontoAbonar(montoAbonar, participantes);
                    } else {
                        montoAbonar = 1500;
                        agregarMontoAbonar(montoAbonar, participantes);
                    }
                    //Mapa
                    circuitoChico.put(numeroConsecutivoCChico, participantes);
                    numeroConsecutivoCChico++;
                    break;
                case "2":
                    participantes = registrarParticipante();
                    String edadCircuitoMedio = participantes.get(3);
                    //Validar el monto a abonar segun la edad
                    if (Integer.parseInt(edadCircuitoMedio) < 18) {
                        montoAbonar = 2000;
                        agregarMontoAbonar(montoAbonar, participantes);
                    } else {
                        montoAbonar = 2300;
                        agregarMontoAbonar(montoAbonar, participantes);
                    }
                    //Mapa
                    circuitoMedio.put(numeroConsecutivoCMedio, participantes);
                    numeroConsecutivoCMedio++;
                    break;
                case "3":
                    participantes = registrarParticipante();
                    String edadCircuitoAvanzado = participantes.get(3);
                    //Validar el monto a abonar segun la edad
                    if (Integer.parseInt(edadCircuitoAvanzado) >= 18) {
                        montoAbonar = 2800;
                        agregarMontoAbonar(montoAbonar, participantes);
                        //Mapa
                        circuitoAvanzado.put(numeroConsecutivoCAvanzado, participantes);
                        numeroConsecutivoCAvanzado++;
                    } else {
                        System.out.println("No se permite la inscripcion a participantes menores de 18 anios");
                    }
                    break;
                case "4":
                    mostrarParticipantes(circuitoChico);
                    break;
                case "5":
                    mostrarParticipantes(circuitoMedio);
                    break;
                case "6":
                    mostrarParticipantes(circuitoAvanzado);
                    break;
                case "7":
                    eliminarParticipante(circuitoChico);
                    break;
                case "8":
                    eliminarParticipante(circuitoMedio);
                    break;
                case "9":
                    eliminarParticipante(circuitoAvanzado);
                    break;
                case "10":
                    System.out.println("************ Carrera de la Selva ************");
                    System.out.println("-> Circuito chico: 2 km por selva y arroyos.");
                    System.out.println("-> Circuito medio: 5 km por selva, arroyos y barro.");
                    System.out.println("-> Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra.");
                    break;
                case "11":
                    System.out.println("Adios!!");
                    salir = 0;
                    break;
                default:
                    System.out.println("Numero invalido!");
                    break;
            }
        }
    }

    public static List<String> registrarParticipante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese el dni:");
        String dni = scanner.nextLine();
        System.out.println("Por favor ingrese el nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Por favor ingrese el apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Por favor ingrese la edad:");
        String edad = scanner.nextLine();
        //Integer.parseInt(scanner.nextLine());
        System.out.println("Por favor ingrese el celular:");
        String celular = scanner.nextLine();
        System.out.println("Por favor ingrese el numero emergencia:");
        String numeroEmergencia = scanner.nextLine();
        System.out.println("Por favor ingrese el grupo sanguineo:");
        String grupoSanguineo = scanner.nextLine();

        return new ArrayList<>(Arrays.asList(dni, nombre, apellido, edad, celular, numeroEmergencia, grupoSanguineo));
    }

    public static void agregarMontoAbonar(Double montoAbonar, List<String> participantes) {
        System.out.println("Monto a Abonar $ " + montoAbonar);
        participantes.add(Double.toString(montoAbonar));
    }

    public static void mostrarParticipantes(Map<Integer, List<String>> circuito) {
        //Recorrer un mapa
        if (!circuito.isEmpty()) {
            for (Map.Entry<Integer, List<String>> totalParticipantes : circuito.entrySet()) {
                System.out.println("N° Consecutivo: " + totalParticipantes.getKey() + " Participante: "
                        + totalParticipantes.getValue());
            }
        } else {
            System.out.println("No hay participantes inscriptos en la categoria!!");
        }
    }

    public static void eliminarParticipante(Map<Integer, List<String>> circuito) {
        if (!circuito.isEmpty()) {
            System.out.println("Por favor ingresa el numero consecutivo del partipante: ");
            Scanner scanner = new Scanner(System.in);
            int numeroConsecutivo = Integer.parseInt(scanner.nextLine());
            if (circuito.containsKey(numeroConsecutivo)) {
                circuito.remove(numeroConsecutivo);
                System.out.println("Participante eliminado!!");
            } else {
                System.out.println("El participante no esta registrado!");
            }
        } else {
            System.out.println("Por favor registra un participante a dicha categoria");
        }
    }
}