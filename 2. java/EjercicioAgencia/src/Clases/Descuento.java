package Clases;

import java.util.List;

public abstract class Descuento {
    boolean applied;

    public abstract double aplicarDescuentoSiCorresponde(List<Reserva> reservas,double precio,Cliente cliente);
}
