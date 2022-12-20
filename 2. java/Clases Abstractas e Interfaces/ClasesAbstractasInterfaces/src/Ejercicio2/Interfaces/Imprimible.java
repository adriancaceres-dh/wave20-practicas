package Ejercicio2.Interfaces;

public interface Imprimible<T> {
    static <T> void imprimir(T object) {
        System.out.println(object.toString());
    }
}
