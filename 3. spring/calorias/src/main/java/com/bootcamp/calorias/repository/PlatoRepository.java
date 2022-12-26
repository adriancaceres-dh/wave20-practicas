package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.model.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepository {
    private IngredienteRepository ingredienteRepository;
    private List<Plato> platos;

    public PlatoRepository() {
        platos = new ArrayList<>();
        ingredienteRepository = new IngredienteRepository();
        Plato fideosConTuco = new Plato("Fideos con tuco", new ArrayList<>());
        fideosConTuco.addIngrediente(ingredienteRepository.findByName("Harina de trigo refinada"));
        fideosConTuco.addIngrediente(ingredienteRepository.findByName("Salsa de tomate en conserva"));
        fideosConTuco.addIngrediente(ingredienteRepository.findByName("Aceite de oliva"));

        Plato ensaladita = new Plato("Ensalada de vegetales", new ArrayList<>());
        ensaladita.addIngrediente(ingredienteRepository.findByName("Rúcula"));
        ensaladita.addIngrediente(ingredienteRepository.findByName("Tomates"));
        ensaladita.addIngrediente(ingredienteRepository.findByName("Aceite de oliva"));

        platos.add(fideosConTuco);
        platos.add(ensaladita);
    }

    public Plato findByName(String name) {
        Optional<Plato> maybePlato = platos.stream()
                .filter(plato -> plato.getName().equals(name))
                .findFirst();
        return maybePlato.orElse(null);
    }
}
