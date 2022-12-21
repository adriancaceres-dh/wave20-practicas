package Clases;

import java.util.List;

public class DescuentoClienteFrecuente extends Descuento{

    public DescuentoClienteFrecuente() {
        applied = false;
    }

    @Override
    public double aplicarDescuentoSiCorresponde(List<Reserva> reservas,double precio,Cliente cliente) {
        double montoADescontar = 0;
        if (Agencia.esClienteFrecuente(cliente)){
            montoADescontar = precio * 0.05;
            applied = true;

        }
        System.out.println("Monto a descontar por cliente frecuente: " + montoADescontar);
        return precio - montoADescontar;
    }
}
