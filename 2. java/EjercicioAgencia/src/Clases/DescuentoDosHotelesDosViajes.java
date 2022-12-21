package Clases;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DescuentoDosHotelesDosViajes extends Descuento{

    public DescuentoDosHotelesDosViajes() {
        this.applied = false;
    }


    @Override
    public double aplicarDescuentoSiCorresponde(List<Reserva> reservas,double precio,Cliente cliente) {
        Map<String, Long> countsByCategory = reservas.stream().collect(Collectors.groupingBy(e -> e.getClass().getSimpleName(), Collectors.counting()));
        Map<String, Double> totalsByCategory = reservas.stream().collect(Collectors.groupingBy(e -> e.getClass().getSimpleName(), Collectors.summingDouble(e->e.getPrecio())));
        double montoADescontar = 0;

        try{
            if(countsByCategory.get("Viaje")>=2){
                montoADescontar = totalsByCategory.get("Viaje")*0.05;
                applied = true;
            }

            if(countsByCategory.get("Hotel")>=2){
                montoADescontar = montoADescontar + totalsByCategory.get("Hotel")*0.05;
                applied = true;
            }
            return precio - montoADescontar;
        }catch(NullPointerException e){
            return precio - montoADescontar;
        }finally {
            System.out.println("Monto a descontar por 2 Hoteles o 2 Viajes: " + montoADescontar);
        }


    }
}
