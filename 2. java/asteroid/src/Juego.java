import nave.FlotaNaves;
import nave.NaveSimple;
import participante.Participante;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Juego {
    private static final int MAP_WIDTH = 10;
    private static final int MAP_HEIGHT = 10;
    private static final int POINT_AMOUNT = 3;

    private static Point crearPuntoAleatorio() {
        return new Point(
                (int) (Math.random() * MAP_WIDTH),
                (int) (Math.random() * MAP_HEIGHT)
        );
    }

    private static List<Point> generarPuntos(){
        List<Point> puntos = new ArrayList<>();
        for(int i = 0; i < POINT_AMOUNT; i++){
            puntos.add(crearPuntoAleatorio());
        }
        return puntos;
    }

    public static void main(String[] args) {
        List<Participante> participantes = List.of(
                new Participante("Juan", new NaveSimple(4,4)),
                new Participante("Juana", new FlotaNaves(
                        new NaveSimple(3, 5),
                        new NaveSimple(1, 4)
                        )
                )
        );
        System.out.println("------------------------");
        for(Point punto : generarPuntos()) {
            System.out.println("La nave está en x: " + punto.getX() + ", y: " + punto.getY());
            Participante participanteMasCercano = participantes.stream()
                    .min(Comparator.comparingDouble(p -> p.calcularDistancia(punto)))
                    .get();
            participanteMasCercano.sumarPunto();
            System.out.println("------------------------");
            System.out.println("El punto se lo llevó " + participanteMasCercano.getNombre());
            System.out.println("------------------------");

        }
        Participante ganador = participantes.stream()
                .max(Comparator.comparingInt(Participante::getPuntaje))
                .get();
        System.out.println("El ganador es: " + ganador.getNombre());
    }
}