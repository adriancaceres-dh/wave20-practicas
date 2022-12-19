package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    List<ITransaccion> listaTransaccion = new ArrayList<>();

    public Cliente(List<ITransaccion> listaTransaccion) {
        this.listaTransaccion = listaTransaccion;
    }

    public List<ITransaccion> getListaTransaccion() {
        return listaTransaccion;
    }

    public void setListaTransaccion(List<ITransaccion> listaTransaccion) {
        this.listaTransaccion = listaTransaccion;
    }

    public Cliente() {
    }
}
