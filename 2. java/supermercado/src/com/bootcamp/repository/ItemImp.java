package com.bootcamp.repository;

import com.bootcamp.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements CRUDRepository<Item>{

    List<Item> itemList = new ArrayList<Item>();
    @Override
    public void save(Item objeto) {
     itemList.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        itemList.stream()
                .forEach(System.out::println);

    }
    @Override
    public Optional<Item> buscar(Integer idBuscar) {
      boolean bandera = false;
      for(Item it : itemList){
          if(it.getCodigo().equals(idBuscar)){
              System.out.println("--Item encontrado :)--");
              System.out.println(it);
              return Optional.of(it);
          }
      }
      if(bandera == false){
          System.out.println("No se encontró el item :(");
      }
      return Optional.empty();
    }

    @Override
    public void eliminar(Integer idBorrar) {
        Optional<Item> item = this.buscar(idBorrar);
        if(item.isEmpty()){
            System.out.println("No se encontró el item a borrar :(");
        }
        else {
            System.out.println("Item eliminado :)");
            itemList.remove(item.get());
        }
    }
    @Override
    public List<Item> traerTodos() {
        return itemList;
    }
}
