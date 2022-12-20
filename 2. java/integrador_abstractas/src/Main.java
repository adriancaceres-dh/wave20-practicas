// Si bien entiendo que el ejercicio pide explicitamente la utilizacion de
// clases abstractas, es una mala practica crear clases hijas solo para cambiar algo
// que tranquilamente podria hacerse desde un atributo de la misma clase generador.GeneradorDeSeries
// como podria ser 'int salto' (literalmente termine copy-pasteando las clases)

import generador.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GeneradorDeSeries2 generadorDeSeries2 = new GeneradorDeSeries2();
        GeneradorDeSeries3 generadorDeSeries3 = new GeneradorDeSeries3();
        GeneradorDeSeriesN generadorDeSeriesN = new GeneradorDeSeriesN(4);

        List.of(generadorDeSeries2, generadorDeSeries3, generadorDeSeriesN)
                .forEach(generadorDeSeries -> {
                    int valorInicial = (int) (Math.random() * 3); // Valor incial entre 0 y 2
                    generadorDeSeries.setValorInicial(valorInicial);
                    System.out.println(
                            generadorDeSeries.getClass().getSimpleName() + " con valor inicial " + valorInicial+ ": ");
                    for(int i = 0; i < 4; i++){
                        System.out.println(generadorDeSeries.next());
                    }
                });
    }
}