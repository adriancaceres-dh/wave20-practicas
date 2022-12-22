package com.transacciones_banco;

public class TransactionVisitorImpl<T extends ICliente> implements TransactionVisitor{

    private T cliente;
    TransactionVisitorImpl(T cliente) {
        this.cliente = cliente;
    }


    @Override
    public void visitar(PagarServicios servicios) {
        System.out.println("Pagando servicios...");
        servicios.transaccionOk(cliente);
    }

    @Override
    public void visitar(RealizarDeposito deposito) {
        System.out.println("Realizando deposito...");
        deposito.transaccionOk(cliente);
    }

    @Override
    public void visitar(RealizarTransferencia transferencia) {
        System.out.println("Realizando transferencia...");
        transferencia.transaccionOk(cliente);
    }

    @Override
    public void visitar(RetirarEfectivo efectivo) {
        System.out.println("Retirando efectivo...");
        efectivo.transaccionOk(cliente);
    }

    @Override
    public void visitar(ConsultarSaldo saldo) {
        System.out.println("Consultando saldo...");
        saldo.transaccionOk(cliente);
    }
}
