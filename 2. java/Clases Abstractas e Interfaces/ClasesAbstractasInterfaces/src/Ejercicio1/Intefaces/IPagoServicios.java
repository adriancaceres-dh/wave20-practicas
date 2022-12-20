package Ejercicio1.Intefaces;

public interface IPagoServicios extends IEstadoTransaccion{
    void pagarServicios(String nombreServicio, boolean estadoTransaccion);
}
