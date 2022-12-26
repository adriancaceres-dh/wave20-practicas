package com.example.calorias.service;

import com.example.calorias.dto.IngredienteDto;
import com.example.calorias.dto.PlatoDto;
import com.example.calorias.dto.PlatoNombrePesoDto;
import com.example.calorias.model.Plato;
import com.example.calorias.repository.PlatoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoServiceImpl implements PlatoServiceInterface {

    private final PlatoRepositoryInterface platoRepository;

    @Autowired
    public PlatoServiceImpl(PlatoRepositoryInterface platoRepository) {
        this.platoRepository = platoRepository;
    }

    @Override
    public PlatoDto getPlatoByNameAndWeight(String nombre, int weight) {
        Plato plato = platoRepository.getPlatoByName(nombre);

        if (plato == null) {
            return null;
        }

        int caloriasTotales = weight * plato.getCaloriasPorGramo();

        List<IngredienteDto> ingredientesDtoList = plato.getIngredientes().stream()
                .map(i -> new IngredienteDto(i.getNombre(), i.getCalorias()))
                .collect(Collectors.toList());

        return new PlatoDto(caloriasTotales, ingredientesDtoList, getMostCaloricIngredient(ingredientesDtoList));
    }

    @Override
    public List<PlatoDto> getPlatosByNamesAndWeights(List<PlatoNombrePesoDto> platos) {
        return platos.stream()
                .map(p -> getPlatoByNameAndWeight(p.getNombre(), p.getPeso()))
                .collect(Collectors.toList());
    }


    private IngredienteDto getMostCaloricIngredient(List<IngredienteDto> ingredienteDtos) {
        return ingredienteDtos.stream()
                .max(Comparator.comparingInt(IngredienteDto::getCantidadPorGramo))
                .get();
    }
}
