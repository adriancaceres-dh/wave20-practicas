package ejercicio_1;

public class Ejecutivo {

        public void realizarDeposito(){
            ITransaccion deposito = new Deposito();
            deposito.transaccionOk();
        }
        public void realizarTransferencia(){
            ITransaccion transferencia = new Transferencia();
            transferencia.transaccionOk();
        }
}
