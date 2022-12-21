public class Main {

    public static void main(String[] args){
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarTransferencia();
        ejecutivo.depositar();

        Cobrador cobrador = new Cobrador();
        /*
        cobrador.transaccionOk();
        Si se intenta llamar metodo de transaccion se levantara error debido al override
        se hace esto al no poder aplicar method - hiding por implementacion de interfaces y metodos publicos
        */
        cobrador.consultarSaldo();
        cobrador.retirarEfectivo();

        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.retirarEfectivo();
        basic.pagarServicios();

    }
}
