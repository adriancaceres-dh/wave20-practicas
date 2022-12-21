package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class RepositorioFacturas {
    List<Factura> facturas;

    public RepositorioFacturas() {
        this.facturas = new ArrayList<>();
    }

    public boolean agregarFactura(Factura factura) {
        return facturas.add(factura);
    }
}
