package nave;

import java.awt.*;

public class NaveSimple implements Nave {
    private Point ubicacion;

    public NaveSimple(Point ubicacion) {
        this.ubicacion = ubicacion;
    }

    public NaveSimple(int x, int y) {
        this.ubicacion = new Point(x, y);
    }

    @Override
    public double calcularDistancia(Point point) {
        return ubicacion.distance(point);
    }
}
