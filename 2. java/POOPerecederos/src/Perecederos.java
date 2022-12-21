import java.util.HashMap;
import java.util.Map;

public class Perecederos extends Producto {

    private static Map<Integer,Double> descuento = new HashMap<>();
    private int diasPorCaducar;
    static {
        descuento.put(1,0.25);
        descuento.put(2,0.33);
        descuento.put(3,0.5);
    }

    public Perecederos(String nombre, double precio, int diasPorCaducar) {
        super(nombre,precio);
        this.diasPorCaducar = diasPorCaducar;
        descuento.get(1);

    }

    @Override
    protected double calcular(double cantidadProductos) {
        return (cantidadProductos * precio) * descuento.get(diasPorCaducar);
    }
}
