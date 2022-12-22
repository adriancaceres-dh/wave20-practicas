package com.carrera_selva;

import java.util.*;

public class App {
    private static Scanner input = new Scanner(System.in);
    private static final String WELCOME = "Bienvenid@ a la gran Carrera de la Selva";
    private static final String BEGINNING = "Comenzamos con el proceso de inscripción";
    private static final String DNI = "Ingrese su número de dni";
    private static final String NAME= "Ingrese su nombre";
    private static final String SURNAME = "Ingrese su apellido";
    private static final String CELLPHONE = "Ingrese su telefono celular";
    private static final String EMERGENCY = "Ingrese su numero de emergencia";
    private static final String BLOOD_TYPE = "Ingrese su grupo sanguineo";
    private static final String CIRCUIT_CHOICE = "¿A qué circuito desea inscribirse? las opciones son: ";
    private static final String AGE = "Necesitamos conocer su edad para calcular el monto que le corresponde abonar";
    private static final String CIRCUIT_1 = "1: Circuito chico: 2km por selva y arroyos";
    private static final String CIRCUIT_2= "2: Circuito mediano: 5km por selva, arroyos y barro";
    private static final String CIRCUIT_3 = "3: Circuito avanzado: 10km por selva, arroyos, barro y escalada en piedra";
    private static final String PERMISSION_DENIED = "No se le permite la inscripción ya sea porque es menor de 18 años y desea estar " +
            "en el circuito avanzado"+ " o porque ya está inscripto en otra categoría.";
    private static final String AMOUNT = "Hemos concluido la inscripción de manera exitosa. "+ "El monto a abonar es de: ";
    private static final String SHOW_PARTICIPANTS = "Se procede a mostrar los participantes inscriptos en cada categoría";
    private static final String DELETE = "¿Desea eliminar a alguno de los participantes? Ingres si/no";
    private static final String NUMBER_OF_PARTICIPANT = "Ingrese el número de inscripción del participante que desea eliminar";
    private static final String PARTICIPANT_NON_EXIST = "No existe participante con el número de inscripción ingresado";
    private static final String PARTICIPANT_DELETED = "El participante se eliminó correctamente";
    private static final String PARTICIPANT = "El número de participante es: ";
    private static final String DATA = "Sus datos personales son: ";
    private static final String ADD_PARTICIPANT = "¿Desea añadir otro participante? Ingrese si/no";
    private static Long num = 0L;
    private static Set<Long> reusable_number = new HashSet<>();
    private static List<Long> participants = new ArrayList<>();
    private static Map<Long, List<String>> circuit_1 = new HashMap<>();
    private static Map<Long, List<String>> circuit_2 = new HashMap<>();
    private static Map<Long, List<String>> circuit_3 = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            initializeInscription();
            if (finalizeProgram().equals("no")) break;
        }

    }
    public static void initializeInscription() {
        System.out.println(WELCOME);
        System.out.println(BEGINNING);
        System.out.println("----------------------------------------");
        System.out.println(CIRCUIT_CHOICE);
        System.out.println(CIRCUIT_1);
        System.out.println(CIRCUIT_2);
        System.out.println(CIRCUIT_3);
        int circuit = input.nextInt();
        System.out.println(AGE);
        int age = input.nextInt();
        if (circuit == 3 && age < 18) {
            System.out.println(PERMISSION_DENIED);

        } else {
            inscription(circuit, age);
        }
    }

    //No se está realizando validación del correcto ingreso de datos por el tiempo que dicha tarea insume.
    public static void inscription(int circuit, int age) {
        System.out.println(DNI);
        Long dni = input.nextLong();
        System.out.println(NAME);
        String name = input.next();
        System.out.println(SURNAME);
        String surname = input.next();
        System.out.println(CELLPHONE);
        String cellphone = input.next();
        System.out.println(EMERGENCY);
        String emergency = input.next();
        System.out.println(BLOOD_TYPE);
        String blood_type = input.next();
        if (participants.contains(dni)) {
            System.out.println(PERMISSION_DENIED);
        } else {
            participants.add(dni);
            String[] data = {"DNI: "+ String.valueOf(dni), " Nombre: "+name, " Apellido: "+surname,
                    " Número de celular: "+cellphone, " Número de emergencia: "+emergency,
                    " Grupo sanguineo: "+blood_type};

            num = reusable_number.isEmpty() ? ++num : (Long) Arrays.asList(reusable_number.toArray()).get(0);

            if (circuit == 1) circuit_1.put(num, Arrays.asList(data));
            if (circuit == 2) circuit_2.put(num, Arrays.asList(data));
            if (circuit == 3) circuit_3.put(num, Arrays.asList(data));

            finalize(circuit, age);
        }
    }

    public static void finalize(int circuit, int age) {
        System.out.println(AMOUNT
        + getAmount(circuit, age));
        System.out.println(SHOW_PARTICIPANTS);
        System.out.println(CIRCUIT_1);
        showParticipants(circuit_1);
        System.out.println(CIRCUIT_2);
        showParticipants(circuit_2);
        System.out.println(CIRCUIT_3);
        showParticipants(circuit_3);
        System.out.println(DELETE);
        String delete = input.next();
        if (delete.equals("si")) deleteParticipant();

    }

    public static void deleteParticipant() {
        System.out.println(NUMBER_OF_PARTICIPANT);
        Long id = input.nextLong();
        List<String> participant_1 = circuit_1.get(id);
        List<String> participant_2 = circuit_2.get(id);
        List<String> participant_3 = circuit_3.get(id);
        if (participant_1 != null) {
            circuit_1.remove(id);
            participants.remove(participant_1.get(0));
        }
        if (participant_2 != null) {
            circuit_2.remove(id);
            participants.remove(participant_2.get(0));
        }
        if (participant_3 != null) {
            circuit_3.remove(id);
            participants.remove(participant_3.get(0));
        }
        if (participant_1 == null && participant_2 == null && participant_3 == null) {
            System.out.println(PARTICIPANT_NON_EXIST);
        } else {
            System.out.println(PARTICIPANT_DELETED);
            reusable_number.add(id);
        }


    }

    public static String finalizeProgram() {
        Scanner in = new Scanner(System.in);
        System.out.println(ADD_PARTICIPANT);
        String finalize = in.next();
        String result = finalize.equals("si") ? "si" : "no";
        return result;
    }

    private static void showParticipants(Map<Long, List<String>> circuito) {
        Iterator<Long> it = circuito.keySet().iterator();
        while(it.hasNext()){
            Long key = it.next();
            List<String> value = circuito.get(key);
            System.out.println(PARTICIPANT + key);
            System.out.println(DATA);
            for (String fact : value) {
                System.out.println(fact);
            }

        }

    }

    public static Integer getAmount(int circuit, int age) {
        boolean higher = age >= 18;
        int amount = 0;
        if (circuit == 1 &&  higher) amount = 1500;
        if (circuit == 1 && !higher) amount = 1300;
        if (circuit == 2 &&  higher) amount = 2300;
        if (circuit == 2 && !higher) amount = 2000;
        if (circuit == 3 && higher) amount = 1500;
        if (circuit == 3 && !higher) amount = 0;
        return amount;

    }

}

