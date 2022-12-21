package com.company.model;

import java.util.List;

public class Supermercado {
    private static RepositorioClientes repositorioClientes = new RepositorioClientes();
    private static RepositorioFacturas repositorioFacturas = new RepositorioFacturas();

    public static boolean emitirFactura(Cliente cliente, List<Item> itemsFactura){
        repositorioClientes.agregarCliente(cliente);
        return repositorioFacturas.agregarFactura(new Factura(itemsFactura,cliente));
    }
}
