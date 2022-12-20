package com.bootcamp;

import java.util.*;

public class Main {

    static List<Set<Integer>> inscriptosPorCategoria = new ArrayList<Set<Integer>>();
    static Map<Integer, List<String>> inscriptosTotales = new HashMap<Integer, List<String>>();
    static String[] datosInscripcion = {"Documento", "Nombre", "Apellido", "Edad",
            "Celular", "Número de Emergencia", "Grupo Snaguíneo", "Monto a Abonar"};
    static String[] nombreCategoria = {"Chico", "Medio", "Avanzado"};
    static Integer cantidadInscriptos = 0;

    public static void inscribirParticipante(List<String> datos, Integer categoria) {
        // Inicializar inscriptosPorCategoria
        if (inscriptosPorCategoria.isEmpty()) {
            for (int i = 0; i < 3; i++) {
                inscriptosPorCategoria.add(new HashSet<Integer>());
            }
        }

        // Calcular el coste de la inscripcion.
        boolean esMayor = Integer.parseInt(datos.get(3)) >= 18;
        Integer abono = 0;

        switch (categoria) {
            case 1:
                abono = esMayor ? 1500 : 1300;
                break;
            case 2:
                abono = esMayor ? 2300 : 2000;
                break;
            case 3:
                abono = esMayor ? 2800 : 0;
                break;
        }

        if (abono != 0) {
            cantidadInscriptos++;
            inscriptosPorCategoria.get(categoria - 1).add(cantidadInscriptos);
            datos.add(abono.toString());
            inscriptosTotales.put(cantidadInscriptos, datos);
        }
    }

    public static void desinscribirParticipante(Integer numeroInscripto) {
        inscriptosTotales.remove(numeroInscripto);
        for (Set<Integer> categoria : inscriptosPorCategoria) {
            categoria.remove(numeroInscripto);
        }
    }

    public static void mostrarInscriptosPorCategoria(Integer categoria) {
        System.out.println("Inscriptos en Categoría " + nombreCategoria[categoria-1]);
        for (Integer i : inscriptosPorCategoria.get(categoria - 1)) {
            System.out.println("------------------");
            System.out.println("Número inscripción: " + i);
            imprimirInscipto(i);
        }
    }

    public static void imprimirInscipto(Integer inscripto) {
        List<String> datos = inscriptosTotales.get(inscripto);
        for (int i = 0; i < datos.size(); i++) {
            System.out.println("Inscripto N°: " + inscripto);
            System.out.println(datosInscripcion[i] + ": " + datos.get(i));
        }
    }

    public static void inscribir() {
        List<String> datos = new ArrayList<String>();
        Scanner leer = new Scanner(System.in);
        System.out.println("A continuación vamos a pedirte tus datos");

        for (int i = 0; i < datosInscripcion.length - 1; i++) {
            System.out.println("¿Cuál es tu " + datosInscripcion[i] + "?");
            datos.add(leer.nextLine());
            System.out.println();
        }

        System.out.println("¿A qué circuito desea inscribirse?");

        for (int i = 0; i < nombreCategoria.length; i++) {
            System.out.println(i + 1 + " - Circuito " + nombreCategoria[i]);
        }

        boolean catInvalida = true;
        boolean inscripcionInvalida = true;
        while (catInvalida || inscripcionInvalida) {
            System.out.println("Introduzca un número");
            int cat = leer.nextInt();
            boolean esMayor = Integer.parseInt(datos.get(3)) >= 18;
            catInvalida = cat > 3 || cat < 1;
            inscripcionInvalida = cat == 3 && !esMayor;
            if (catInvalida) {
                System.out.println("Por favor introduzca un número del 1 al 3.");
            } else if (inscripcionInvalida) {
                System.out.println("La categoría " + nombreCategoria[cat - 1] + "es solamente para mayores de edad.");
            } else {
                inscribirParticipante(datos, cat);
                System.out.println("Fuiste inscripto con éxito, a continuación te compartimos tus datos:");
                imprimirInscipto(cantidadInscriptos);
            }
        }
        leer.next();
    }

    public static void desinscribir(){
        System.out.println("Solicitamos tu número de inscripción para darte de baja:");

        Scanner leer = new Scanner(System.in);
        int numeroInscripcion = leer.nextInt();

        desinscribirParticipante(numeroInscripcion);

        System.out.println("Fuiste dado de baja correctamente. Muchas gracias.");
        leer.next();
    }

    public static void mostrarInscriptos(){
        System.out.println("Que inscriptos desea ver?");
        System.out.println("1-Inscriptos Circuito Chico");
        System.out.println("2-Inscriptos Circuito Medio");
        System.out.println("3-Inscriptos Circuito Avanzado");

        Scanner leer = new Scanner(System.in);
        System.out.println("Instroduzca un número");
        int categoria = leer.nextInt();

        mostrarInscriptosPorCategoria(categoria);
        leer.next();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Elija una opcion:");
            System.out.println("1-Inscribir a un nuevo participante");
            System.out.println("2-Mostrar inscriptos");
            System.out.println("3-Desinscribir a uno ya inscripto");
            System.out.println("4-Salir");
            Scanner in = new Scanner(System.in);
            System.out.println("Introduzca un número");

            switch (in.nextInt()) {
                case 1:
                    inscribir();
                    break;
                case 2:
                    mostrarInscriptos();
                case 3:
                    desinscribir();
                    break;
                case 4:
                    System.out.println("Que tengas un buen día.");
                    return;
            }
        }
    }
}
