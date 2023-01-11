package ejercicio_1;

public class Cobrador {
    public void realizarRetiro(){
        ITransaccion retiro = new RetiroDeEfectivo();
        retiro.transaccionOk();


    }

    public void realizarConsulta(){
        ITransaccion consulta = new ConsultaDeSaldo();
        consulta.transaccionOk();
    }
}
