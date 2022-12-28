package com.bootcamp.CalculadoraCalorias.service;

import com.bootcamp.CalculadoraCalorias.dto.IngredienteDTO;
import com.bootcamp.CalculadoraCalorias.dto.PlatoDTO;
import com.bootcamp.CalculadoraCalorias.model.Ingrediente;
import com.bootcamp.CalculadoraCalorias.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlatoServiceImpl implements PlatoService{

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public Double calcularCaloriasPorPlato (PlatoDTO platoDTO){
        Integer calorias = 0;
        for (String ingrediente : platoDTO.getIngredientes()){
            Ingrediente base = ingredienteRepository.getIngrediente(ingrediente);
            calorias += base.getCalories();
        }
        return calorias*platoDTO.getPeso();
    }
    public Set<String> informacionPlato (PlatoDTO platoDTO){
        Set<String> datos = new HashSet<>();
        for (String ingrediente : platoDTO.getIngredientes()){
            Ingrediente base = ingredienteRepository.getIngrediente(ingrediente);
            datos.add(base.getName() + " - " + base.getCalories() + " calorias");
        }
        return datos;
    }

    public List<IngredienteDTO> masCalorico(PlatoDTO platoDTO){
        List<Ingrediente> ingredientes = new ArrayList<>();
        if (platoDTO.getIngredientes().isEmpty()) System.out.println("No hay ingredientes");
        for (String ingrediente : platoDTO.getIngredientes()){
            ingredientes.add(ingredienteRepository.getIngrediente(ingrediente));
        }
        List<Ingrediente> lista = new ArrayList<>();
        Integer calorias = 0;
        for (Ingrediente ingrediente : ingredientes){
            if (ingrediente.getCalories() > calorias){
                lista.add(ingrediente);
                calorias = ingrediente.getCalories();
            }
        }
        for (Ingrediente ingrediente : lista){
            if (ingrediente.getCalories() < calorias){
                lista.remove(ingrediente);
            }
        }
        return lista.stream().map(ingrediente -> new IngredienteDTO(ingrediente.getName(),ingrediente.getCalories())).collect(Collectors.toList());
    }

    public List<String> completo (List<PlatoDTO> listaPlatos){
        if (listaPlatos.isEmpty()){
            System.out.println("No hay platos");
        }
        List<String> resultado = new ArrayList<>();
        for (PlatoDTO platoDTO : listaPlatos){
            resultado.add(platoDTO.getNombre() + " -> {Calorias totales: " + this.calcularCaloriasPorPlato(platoDTO) + " / " + this.informacionPlato(platoDTO)
                    + " / " + "Ingrediente mas calorico: " + this.masCalorico(platoDTO) + "}");
        }
        return resultado;
    }

}
