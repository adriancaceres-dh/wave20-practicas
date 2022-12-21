package com.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Facturaimp implements CRUD<Factura>{
    private List<Factura> facturas=new ArrayList<>();
    @Override
    public void guardar(Factura objeto) {

        facturas.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        facturas.stream().forEach(System.out::println);
    }

    @Override
    public Optional<Factura> buscar(String id) {
        Optional<Factura> resultadoBusqueda=facturas.stream().filter(x->x.getCodigoFactura().equals(id)).findFirst();
        if (!resultadoBusqueda.isEmpty()) System.out.println(resultadoBusqueda.get());
        else System.out.println("Factura no encontrado");
        return resultadoBusqueda;

    }

    @Override
    public void eliminar(String id) {
        Optional<Factura> resultadoBusqueda=buscar(id);
        if(!resultadoBusqueda.isEmpty()){
            facturas.remove(resultadoBusqueda.get());
            mostrarPantalla();
        }

    }

    @Override
    public List<Factura> traerTodos() {
        return facturas;
    }
}
