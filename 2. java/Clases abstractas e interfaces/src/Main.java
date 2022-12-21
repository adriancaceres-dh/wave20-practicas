import Ejercicio1.Banco;
import Ejercicio1.Basic;
import Ejercicio1.Cobradores;
import Ejercicio1.Ejecutivos;
import Ejercicio2.Curriculum;
import Ejercicio2.IImprimible;
import Ejercicio2.Informes;
import Ejercicio2.LibrosPDF;
import Ejercicio3.Animal;
import Ejercicio3.Gato;
import Ejercicio3.Perro;
import Ejercicio3.Vaca;
import Generics_Wrapper_Lambda_Streams.Garaje;
import Generics_Wrapper_Lambda_Streams.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("##############EJERCICIO 1##############");
        // Creamos los usuarios del banco.
        Basic U1 = new Basic("Emanuel", "Fonseca");
        Cobradores C1 = new Cobradores("Adrián", "Cáceres");
        Ejecutivos E1 = new Ejecutivos("Diego", "Forlán");
        // Creamos el banco.
        Banco ITAU = new Banco("ITAU");
        // Agregamos los usuarios a la lista de usuarios del banco.
        ITAU.agregarUsuariosBanco(U1);
        ITAU.agregarUsuariosBanco(C1);
        ITAU.agregarUsuariosBanco(E1);
        // Los usuarios realizan consultas.
        ITAU.realizarConsultaDeSaldo(U1);
        ITAU.realizarRetiroDeEfectivo(1,C1);
        ITAU.realizarTransferencia(0,E1);
        System.out.println();*/

        /*System.out.println("##############EJERCICIO 2##############");
        Curriculum nuevoCV = new Curriculum("Emanuel","Ingenioso-Dedicado");
        LibrosPDF nuevoLPDF = new LibrosPDF(12,"Adrián","Chistes malos",
                "Entretenimiento");

        ArrayList<String> texto = new ArrayList<>();
        texto.add("La casa de al lado");
        texto.add("La casa de la abuela");
        Informes nuevoInf = new Informes(texto,12,"Micaela","Fonseca");
        IImprimible.imprimir(nuevoCV);
        IImprimible.imprimir(nuevoLPDF);
        IImprimible.imprimir(nuevoInf);
        System.out.println();*/

        System.out.println("##############EJERCICIO 3##############");
        Animal gatitoChico = new Gato("Bombona");
        Animal perroCiego = new Perro("Fatiga");
        Animal vacaLechera = new Vaca("Pompas");

        gatitoChico.emitirSonidos();
        perroCiego.emitirSonidos();
        vacaLechera.emitirSonidos();

        // ¿¿¿¿¿¿¿Cómo se puede hacer la parte extra??????


        /*Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuna", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);

        Garaje G1 = new Garaje(123);

        G1.agregarNuevoVehiculo(v1);
        G1.agregarNuevoVehiculo(v2);
        G1.agregarNuevoVehiculo(v3);
        G1.agregarNuevoVehiculo(v4);
        G1.agregarNuevoVehiculo(v5);
        G1.agregarNuevoVehiculo(v6);
        G1.agregarNuevoVehiculo(v7);
        G1.agregarNuevoVehiculo(v8);
        G1.agregarNuevoVehiculo(v9);
        G1.agregarNuevoVehiculo(v10);
        G1.agregarNuevoVehiculo(v11);

        //LinkedList<Vehiculo> listaVehiculosPorPrecio = G1.getVehiculos().stream().sorted(Comparator.reverseOrder());
        List<String> sortedList = G1.getVehiculos().stream()
                .sorted((o1, o2) -> o1.getCosto()< o2.getCosto())
                .collect(Collectors.toList());
        List<Vehiculo> sortedList2 = G1.getVehiculos().stream()
                .sorted(Comparator.comparingInt(Vehiculo::getCosto)
                        .reversed())
                .collect(Collectors.toList());
        sortedList2.forEach(System.out::println);*/
    }
}