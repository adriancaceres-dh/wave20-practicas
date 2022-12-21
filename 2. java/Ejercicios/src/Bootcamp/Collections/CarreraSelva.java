package Bootcamp.Collections;
import java.util.*;

public class CarreraSelva {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String dni, nombre, apellido, edad, celular, numero_de_emergencia, grupo_sanguineo, tipo_circuito;

        int precio_circuito_chico = 1300;
        int precio_circuito_medio = 2000;
        int precio_circuito_grande = 2800;

        int numero_participante = 1;

        int opcion = 0;

        List <String> personas = new ArrayList<>();

        NavigableMap<Integer, String> listadoParticipantes = new TreeMap<Integer, String>();

        Map <String , String> circuitos = new HashMap<>();
        circuitos.put("Chico" , "2 km por selva y arroyos");
        circuitos.put("Medio" , "5 km por selva, arroyos y barro");
        circuitos.put("Grande" , "10 km por selva, arroyos, barro y escalada en piedra.");

        while(opcion !=4){
            System.out.println("1- Agregar persona");
            System.out.println("2- Listar participantes");
            System.out.println("3- Eliminar participante");
            System.out.println("4- Salir");

            System.out.println("Ingrese su opcion: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    personas.clear();
                    System.out.println("Ingrese el dni del participante: ");
                    dni = scan.next();
                    personas.add(dni);
                    System.out.println("Ingrese el nombre del participante: ");
                    nombre = scan.next();
                    personas.add(nombre);
                    System.out.println("Ingrese el apellido del participante: ");
                    apellido = scan.next();
                    personas.add(apellido);
                    System.out.println("Ingrese la edad del participante: ");
                    edad = scan.next();
                    personas.add(edad);
                    System.out.println("Ingrese el numero de celular del participante: ");
                    celular = scan.next();
                    personas.add(celular);
                    System.out.println("Ingrese el numero de emergencia del participante: ");
                    numero_de_emergencia = scan.next();
                    personas.add(numero_de_emergencia);
                    System.out.println("Ingrese el tipo de sangre del participante: ");
                    grupo_sanguineo = scan.next();
                    personas.add(grupo_sanguineo);
                    System.out.println("Ingrese el tipo de circuito = (Chico) , (Medio) , (Grande): ");
                    tipo_circuito = scan.next();
                    personas.add(tipo_circuito);

                    for (Map.Entry<String, String> circuito: circuitos.entrySet()) {
                        String descripcion = circuito.getValue();
                        if (personas.get(7).equals("Chico") && circuito.getKey() == "Chico"){
                            personas.add(descripcion);
                            if(Integer.parseInt(personas.get(3)) >= 18) {
                                precio_circuito_chico = precio_circuito_chico + 200;
                            }
                            personas.add(String.valueOf(precio_circuito_chico));
                            listadoParticipantes.put(numero_participante, personas.toString());
                            numero_participante++;
                        }
                        if (personas.get(7).equals("Medio") && circuito.getKey() == "Medio"){
                            personas.add(descripcion);
                            if(Integer.parseInt(personas.get(3)) >= 18) {
                                precio_circuito_medio = precio_circuito_medio + 300;
                            }
                            personas.add(String.valueOf(precio_circuito_medio));
                            listadoParticipantes.put(numero_participante, personas.toString());
                            numero_participante++;
                        }
                        if (personas.get(7).equals("Grande") & circuito.getKey() == "Grande"){
                            if(Integer.parseInt(personas.get(3)) >= 18) {
                                personas.add(descripcion);
                                personas.add(String.valueOf(precio_circuito_grande));
                                listadoParticipantes.put(numero_participante, personas.toString());
                                numero_participante++;
                            }
                            else {
                                System.out.println("La persona es menor de edad");
                            }
                        }
                    }
                    break;
                case 2:
                    if (listadoParticipantes.isEmpty()) {
                        System.out.println("No hay participantes para visualizar");
                    } else {
                        for (Map.Entry<Integer, String> participante : listadoParticipantes.entrySet()) {
                            System.out.println("Identificador: " + participante.getKey() + "Datos: " + participante.getValue());
                        }
                    }

                case 3:
                    if(listadoParticipantes.isEmpty()){
                        System.out.println("No hay participantes para eliminar");
                    }
                    else{
                        NavigableMap.Entry<Integer, String> ultimo_participante = listadoParticipantes.lastEntry();
                        listadoParticipantes.remove(ultimo_participante.getKey());  // revisar
                    }
            }
        }
    }


}