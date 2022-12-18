/*import java.util.*;

public class Main {
    public static void main(String[] args) {


        Scanner lectura = new Scanner (System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = lectura.next();

        Map<Integer, List<String>> circuito = new TreeMap<>();

        List datosParticipante_1 = new ArrayList<>();
        datosParticipante_1.add("nombre");
        datosParticipante_1.add("apellido");
        datosParticipante_1.add("hola");
        datosParticipante_1.add("14");

        List datosParticipante_2 = new ArrayList<>();
        datosParticipante_2.add("nombre");
        datosParticipante_2.add("apellido");
        datosParticipante_2.add("hola");
        datosParticipante_2.add("100");

        List datosParticipante_3 = new ArrayList<>();
        datosParticipante_3.add("nombre");
        datosParticipante_3.add("apellido");
        datosParticipante_3.add("hola");
        datosParticipante_3.add("12");

        circuito.put(1,datosParticipante_1);
        circuito.put(2,datosParticipante_2);
        circuito.put(3,datosParticipante_3);

        for( Map.Entry<Integer, List<String>> participante : circuito.entrySet() ) {
            System.out.println(participante.getKey() + " " +
                    if()
                    Integer.parseInt(participante.getValue().get(3)));


        }

        int vector[];

    }
}
 */

import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Objeto para recibir datos por teclado
        Scanner teclado = new Scanner(System.in);

        //Variables Precio segun circuito
        int precioChico = 1300;
        int precioMedio = 2000;
        int precioGrande = 2800;

        //Definiendo mapa de circuitos
        Map<String, String> circuitos = new HashMap<>();
        circuitos.put("chico", "2k por selva y arroyos");
        circuitos.put("medio", "5k por selva, arroyos y barro");
        circuitos.put("grande", "10k por selva, arroyos, barro, y escalada en piedra");

        //Creando lista para guardar datos de las personas
        List<String> personas = new ArrayList<String>();

        //Variables de persona
        String rut, nombre, apellido, edad, numCelular, numEmergencia, tipoSangre, tipoCircuito = "";
        //identificador para la lista de inscritos
        int id = 1;

        //Definiendo mapa de tipo NavigableMap que me permitira acceder al ultimo elemento del map,
        // que guardara los datos de la lista anterior con su respectivo identificador numerico
        NavigableMap<Integer, String> listadoInscritos = new TreeMap<Integer, String>();

        //Menu
        int optMenu = 0;

        do {
            //Opciones del menu
            System.out.println("1- Agregar persona");
            System.out.println("2- Eliminar persona");
            System.out.println("3- Listar participantes");
            System.out.println("4- Salir");

            System.out.println("Ingrese su opcion: ");
            optMenu = teclado.nextInt();

            switch (optMenu){
                case 1:
                    //Añadiendo datos de la persona al ArrayList personas
                    //Se declara un clear() para que cada vez que ingrese un  nuevo participante no duplique un participante anteriormente creado
                    personas.clear();
                    System.out.println("Ingrese rut: ");
                    rut = teclado.next();
                    personas.add(rut);
                    System.out.println("Ingrese nombre: ");
                    nombre = teclado.next();
                    personas.add(nombre);
                    System.out.println("Ingrese apellido: ");
                    apellido = teclado.next();
                    personas.add(apellido);
                    System.out.println("Ingrese edad: ");
                    edad = teclado.next();
                    personas.add(edad);
                    System.out.println("Ingrese numero de celular: ");
                    numCelular = teclado.next();
                    personas.add(numCelular);
                    System.out.printf("Ingrese numero de emergencia: ");
                    numEmergencia = teclado.next();
                    personas.add(numEmergencia);
                    System.out.printf("Ingrese tipo de sangre: ");
                    tipoSangre = teclado.next();
                    personas.add(tipoSangre);
                    System.out.printf("Ingrese tipo de carrera (chico, medio, grande): ");
                    tipoCircuito = teclado.next();
                    personas.add(tipoCircuito);

                    //Asignando el detalle/descripcion y precio de la carrera segun la seleccion del participante
                    for (Map.Entry<String, String> circuito: circuitos.entrySet()) {
                        String descripcion = circuito.getValue();
                        if (personas.get(7).equals("chico") && circuito.getKey() == "chico"){
                            personas.add(descripcion);
                            if(Integer.parseInt(personas.get(3)) >= 18) {
                                precioChico = precioChico + 200;
                            }
                            personas.add(String.valueOf(precioChico));
                            listadoInscritos.put(id, personas.toString());
                            id++;
                        }
                        if (personas.get(7).equals("medio") && circuito.getKey() == "medio"){
                            personas.add(descripcion);
                            if(Integer.parseInt(personas.get(3)) >= 18) {
                                precioMedio = precioMedio + 300;
                            }
                            personas.add(String.valueOf(precioMedio));
                            listadoInscritos.put(id, personas.toString());
                            id++;
                        }
                        if (personas.get(7).equals("grande") & circuito.getKey() == "grande"){
                            if(Integer.parseInt(personas.get(3)) >= 18) {
                                personas.add(descripcion);
                                personas.add(String.valueOf(precioGrande));
                                listadoInscritos.put(id, personas.toString());
                                id++;
                            }
                            else {
                                System.out.println("La persona tiene menos de 18 años");
                            }
                        }
                    }
                    break;

                case 2:
                    //Eliminando la ultima entrada del map listadoInscritos
                    if(listadoInscritos.isEmpty()){
                        System.out.println("La lista esta vacia, no se pueden borrar elementos.");
                    }
                    else{
                        NavigableMap.Entry<Integer, String> ultimo = listadoInscritos.lastEntry();
                        listadoInscritos.remove(ultimo.getKey());
                    }
                    break;

                case 3:
                    //Mostrando los datos de listadoInscritos
                    if(listadoInscritos.isEmpty()){
                        System.out.println("La lista esta vacia, no se puede visualizar elementos.");
                    }
                    else {
                        for (Map.Entry<Integer, String> inscrito: listadoInscritos.entrySet()) {
                            System.out.println("ID: " + inscrito.getKey() + "Datos: " + inscrito.getValue());
                        }
                    }
            }

        }while (optMenu != 4); //Condicion de salida del programa
    }
}