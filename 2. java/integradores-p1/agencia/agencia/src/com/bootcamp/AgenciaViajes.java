package com.bootcamp;

import java.util.HashMap;
import java.util.Map;

public class AgenciaViajes {
    Map<String, Cliente> clientes;
    public AgenciaViajes() {
        this.clientes = new HashMap<String, Cliente>();
    }

    public boolean contratarLocalizador(Cliente cliente, Localizador localizador) {
        if (!clientes.containsKey(cliente.dni)) {
            clientes.put(cliente.dni, cliente);
        }

        boolean localizadorValido = cliente.agregarLocalizador(localizador);
        System.out.println(localizador);
        return localizadorValido;
    }
}
