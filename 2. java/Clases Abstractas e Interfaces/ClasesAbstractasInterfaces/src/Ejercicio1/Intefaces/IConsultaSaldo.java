package Ejercicio1.Intefaces;

public interface IConsultaSaldo extends IEstadoTransaccion{

    void consultaSaldo(String cuenta, boolean estadoTransaccion);
}
