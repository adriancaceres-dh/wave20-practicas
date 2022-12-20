package Ejercicio1.Intefaces;

public interface IRetiroEfectivo extends IEstadoTransaccion{

    void retiroEfectivo(String cuenta, int cantidad, boolean estadoTransaccion);
}
