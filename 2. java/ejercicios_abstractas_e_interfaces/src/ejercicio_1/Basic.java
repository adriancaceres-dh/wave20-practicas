package ejercicio_1;

public class Basic {
    public void realizarConsultaDeSaldo(){
        ITransaccion consulta = new ConsultaDeSaldo();
        consulta.transaccionOk();

    }

    public void pagoDeServicio(){
        ITransaccion pago = new PagoDeServicios();
        pago.transaccionOk();
    }

    public void retiroEfectivo(){
        ITransaccion retiro = new RetiroDeEfectivo();
        retiro.transaccionOk();
    }
}
