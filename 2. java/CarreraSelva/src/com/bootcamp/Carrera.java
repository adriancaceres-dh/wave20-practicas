package com.bootcamp;

import java.util.*;

public class Carrera{

    //Map<String, Map<Integer, List<String>>>
    int opcion;

    int id = 1;

    //Precios
    int precioChico = 1300;
    int precioMedio = 2000;
    int precioGrande = 2800;
    //Inicializo variables de jugadores
    String nombre, dni, edad, tel, grupoSanguineo, Tipocircuito, descripcion = null;

    //Guardo jugadores en una lista
    List<String> jugadores = new ArrayList<String>();

    // Guardo circuitos en un hashmap
    Map<String, String> circuitos = new HashMap<>();
    /*Creo un mapa donde la key será el id correpondiente a cada usuario y el value serán los datos del usuario (q incluye los
     datos de la carrera y precios, ya agregados al momento de usar NavigableMap
     TreeMap porque necesito que el id esté en orden
     */
    NavigableMap<Integer, String> listaJugadores = new TreeMap<Integer, String>();
    //NavigableMap<String, NavigableMap<Integer, List<String>>> carrera = new TreeMap<>();
    Scanner teclado = new Scanner(System.in);

    public void menu() {

        do{
            System.out.println("-----------------------------\n" +
                    "BIENVENIDO A LA CARRERA DE LA SELVA\n" +
                    " Por favor, seleccione una opción: \n" +
                    "1-> Registrar un jugador\n" +
                    "2-> Ver personas inscriptas\n" +
                    "3-> Dar de baja al último participante\n" +
                    "0-> Salir\n");

            opcion = teclado.nextInt();
            switch (opcion){
                case 1: {
                    agregarCircuitos();
                   registrarJugador();
                    break;
                }
                case 2: {
                    mostrarDatosJugadores();
                    break;
                }
                case 3: {
                    eliminarJugador();
                    break;
                }
                case 4: {
                    System.out.println("Presione 4 para determinar el monto a abonar");
                    break;
                }
            }
        } while(opcion != 0);


    }
    public void registrarJugador() {
        jugadores.clear();
        System.out.println("Ingrese los datos del jugador: ");
        System.out.println("Nombre: ");
        nombre = teclado.next();
        jugadores.add(nombre);

        System.out.println("DNI: ");
        dni = teclado.next();
        jugadores.add(dni);

        System.out.println("Edad: ");
        edad = teclado.next();
        jugadores.add(edad);

        System.out.println("Celular: ");
        tel = teclado.next();
        jugadores.add(tel);

        System.out.println("Grupo Sanguineo: ");
        grupoSanguineo = teclado.next();
        jugadores.add(grupoSanguineo);

        System.out.println("Categoria en la que desea inscribirse?\n Recuerde que: \n" +
                "chico-> 2 km por selva y arroyos.\n" +
                "medio-> 5 km por selva, arroyos y barro.\n" +
                "avanzado-> 10 km por selva, arroyos, barro y escalada en piedra.\n");
        Tipocircuito = teclado.next();
        jugadores.add(Tipocircuito);

        for (Map.Entry<String, String> circuito : circuitos.entrySet()) {
            descripcion = circuito.getValue();
            if(jugadores.get(5).equals("chico") && circuito.getKey()=="chico") {
                jugadores.add(descripcion);
            //convertimos el string en int
            if(Integer.parseInt(jugadores.get(2))<18){
               jugadores.add(String.valueOf(precioChico));
            } else {
                precioChico = precioChico + 200;
                jugadores.add(String.valueOf(precioChico));
            }
            listaJugadores.put(id, jugadores.toString());
            id++;

            } else if (jugadores.get(5).equals("medio") && circuito.getKey() == "medio") {
                jugadores.add(descripcion);
                if(Integer.parseInt(jugadores.get(2)) >=18) {
                    precioMedio = precioMedio + 300;
                    jugadores.add(String.valueOf(precioMedio));
                } else {
                    jugadores.add(String.valueOf(precioMedio));
                }
                listaJugadores.put(id, jugadores.toString());
                id++;

            } else if (jugadores.get(5).equals("avanzado") && circuito.getKey()=="avanzado") {
                jugadores.add(descripcion);
                if(Integer.parseInt(jugadores.get(2))>=18) {
                   jugadores.add(String.valueOf(precioGrande));
                } else {
                    System.out.println("No se permiten inscripciones de menores de 18 años");
                }
                listaJugadores.put(id, jugadores.toString());
                id++;
            }
        }

        System.out.println("Usuario registrado con éxito");
        System.out.println(jugadores);
    }

    public void agregarCircuitos() {

        circuitos.put("chico", "2k por selva y arroyos");
        circuitos.put("medio", "5k por selva, arroyos y barro");
        circuitos.put("avanzado", "10k por selva, arroyos, barro, y escalada en piedra");
    }

    public void mostrarDatosJugadores() {
        //caso 1: lista vacía
        if(listaJugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados hasta el momento");
        }
        //caso 2: la lista no está vacía, iterar en map para ver cada uno
        else{
            for (Map.Entry<Integer, String> jugador : listaJugadores.entrySet()) {
                System.out.println("Id: " + jugador.getKey() + " ,Datos del jugador" + jugador.getValue());
            }
        }
    }

    public void eliminarJugador() {
        //chequear si lista está vacía
        if(listaJugadores.isEmpty()) {
            System.out.println("No hay jugadores para eliminar");
        }
        //lista no está vacía
        else {
            //Entry sirve para ver cada elemento dentro del NavigableMap
            NavigableMap.Entry<Integer, String> ultimoJugador = listaJugadores.lastEntry();
            listaJugadores.remove(ultimoJugador.getKey());

                System.out.println("Jugador " + ultimoJugador.getKey() + " eliminado exitosamente");


        }
    }
    public static void main(String[] args) {

        new Carrera().menu();
    }
}