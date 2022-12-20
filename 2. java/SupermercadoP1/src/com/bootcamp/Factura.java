package com.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Factura {
    private List<Producto> productos;
    private long total;

    public Factura() {
        productos = new ArrayList<>();
    }

    public void addProducto(Producto producto) {
        productos.add(producto);
        calcularTotal();
    }

    public long getTotal() {
        return total;
    }

    private void calcularTotal() {
        total = productos.stream()
                .map(Producto::getTotal)
                .mapToLong(Long::longValue)
                .sum();
    }

    @Override
    public String toString() {
        return "Factura{" +
                "productos=" + productos.stream().map(Objects::toString).collect(Collectors.joining(", ")) +
                ", total=" + total +
                '}';
    }
}
