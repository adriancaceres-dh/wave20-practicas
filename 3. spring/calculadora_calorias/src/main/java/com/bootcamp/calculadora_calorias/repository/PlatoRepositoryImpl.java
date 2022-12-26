package com.bootcamp.calculadora_calorias.repository;

import com.bootcamp.calculadora_calorias.model.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {
    @Autowired
    private IIngredienteRepository ingredienteRepository;

    private List<Plato> platos;

    private void generarPlatosMenu() {
        this.platos = List.of(
                new Plato("Hamburguesa con espinacas",
                        List.of(
                                ingredienteRepository.obtenerIngredientePorNombre("Hamburguesa").get(),
                                ingredienteRepository.obtenerIngredientePorNombre("Espinaca").get(),
                                ingredienteRepository.obtenerIngredientePorNombre("Pan de trigo integral").get())),
                new Plato("Ensalada con pollo",
                        List.of(
                                ingredienteRepository.obtenerIngredientePorNombre("Lechuga").get(),
                                ingredienteRepository.obtenerIngredientePorNombre("Tomates").get(),
                                ingredienteRepository.obtenerIngredientePorNombre("Pollo").get(),
                                ingredienteRepository.obtenerIngredientePorNombre("Pimiento").get())),
                new Plato("Pastel de manzana y moras",
                        List.of(
                                ingredienteRepository.obtenerIngredientePorNombre("Pastel de manzana").get(),
                                ingredienteRepository.obtenerIngredientePorNombre("Mora").get()))
        );
    }

    @Override
    public Optional<Plato> obtenerPlato(String nombre) {
        if(platos == null)
            generarPlatosMenu();

        return platos.stream().filter(plato -> plato.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }
}
