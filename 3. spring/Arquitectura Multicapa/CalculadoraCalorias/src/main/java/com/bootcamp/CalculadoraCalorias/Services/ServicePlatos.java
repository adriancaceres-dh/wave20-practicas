package com.bootcamp.CalculadoraCalorias.Services;

import com.bootcamp.CalculadoraCalorias.DTO.IngredienteDto;
import com.bootcamp.CalculadoraCalorias.Models.Plato;
import com.bootcamp.CalculadoraCalorias.Models.Ingrediente;
import com.bootcamp.CalculadoraCalorias.Repositories.RepositorioPlatos;
import com.bootcamp.CalculadoraCalorias.Repositories.RespositorioIngredientes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePlatos implements IServiciePlatos {
    @Autowired
    public RepositorioPlatos platos;

    @Autowired
    public RespositorioIngredientes ingredientes;

    ModelMapper modelMaper = new ModelMapper();

    public int devolverCaloriasDelPlato(String nombrePlato) {
        Plato platoBuscado = platos.platos.stream().filter(x -> x.getNombre().equals(nombrePlato)).findAny().orElse(null);
        int calorias = 0;

        for (String ing : platoBuscado.getIngredientes()) {
            Ingrediente ingredienteActual = ingredientes.ingredientes.stream().filter(x -> x.getName().equals(ing)).findAny().orElse(null);
            if (ingredienteActual != null) {
                calorias += ingredienteActual.getCalories(); // Faltaría alguna forma de hacer el calculo de las calorias segun peso.
            }
        }

        return calorias;
    }

    public String devolverCaloriasEIngredientesDelPlato(String nombrePlato) {
        Plato platoBuscado = platos.platos.stream().filter(x -> x.getNombre().equals(nombrePlato)).findAny().orElse(null);
        StringBuilder ingredientesConCalorias = new StringBuilder();

        for (String ing : platoBuscado.getIngredientes()) {
            Ingrediente ingredienteActual = ingredientes.ingredientes.stream().filter(x -> x.getName().equals(ing)).findAny().orElse(null);
            if (ingredienteActual != null) {
                ingredientesConCalorias.append(modelMaper.map(ingredienteActual, IngredienteDto.class) + "\n");
            }
        }

        return ingredientesConCalorias.toString();
    }

    public IngredienteDto ingredienteMayorCaloria(String nombrePlato) {
        Plato platoBuscado = platos.platos.stream().filter(x -> x.getNombre().equals(nombrePlato)).findAny().orElse(null);
        Ingrediente mayorCalorias = new Ingrediente();

        for (String ing : platoBuscado.getIngredientes()) {
            Ingrediente ingredienteActual = ingredientes.ingredientes.stream().filter(x -> x.getName().equals(ing)).findAny().orElse(null);
            if (ingredienteActual != null && ingredienteActual.getCalories()>mayorCalorias.getCalories()) {
                mayorCalorias = ingredienteActual;
            }
        }

        return modelMaper.map(mayorCalorias, IngredienteDto.class);
    }
}
