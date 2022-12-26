package com.bootcamp.calculadora_calorias.repository;

import com.bootcamp.calculadora_calorias.model.Plato;
import lombok.NoArgsConstructor;
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

    public PlatoRepositoryImpl() {
        this.platos = new ArrayList<>();
    }

    private boolean obtenerPlatosMenu() {
        this.platos = List.of(
                new Plato("Hamburguesa con espinacas",
                        List.of(
                                ingredienteRepository.obtenerIngredientePorNombre("Hamburguesa").get(),
                                ingredienteRepository.obtenerIngredientePorNombre("Espinaca").get(),
                                ingredienteRepository.obtenerIngredientePorNombre("Pan de trigo integral").get()))
        );

        return true;
    }

    @Override
    public Optional<Plato> obtenerPlato(String nombre) {
        if(platos.isEmpty())
            obtenerPlatosMenu();

        return platos.stream().filter(plato -> plato.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }
}
