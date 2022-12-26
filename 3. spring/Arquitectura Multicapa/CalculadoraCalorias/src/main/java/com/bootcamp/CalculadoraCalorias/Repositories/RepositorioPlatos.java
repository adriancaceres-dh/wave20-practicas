package com.bootcamp.CalculadoraCalorias.Repositories;

import com.bootcamp.CalculadoraCalorias.Models.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioPlatos {

    public List<Plato> platos = incluirPlatos();

    public List<Plato> incluirPlatos(){
        platos = new ArrayList<>();
        platos.add(Plato.builder().nombre ("Sardinas").peso(12).ingredientes(List.of("Acelgas","Ajos", "Apio")).build());
        platos.add(Plato.builder().nombre ("Guiso").peso(12).ingredientes(List.of("Calabaza","Cebolla", "Col")).build());
        platos.add(Plato.builder().nombre ("Asado").peso(12).ingredientes(List.of("Espinaca","Lechuga", "Perejil")).build());

        return platos;
    }
}
