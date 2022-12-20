package Ejercicio1.Intefaces;

public interface ITransferencia extends IEstadoTransaccion{

    void transferencia(String cuenta, int monto, boolean estadoTransaccion);
}
