package model;

import java.util.List;

public class Cobrador extends Cliente{
    public Cobrador(List<ITransaccion> listaTransaccion) {
        super(listaTransaccion);
    }

    public Cobrador() {
    }
}
