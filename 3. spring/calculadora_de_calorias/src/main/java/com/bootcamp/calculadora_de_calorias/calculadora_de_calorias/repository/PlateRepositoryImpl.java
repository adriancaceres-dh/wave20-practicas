package com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.repository;

import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.dto.IngredientDTO;
import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.dto.PlateDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PlateRepositoryImpl implements PlateRepositoryI{
    private List<PlateDTO> plates;

    @Override
    public List<PlateDTO> getPlates() {
        return plates;
    }



    public PlateRepositoryImpl(List<PlateDTO> plates) {
        this.plates = plates;
    }

    //private PlateRepositoryImpl() {
    //    this.plates = loadDefaultPlates();
    //}

    public void setPlates(List<PlateDTO> plates) {
        this.plates = plates;
    }
    //private List<PlateDTO> loadDefaultPlates(){
    //    PlateDTO plate = new PlateDTO("");
    //}
}
