package com.bootcamp.intefaces;

public interface IPagoServicios extends ITransaccion {

    public boolean hacerPagoServicios(String servicio, double monto);
}