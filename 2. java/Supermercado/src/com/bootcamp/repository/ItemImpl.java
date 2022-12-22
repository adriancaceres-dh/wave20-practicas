package com.bootcamp.repository;

import com.bootcamp.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImpl implements Repository<Item>, Calculo<Item>{
    List<Item> itemList = new ArrayList<>();

    @Override
    public Double calcular() {
        Double total = 0.0;
        for (Item i : itemList){
            total += i.getCostoUnidad();
        }
        return total;
    }

    @Override
    public Item verificar(Long dni, String nombre, String apellido) {
        return null;
    }

    @Override
    public void guardar(Item objeto) {
        itemList.add(objeto);
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public void mostrar() {
        for (Item i : itemList){
            System.out.println(i);
        }
    }

    @Override
    public Optional<Item> buscar(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Item> buscarTodos() {
        return itemList;
    }
}
