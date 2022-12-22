package com.bootcamp.repository;

import com.bootcamp.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImpl implements Repository<Factura>{
    List<Factura> facturaList = new ArrayList<>();
    @Override
    public void guardar(Factura objeto) {
        facturaList.add(objeto);
    }

    @Override
    public void eliminar(Long id) {
        Optional<Factura> fac = this.buscar(id);

        if (fac.isEmpty()){
            System.out.println("No se encontro la Factura con codigo " + id + " para se borrada");
        }else {
            System.out.println("Se borro la factura con codigo " + id);
            facturaList.remove(fac.get());
        }
        for (Factura factura : facturaList){
            System.out.println(factura);
        }

    }

    @Override
    public void mostrar() {
        for (Factura fac : facturaList){
            System.out.println(fac);
        }
    }

    @Override
    public Optional<Factura> buscar(Long id) {
        boolean confirmacion = false;

        for (Factura fac : facturaList) {
            if (fac.getCodigo().equals(id)) {
                System.out.println(fac);
                confirmacion = true;
                return Optional.of(fac);
            }
        }
        if(!confirmacion){
            System.out.println("No se encontro el cliente con DNI " + id);
        }

        return Optional.empty();
    }

    @Override
    public List<Factura> buscarTodos() {
        return facturaList;
    }
}
