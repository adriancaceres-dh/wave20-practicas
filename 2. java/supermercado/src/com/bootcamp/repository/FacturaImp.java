package com.bootcamp.repository;

import com.bootcamp.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDRepository<Factura>{
    List<Factura> facturaList = new ArrayList<Factura>();
    @Override
    public void save(Factura objeto) {
        facturaList.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for(Factura factura : facturaList){
            System.out.println(factura.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(Integer idBuscar) {
       boolean bandera = false;
       for(Factura fac : facturaList){
           if(fac.getId_factura() == idBuscar){
               System.out.println("--Factura encontrada :)--");
               System.out.println(fac);
               return Optional.of(fac);
           }
       }
       if(bandera == false){
           System.out.println("No se enconntró la factura :(");
       }
       return Optional.empty();
    }

    @Override
    public void eliminar(Integer idBorrar) {
        Optional<Factura> factura = this.buscar(idBorrar);
        if(factura.isEmpty()){
            System.out.println("No se encontró la factura a eliminar :8");
        }
        else {
            System.out.println("Se eliminó la factura :)");
            facturaList.remove(factura.get());
        }
    }
    @Override
    public List<Factura> traerTodos() {
        return facturaList;
    }
}
