package com.bootcamp.calculadora_calorias.repository;

import com.bootcamp.calculadora_calorias.model.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {
    @Autowired
    private IIngredienteRepository ingredienteRepository;

    private final List<Plato> platos;

    public PlatoRepositoryImpl() {
        this.platos = List.of(
                new Plato("Hamburguesa con espinacas",
                        List.of(
                                ingredienteRepository.obtenerIngredientePorNombre("Hamburguesa").get(),
                                ingredienteRepository.obtenerIngredientePorNombre("Espinaca").get(),
                                ingredienteRepository.obtenerIngredientePorNombre("Pan de trigo integral").get()))
        );
    }

    @Override
    public Optional<Plato> obtenerPlato(String nombre) {
        return platos.stream().filter(plato -> plato.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }
}
