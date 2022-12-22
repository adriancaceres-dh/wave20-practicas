package com.bootcamp;

public class Main {
    public static void main(String[] args) {

        Serie serie = new Serie(1);

        // si la serie comienza cin 1 por requerimiento aumenta de 2 en 2
        // llamando a la funcion siguiente aumenta en 2
        System.out.println(serie.siguiente());

        // volviendo a llamar a siguente aumenta en 2
        System.out.println(serie.siguiente());

        // reiniciamos el valor inicial a 0
        serie.reiniciar();
        System.out.println(serie.numero);

        // establecemos el valor de inicio en 3
        serie.valorInicial(3);

        // la serie ahora aumenta de 3 en 3
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());

    }
}