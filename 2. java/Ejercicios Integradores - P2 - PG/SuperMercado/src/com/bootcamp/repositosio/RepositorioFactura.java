package com.bootcamp.repositosio;

import com.bootcamp.clases.Factura;
import com.bootcamp.interfaces.ICRUD;

import java.util.ArrayList;
import java.util.List;

public class RepositorioFactura implements ICRUD<Factura> {

    List<Factura> listaFactura;

    public RepositorioFactura() {
        listaFactura = new ArrayList<>();
    }

    public List<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    @Override
    public int adicionarElemento(Factura elemento) {
        listaFactura.add(elemento);
        return listaFactura.size();
    }

    @Override
    public int eliminarElemento(Factura elemento) {
        listaFactura.remove(elemento);
        return listaFactura.size();
    }

    @Override
    public Factura obtenerElementoByPos(int pos) {
        return listaFactura.get(pos);
    }

    @Override
    public boolean existeElemento(Factura elemento) {
        return listaFactura.contains(elemento);
    }
}
