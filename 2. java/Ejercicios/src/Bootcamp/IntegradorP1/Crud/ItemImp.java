package Bootcamp.IntegradorP1.Crud;

import Bootcamp.IntegradorP1.Tienda.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements Crud <Item> {

    List<Item> items = new ArrayList<>();

    @Override
    public void guardar(Item objeto) {
        items.add(objeto);
    }

    @Override
    public void mostrar() {
        System.out.println("Items: ");
        items.stream().forEach(System.out::println);

    }
    @Override
    public Optional<Item> buscar(Integer item_buscado) {

        boolean buscado = false;
        for (Item item : items) {
            if (item.getCodigo().equals(item_buscado)) {
                System.out.println(item.toString());
                buscado = true;
                return Optional.of(item);
            }
        }
        if (buscado== false) {
            System.out.println("Item no encontrado");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Integer item_borrado) {
        Optional<Item> item = this.buscar(item_borrado);
        if (items.isEmpty()) {
            System.out.println("Items no encontrados");
        }
        else {
            System.out.println("Item eliminado");
            items.remove(item.get());
        }
    }

    @Override
    public List<Item> traer() {
        return items;
    }
}
