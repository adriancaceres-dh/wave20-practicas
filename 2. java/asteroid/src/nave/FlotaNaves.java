package nave;

import java.awt.*;
import java.util.List;
import java.util.OptionalDouble;

public class FlotaNaves implements Nave{
    private List<Nave> naves;

    public FlotaNaves(List<Nave> naves) {
        this.naves = naves;
    }

    public FlotaNaves(Nave... naves) {
        this.naves = List.of(naves);
    }

    @Override
    public double calcularDistancia(Point point) {
        OptionalDouble maybeAverage = naves.stream()
                .mapToDouble( nave -> nave.calcularDistancia(point))
                .average();
        if(maybeAverage.isPresent()){
            return maybeAverage.getAsDouble();
        } else {
            throw new ArithmeticException("Error obteniendo el promedio");
        }
    }
}
