package com.bootcamp.repositosio;

import com.bootcamp.clases.Cliente;
import com.bootcamp.clases.Producto;
import com.bootcamp.interfaces.ICRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioProducto implements ICRUD<Producto> {

    List<Producto> listaProductos;

    public RepositorioProducto() {
        listaProductos = new ArrayList<>();
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public int adicionarElemento(Producto elemento) {
        List<Producto> productosEncontrados = existeProducto(elemento.getCodigo());
        if (productosEncontrados != null && productosEncontrados.size() > 0) {
            int pos = listaProductos.indexOf(productosEncontrados.get(0));
            Producto producto = listaProductos.get(pos);
            producto.setCantComprada(producto.getCantComprada() + elemento.getCantComprada());
            listaProductos.set(pos, producto);
        } else {
            listaProductos.add(elemento);
        }
        return listaProductos.size();
    }

    @Override
    public int eliminarElemento(Producto elemento) {
        listaProductos.remove(elemento);
        return listaProductos.size();
    }

    @Override
    public Producto obtenerElementoByPos(int pos) {
        return listaProductos.get(pos);
    }

    @Override
    public boolean existeElemento(Producto elemento) {
        return listaProductos.contains(elemento);
    }

    public List<Producto> existeProducto(String codigo) {
        List<Producto> productosEncontradoss = listaProductos.stream().filter(x -> x.getCodigo().equalsIgnoreCase(codigo)).collect(Collectors.toList());
        if (productosEncontradoss.size() > 0) {
            return productosEncontradoss;
        }
        return null;
    }
}
