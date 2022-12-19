package Ejercicio1;

public class Basic extends Usuarios{

    public Basic(String nombre, String apellido) {
        super(nombre,apellido);
    }

    public void realizarConsultaDeSaldo(int cuentaConsulta) {
        ConsultaSaldo nuevaT = new ConsultaSaldo();
        // Aquí debería verificar que la cuenta exista para colocar el 1 o 0.
        nuevaT.realizarConsultaSaldo(1);
    }

    public void realizarPagoDeServicios() {
        PagoServicios nuevaT = new PagoServicios();
        // Aquí debería verificar que la cuenta exista para colocar el 1 o 0.
        nuevaT.realizarPagoServicio(1);
    }

    public void realizarRetiroDeEfectivo(int cantidadDineroRetirar) {
        RetiroDeEfectivo nuevaT = new RetiroDeEfectivo();
        // Aquí debería verificar que la cuenta exista para colocar el 1 o 0.
        nuevaT.realizarRetiroDeDinero(cantidadDineroRetirar);
    }

}
