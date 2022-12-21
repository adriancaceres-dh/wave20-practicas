package com.bootcamp.descuento;

import com.bootcamp.localizador.Localizador;

import java.util.ArrayList;
import java.util.List;

public class ListaDescuentos {
    private List<IDescuento> descuentos;

    public ListaDescuentos(Localizador localizador) {
        descuentos = new ArrayList<>();
        descuentos.add(new DescuentoFidelizacion(localizador));
        descuentos.add(new DescuentoPaqueteCompleto(localizador));
        descuentos.add(new DescuentoBaseDoble(localizador));
    }

    public List<IDescuento> getDescuentos() {
        return descuentos;
    }
}
