package paquete;

import java.util.*;

public class principal {

    public static void main(String[] args) {
        int salir = 1;

        Map<Integer,List> mapa2 =new HashMap<>();
        Map<Integer,List> mapa1 =new HashMap<>();
        Map<Integer,List> mapa3 =new HashMap<>();
        do {
            List<String> lista =new ArrayList<String>();
            Scanner sp = new Scanner(System.in);
            System.out.print("1.Ingresar usuario \n2.Salir \n3.Eliminar usuario \n4.Mostrar inscripciones ");
            int escoger = Integer.parseInt(sp.nextLine());
            switch (escoger) {
                case 1:
                    String mensaje = null;
                    System.out.print("Categorias de inscripcion: \n 1. Circuito chico \n 2. Circuito medio \n 3. Circuito Avanzado \n Escribir numero al que deseas incribirte");
                    Scanner sp2 = new Scanner(System.in);
                    System.out.print(": ");
                    int opcion = Integer.parseInt(sp.nextLine());
                    int precio;
                    switch (opcion) {
                        case 1:
                            Scanner sp3 = new Scanner(System.in);
                            System.out.print("Ingrese el dni: ");
                            int dni = Integer.parseInt(sp3.nextLine());

                            System.out.print("Ingrese el nombre: ");
                            String nombre = sp3.nextLine();

                            System.out.print("Ingrese el apellido: ");
                            String apellido = sp3.nextLine();

                            System.out.print("Ingrese el edad: ");
                            int edad = Integer.parseInt(sp3.nextLine());

                            System.out.print("Ingrese el celular: ");
                            String celular = sp3.nextLine();

                            System.out.print("Ingrese el rh: ");
                            String rh = sp3.nextLine();


                            if (edad < 18) {
                                precio = 1300;
                            } else {
                                precio = 1500;
                            }

                            lista.add(nombre);
                            lista.add(apellido);
                            lista.add(String.valueOf(edad));
                            lista.add(celular);
                            lista.add(rh);
                            lista.add(String.valueOf(precio));
                            mapa1.put(dni,lista);
                            break;
                        case 2:
                            Scanner sp4 = new Scanner(System.in);
                            System.out.print("Ingrese el dni: ");
                            dni = Integer.parseInt(sp4.nextLine());

                            System.out.print("Ingrese el nombre: ");
                            nombre = sp4.nextLine();

                            System.out.print("Ingrese el apellido: ");
                            apellido = sp4.nextLine();

                            System.out.print("Ingrese el edad: ");
                            edad = Integer.parseInt(sp4.nextLine());

                            System.out.print("Ingrese el celular: ");
                            celular = sp4.nextLine();

                            System.out.print("Ingrese el rh: ");
                            rh = sp4.nextLine();


                            if (edad < 18) {
                                precio = 2000;
                            } else {
                                precio = 2300;
                            }

                            lista.add(nombre);
                            lista.add(apellido);
                            lista.add(String.valueOf(edad));
                            lista.add(celular);
                            lista.add(rh);
                            lista.add(String.valueOf(precio));
                            mapa2.put(dni,lista);
                            break;

                        case 3:
                            Scanner sp5 = new Scanner(System.in);
                            System.out.print("Ingrese el dni: ");
                            dni = Integer.parseInt(sp5.nextLine());

                            System.out.print("Ingrese el nombre: ");
                            nombre = sp5.nextLine();

                            System.out.print("Ingrese el apellido: ");
                            apellido = sp5.nextLine();

                            System.out.print("Ingrese el edad: ");
                            edad = Integer.parseInt(sp5.nextLine());

                            System.out.print("Ingrese el celular: ");
                            celular = sp5.nextLine();

                            System.out.print("Ingrese el rh: ");
                            rh = sp5.nextLine();


                            if (edad < 18) {
                                System.out.println("No se permite el ingreso de esta edad");
                                break;
                            } else {
                                precio = 2800;
                            }

                            lista.add(nombre);
                            lista.add(apellido);
                            lista.add(String.valueOf(edad));
                            lista.add(celular);
                            lista.add(rh);
                            lista.add(String.valueOf(precio));
                            mapa3.put(dni,lista);
                            break;
                    }

                    break;
                case 2:
                    salir=escoger;
                    break;

                case 3:
                    Scanner sp6 = new Scanner(System.in);
                    System.out.print("Ingrese el dni del usuario a eliminar: ");
                    int dniEliminar = Integer.parseInt(sp6.nextLine());
                    System.out.print("Ingrese la categotia a la que pertenece: ");
                    int cateEliminar = Integer.parseInt(sp6.nextLine());

                    if (cateEliminar==1){
                        mapa1.remove(dniEliminar);
                    }

                    if (cateEliminar==2){
                        mapa2.remove(dniEliminar);
                    }

                    if (cateEliminar==3){
                        mapa3.remove(dniEliminar);
                    }
                    break;
                case 4:
                    System.out.println("Inscritos de la categoria 1: "+mapa1);
                    System.out.println("Inscritos de la categoria 2: "+mapa2);
                    System.out.println("Inscritos de la categoria 3: "+mapa3);
                    break;
            }
        }while (salir!=2);

        System.out.println("Inscritos de la categoria 1: "+mapa1);
        System.out.println("Inscritos de la categoria 2: "+mapa2);
        System.out.println("Inscritos de la categoria 3: "+mapa3);

    }
}
