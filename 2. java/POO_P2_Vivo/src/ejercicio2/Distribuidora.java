package ejercicio2;

import java.util.stream.Stream;

public class Distribuidora {

    public static void main(String[] args) {
        Stream.of(
                new Perecedero("Queso",7500,3),
                new Perecedero("Yogurt",9000,3),
                new Perecedero("Pera",1000,6),
                new Perecedero("Jamon",16000,2),
                new Perecedero("Durazno",2000,1),
                new NoPerecedero("Monitor",1400000,"Accesorios PC"),
                new NoPerecedero("Mouse",70000,"Accesorios PC"),
                new NoPerecedero("Silla",950000,"Mueble"),
                new NoPerecedero("Ventilador",200000,"Electrodomestico"),
                new NoPerecedero("Vaso",11000,"Cocina")
        )
                .map(producto -> String.format("%s\t\t%.2f", producto.getNombre(), producto.calcular(5)))
                .forEach(System.out::println);
    }
}
