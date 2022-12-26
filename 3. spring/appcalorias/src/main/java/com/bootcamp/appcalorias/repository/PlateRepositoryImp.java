package com.bootcamp.appcalorias.repository;

import com.bootcamp.appcalorias.model.Ingredient;
import com.bootcamp.appcalorias.model.Plate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlateRepositoryImp implements IPlateRepository {

    List<Plate> plateList;

    public PlateRepositoryImp() {
        plateList = new ArrayList<>();
        List<Ingredient> ingredientList1 = List.of(new Ingredient("Atún fresco",225),
                new Ingredient("Papas cocidas",86));
        plateList.add(new Plate("Sudado",ingredientList1));
        List<Ingredient> ingredientList2 = List.of(new Ingredient("Pollo, Muslo",186),
                new Ingredient("Mantequilla",752));
        plateList.add(new Plate("Ajiaco",ingredientList2));
        List<Ingredient> ingredientList3 = List.of(new Ingredient("Merluza",86),
                new Ingredient("Bacalao seco", 322));
        plateList.add(new Plate("Sancocho",ingredientList3));
    }

    @Override
    public int calculateCalories(String plateName) {
        Plate plateFound = getPlate(plateName);

        List<Ingredient> plateIngredients = plateFound.getIngredients();
        return plateIngredients.stream().mapToInt(Ingredient::getCalories).sum();
    }
    @Override
    public Plate getPlate(String plateName){
        return plateList.stream().filter(plate ->  plate.getName().equals(plateName))
                .findFirst().get();
    }
}
