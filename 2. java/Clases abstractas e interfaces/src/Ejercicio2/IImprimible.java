package Ejercicio2;

public interface IImprimible<T> {
    static <T> void imprimir(T objetoAImprimir){
        System.out.println(objetoAImprimir.toString());
    };
}
