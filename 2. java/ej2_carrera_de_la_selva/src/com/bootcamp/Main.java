package com.bootcamp;

import java.util.*;

public class Main {

    //Intento de solucion sin clases, ni spring. 

    static List<Integer> listadoCircuitoChico= new ArrayList<>();
    static List<Integer> listadoCircuitoMedio= new ArrayList<>();
    static List<Integer> listadoCircuitoAvanzado= new ArrayList<>();

    static int id=-1;
    static List<String> listaDNI= new ArrayList<>();
    static List<String> listaNombre= new ArrayList<>();
    static List<String> listaApellido= new ArrayList<>();
    static List<Integer> listaEdad= new ArrayList<>();
    static List<String> listaCelular= new ArrayList<>();
    static List<String> listaNumEmergencia= new ArrayList<>();
    static List<String> listaGrupoSanguineo= new ArrayList<>();
    static List<Integer> listaMonto= new ArrayList<>();

    public static int determinarMonto(int cat, int edad){
        int monto;
        switch (cat){
            case 1:
                monto= (edad>=18) ? 1500 : 1300;
                break;
            case 2:
                monto= (edad>=18) ? 2300 : 2000;
                break;
            default:
                monto= 2800;
                break;
        }
        return monto;
    }

    public static void agregarCompetidor(){

        System.out.println("¿A que categoria quiere inscribirse?");
        System.out.println("1.Circuito chico");
        System.out.println("2.Circuito medio");
        System.out.println("3.Circuito avanzado");
        Scanner sc = new Scanner(System.in);
        int cat = sc.nextInt();

        if (cat!=1 && cat!=2 && cat!=3){
            System.out.println("No existe categoria.");
            return;
        }

        System.out.println("Ingrese su edad:");
        int edad=sc.nextInt();
        if (edad>=18 || cat!=3){
            Scanner sc2= new Scanner(System.in);
            id++;
            listaEdad.add(edad);
            System.out.println("Ingrese su nombre: ");
            String nombre= sc2.nextLine();
            listaNombre.add(nombre);
            System.out.println("Ingrese su apellido: ");
            String apellido= sc2.nextLine();
            listaApellido.add(apellido);
            System.out.println("Ingrese su dni: ");
            String dni= sc2.nextLine();
            listaDNI.add(dni);
            System.out.println("Ingrese su celular: ");
            String celular= sc2.nextLine();
            listaCelular.add(celular);
            System.out.println("Ingrese su numero de emergencia: ");
            String numEmergencia= sc2.nextLine();
            listaNumEmergencia.add(numEmergencia);
            System.out.println("Ingrese su grupo sanguineo: ");
            String grupoSang= sc2.nextLine();
            listaGrupoSanguineo.add(grupoSang);
            Integer monto= determinarMonto(cat, edad);
            listaMonto.add(monto);

            switch (cat){
                case 1:
                    listadoCircuitoChico.add(id);
                    break;
                case 2:
                    listadoCircuitoMedio.add(id);
                    break;
                case 3:
                    listadoCircuitoAvanzado.add(id);
                    break;
            }
        }
        else{
            System.out.println("No se permiten menores de edad en esta categoria.");
        }

    }

    public static void imprimir(int id){

        System.out.println("ID: "+id);
        System.out.println("Nombre: "+ listaNombre.get(id));
        System.out.println("Apellido: "+listaApellido.get(id));
        System.out.println("DNI: "+listaDNI.get(id));
        System.out.println("Edad: "+listaEdad.get(id));
        System.out.println("Celular: "+listaCelular.get(id));
        System.out.println("Numero Emergencia: "+listaNumEmergencia.get(id));
        System.out.println("Grupo Sanguineo: "+listaGrupoSanguineo.get(id));
        System.out.println("Monto: "+listaMonto.get(id));
        System.out.println("-------------------------------------");

    }

    public static void mostrarListado(){
        System.out.println("Elija que listado mostrar:");
        System.out.println("1.Circuito chico");
        System.out.println("2.Circuito medio");
        System.out.println("3.Circuito avanzado");
        Scanner sc= new Scanner(System.in);
        int opcion= sc.nextInt();
        switch (opcion){
            case 1:
                for(int id : listadoCircuitoChico) imprimir(id);
                break;
            case 2:
                for(int id : listadoCircuitoMedio) imprimir(id);
                break;
            case 3:
                for(int id : listadoCircuitoAvanzado) imprimir(id);
                break;
            default:
                System.out.println("No existe listado");
                break;
        }
    }

    public static void desinscribirParticipante() {

        System.out.println("Seleccione de que categoria quiere desinscribir un participante: ");
        System.out.println("1.Circuito chico");
        System.out.println("2.Circuito medio");
        System.out.println("3.Circuito avanzado");
        Scanner sc= new Scanner(System.in);
        int cat= sc.nextInt();

        switch (cat){
            case 1:
                if(!listadoCircuitoChico.isEmpty()) listadoCircuitoChico.remove(listadoCircuitoChico.size()-1);
                break;
            case 2:
                if(!listadoCircuitoMedio.isEmpty()) listadoCircuitoMedio.remove(listadoCircuitoMedio.size()-1);
                break;
            case 3:
                if(!listadoCircuitoAvanzado.isEmpty()) listadoCircuitoAvanzado.remove(listadoCircuitoAvanzado.size()-1);
                break;
        }
    }

    public static void cargaParticipantes(){
        boolean cargar=true;
        char opcion;
        Scanner sc= new Scanner(System.in);

        while (cargar){
            System.out.println("¿Quiere cargar un nuevo participante? Y/N");
            opcion= sc.next().charAt(0);
            if(opcion=='Y'){
                agregarCompetidor();
            }
            else if(opcion=='N'){
                cargar=false;
            }
            else{
                System.out.println("Vuelva a intentar.");
            }
        }
        System.out.println();
        System.out.println("Carga completa.");
        System.out.println();
    }

    public static void main(String[] args) {
        cargaParticipantes();
        mostrarListado();
        desinscribirParticipante();
    }
}
