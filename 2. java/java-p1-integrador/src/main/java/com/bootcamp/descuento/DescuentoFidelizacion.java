package com.bootcamp.descuento;

import com.bootcamp.localizador.Localizador;
import com.bootcamp.localizador.RepoLocalizadores;

import java.util.List;
import java.util.stream.Collectors;

public class DescuentoFidelizacion implements IDescuento {
    private Localizador localizador;

    public DescuentoFidelizacion(Localizador localizador) {
        this.localizador = localizador;
    }

    @Override
    public double aplicarDescuento() {
        List<Localizador> localizadoresAnterioresCliente = RepoLocalizadores.getLocalizadores().stream()
                .filter(c -> c.getCliente().getDni().equalsIgnoreCase(localizador.getCliente().getDni()))
                .filter(c -> c.getFecha().compareTo(localizador.getFecha()) < 0)
                .collect(Collectors.toList());
        if (localizadoresAnterioresCliente.size() >= 2)
            return 0.05 * localizador.subTotal();
        return 0;
    }
}
