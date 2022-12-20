import generador.GeneradorDeSeriesDouble;
import generador.GeneradorDeSeriesInteger;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GeneradorDeSeriesInteger generadorDeSeriesInteger = new GeneradorDeSeriesInteger(2, 0);
        GeneradorDeSeriesDouble generadorDeSeriesDouble = new GeneradorDeSeriesDouble(3D, 1D);

        List.of(generadorDeSeriesInteger, generadorDeSeriesDouble)
                .forEach(generadorDeSeries -> {
                    System.out.println(
                            generadorDeSeries.getClass().getSimpleName() + ":");
                    for(int i = 0; i < 4; i++){
                        System.out.println(generadorDeSeries.next());
                    }
                });
    }
}