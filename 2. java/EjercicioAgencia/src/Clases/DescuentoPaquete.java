package Clases;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DescuentoPaquete extends Descuento{

    public DescuentoPaquete() {
        applied = false;
    }

    @Override
    public double aplicarDescuentoSiCorresponde(List<Reserva> reservas,double precio,Cliente cliente) {
        Map<String, Double> totalsByCategory = reservas.stream().collect(Collectors.groupingBy(e -> e.getClass().getSimpleName(), Collectors.summingDouble(e->e.getPrecio())));
        double montoAdescontar = 0;
        if(totalsByCategory.keySet().size() == 4){
            montoAdescontar = precio*0.1;
            applied = true;
        }

        System.out.println("Monto a descontar por Paquete " + montoAdescontar);

        return precio - montoAdescontar;
    }
}
