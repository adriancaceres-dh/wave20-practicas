package Bootcamp.IntegradorP1.Crud;

import Bootcamp.IntegradorP1.Tienda.Cliente;
import Bootcamp.IntegradorP1.Tienda.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements Crud <Factura> {

    List<Factura> facturas = new ArrayList<>();

    @Override
    public void guardar(Factura objeto) {
        facturas.add(objeto);
    }

    @Override
    public void mostrar() {
        System.out.println("Facturas: ");
        facturas.stream().forEach(System.out::println);
    }

    @Override
    public Optional<Factura> buscar(Integer factura_buscada) {

        boolean buscado = false;
        for (Factura factura : facturas) {
            if (factura.getCodigo().equals(factura_buscada)) {
                System.out.println(factura.toString());
                buscado = true;
                return Optional.of(factura);
            }
        }
        if (buscado== false) {
            System.out.println("Factura no encontrada");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Integer factura_borrada) {
        Optional<Factura> f = this.buscar(factura_borrada);
        if (f.isEmpty()) {
            System.out.println("Factura no encontrada");
        }else{
            facturas.remove(f);
            System.out.println("Factura eliminada");
        }

    }

    @Override
    public List<Factura> traer() {
        return facturas;
    }
}
