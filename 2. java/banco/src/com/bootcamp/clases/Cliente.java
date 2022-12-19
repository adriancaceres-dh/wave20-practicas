package com.bootcamp.clases;

import com.bootcamp.interfaces.ITransaccion;

public abstract class Cliente {
    protected void realizarTransaccion(ITransaccion transaccion) {
        transaccion.transaccionOk();
    }

    protected void realizarTransaccionErronea(ITransaccion transaccion) {
        transaccion.transaccionNoOk();
    }
}
