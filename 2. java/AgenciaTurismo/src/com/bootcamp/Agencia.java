package com.bootcamp;

import com.bootcamp.utils.DescuentoCompraUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Agencia {
    private final List<Cliente> clientes;
    private final List<Localizador> localizadores;

    public Agencia() {
        this.clientes = new ArrayList<>();
        this.localizadores = new ArrayList<>();
    }


    public Localizador agregarLocalizador(Localizador localizador) {
        Localizador localizadorConDescuento = DescuentoCompraUtil.obtenerLocalizadorConDescuentoAplicado(localizador, localizadores);
        localizadores.add(localizadorConDescuento);
        if (noEsClienteRegistrado(localizador.getCliente().getDni())) {
            clientes.add(localizador.getCliente());
        }
        return localizadorConDescuento;
    }

    private boolean noEsClienteRegistrado(String dni) {
        Optional<Cliente> cliente = clientes.stream()
                .parallel()
                .filter(c -> c.getDni().equals(dni))
                .findAny();
        return cliente.isEmpty();
    }

}
