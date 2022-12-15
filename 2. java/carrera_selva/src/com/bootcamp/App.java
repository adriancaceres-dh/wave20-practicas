package com.bootcamp;

import java.util.*;

public class App {
    public static void main(String[] args) {
        //variables a usar
        String dni,nombre,apellido,edad,celular,telefonoEmergencia,grupoSanquineo;
        int categoria,precio,edadPrecio;
        //llevar el id de registro
        int n_participante=1;

        //HashMap por cada categoría
        Map<String, List<String>> circuitoChico =new HashMap<String, List<String>>();
        Map<String, List<String>> circuitoMedio =new HashMap<String, List<String>>();
        Map<String, List<String>> circuitoAvanzado =new HashMap<String, List<String>>();

        //almacena los dni, con el fin de verificar si ya existe el usuario
        Set<String> unique_values= new HashSet<>();


        int input=0;
        Scanner teclado = new Scanner(System.in);
        do {
            switch (input){
                //Inscripción participantes
                case 1 :
                    System.out.println("Ingrese la categoría: 1. chico, 2. medio, 3. avanzado");
                    categoria = teclado.nextInt();
                    System.out.println("Ingrese la edad del participante");
                    edad = teclado.next();
                    if(categoria==3 && Integer.parseInt(edad)<18){
                        System.out.println("edad no permitida para esta categoría !!!");
                        input=0;
                        break;
                    }
                    System.out.println("Ingrese el dni del participante");
                    dni = teclado.next();

                    //verificar si ya está inscrito
                    if(!unique_values.add(dni)){
                        System.out.println("ya existe el usuario");
                        input=0;
                        break;
                    }


                    System.out.println("Ingrese el nombre del participante");
                    nombre = teclado.next();
                    System.out.println("Ingrese el apellido del participante");
                    apellido = teclado.next();

                    System.out.println("Ingrese el celular del participante");
                    celular = teclado.next();
                    System.out.println("Ingrese el telefono de emergencia del participante");
                    telefonoEmergencia = teclado.next();
                    System.out.println("Ingrese el grupo sanguineo");
                    grupoSanquineo = teclado.next();



                    //añadir participante
                    List<String> usuario=new ArrayList<>();
                    usuario.add(dni);
                    usuario.add(nombre);
                    usuario.add(apellido);
                    usuario.add(edad);
                    usuario.add(celular);
                    usuario.add(telefonoEmergencia);
                    usuario.add(grupoSanquineo);
                    usuario.add(String.valueOf(n_participante++));
                    if(categoria==1){
                        circuitoChico.put(dni,usuario);
                    } else if (categoria==2) {
                        circuitoMedio.put(dni,usuario);
                    }else {
                        circuitoAvanzado.put(dni,usuario);
                    }

                    //costo de la inscripción
                    edadPrecio=Integer.parseInt(edad);
                    if(categoria==1){
                        precio =(edadPrecio<18) ? 1300 : 1500;
                        System.out.println("el costo de la inscripción es $"+precio);
                    } else if (categoria==2) {
                        precio =(edadPrecio<18) ? 2000 : 2300;
                        System.out.println("el costo de la inscripción es $"+precio);

                    }else {
                        System.out.println("el costo de la inscripción es $2800");
                    }
                    System.out.println("Inscripción exitosa!!!");
                    input=0;
                    break;
                //mostrar categoria chicos
                case 2:
                    System.out.println("Integrantes categoría chicos");
                    for (Map.Entry<String,List<String>> user: circuitoChico.entrySet()) {
                        System.out.println(user.getValue());
                    }
                    input=0;
                    break;
                case 3:
                    System.out.println("Integrantes categoría Medio");
                    for (Map.Entry<String,List<String>> user: circuitoMedio.entrySet()) {
                        System.out.println(user.getValue());
                    }
                    input=0;
                    break;
                case 4:
                    System.out.println("Integrantes categoría Avanzado");
                    for (Map.Entry<String,List<String>> user: circuitoAvanzado.entrySet()) {
                        System.out.println(user.getValue());
                    }
                    input=0;
                    break;
                case 5:
                    System.out.println("Ingrese dni del participante");
                    dni=teclado.next();
                    unique_values.remove(dni);

                    System.out.println("Ingrese la categoría: 1. chico, 2. medio, 3. avanzado");
                    categoria = teclado.nextInt();
                    if(categoria==1){
                        circuitoChico.remove(dni);
                    } else if (categoria==2) {
                        circuitoMedio.remove(dni);
                    }else {
                        circuitoAvanzado.remove(dni);
                    }
                    System.out.println("Eliminado");
                    input=0;
                    break;


                default:
                    System.out.println("    Bienvenido al sistema");
                    System.out.println("Escriba el numeral correspondiente:");
                    System.out.println("1. Inscribir participante");
                    System.out.println("2. Mostrar participantes categoría chico");
                    System.out.println("3. Mostrar participantes categoría medio");
                    System.out.println("4. Mostrar participantes categoría avanzado");
                    System.out.println("5. Desinscribir participante");
                    System.out.println("7. Salir");
                    input = teclado.nextInt();
                    System.out.println(input);
            }

        }while (input!=7);


    }
}
