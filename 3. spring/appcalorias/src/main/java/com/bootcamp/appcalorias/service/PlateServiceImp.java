package com.bootcamp.appcalorias.service;

import com.bootcamp.appcalorias.dto.IngredientDto;
import com.bootcamp.appcalorias.dto.PlateDto;
import com.bootcamp.appcalorias.model.Ingredient;
import com.bootcamp.appcalorias.model.Plate;
import com.bootcamp.appcalorias.repository.IIngredientRepository;
import com.bootcamp.appcalorias.repository.IPlateRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlateServiceImp implements IPlateService {
    @Autowired
    IPlateRepository plateRepositoryImp;
    @Autowired
    IIngredientRepository ingredientRepositoryImp;

    private final ModelMapper mapper = new ModelMapper();
    public PlateServiceImp(){
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    public PlateDto calculatePlate(String plateName){
        PlateDto plateDto = new PlateDto();
        plateDto.setName(plateName);
        plateDto.setTotalCalories(plateRepositoryImp.calculateCalories(plateName));
        List<Ingredient> plateIngredients = plateRepositoryImp.getPlate(plateName).getIngredients();
        Ingredient mostCaloricIngredient = ingredientRepositoryImp.mostCalories(plateIngredients);
        plateDto.setMostCaloriesIngridient(new IngredientDto(mostCaloricIngredient.getName(),mostCaloricIngredient.getCalories()));
        plateDto.setIngredientList(plateIngredients.stream().map(personaje -> mapper.map(personaje,IngredientDto.class))
                .collect(Collectors.toList()));
        return plateDto;

    }

    public List<PlateDto> calculatePlates(List<Plate> plateList){
        return plateList.stream().map(plate -> calculatePlate(plate.getName())).collect(Collectors.toList());
    }

    public Ingredient getIngredient(int index){
        return ingredientRepositoryImp.getIngredient(index);
    }


}
