package Ejercicio1.Intefaces;

public interface IDeposito extends IEstadoTransaccion{

    void depositar(String cuenta, int monto, boolean estadoTransaccion);
}
