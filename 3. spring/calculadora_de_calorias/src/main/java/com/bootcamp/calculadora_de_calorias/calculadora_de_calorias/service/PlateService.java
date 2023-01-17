package com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.service;

import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.dto.PlateDTO;
import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.repository.PlateRepositoryI;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlateService {
    private final PlateRepositoryI plateRepositoryI;

    public PlateService(PlateRepositoryI plateRepositoryI) {
        this.plateRepositoryI = plateRepositoryI;
    }

    public List<PlateDTO> getPlates(){
        return plateRepositoryI.getPlates();
    }
}
