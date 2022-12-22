package com.transacciones_banco;

public interface TransactionVisitor {

    void visitar(PagarServicios servicios);

    void visitar(RealizarDeposito deposito);

    void visitar(RealizarTransferencia transferencia);

    void visitar(RetirarEfectivo efectivo);

    void visitar(ConsultarSaldo saldo);
}
