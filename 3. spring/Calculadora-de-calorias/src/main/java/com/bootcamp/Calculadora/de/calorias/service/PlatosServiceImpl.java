package com.bootcamp.Calculadora.de.calorias.service;

import com.bootcamp.Calculadora.de.calorias.dto.PlatoDTO;
import com.bootcamp.Calculadora.de.calorias.model.Plato;
import com.bootcamp.Calculadora.de.calorias.repository.PlatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatosServiceImpl implements IPlatosService {
    @Autowired
    PlatosRepository platosRepository;
    @Override
    public PlatoDTO platos(String nombre, String peso) {

       Plato p = platosRepository.platos().stream().filter(x->x.getNombrePlato().equals(nombre)).findFirst().get();

       PlatoDTO pDTO = PlatoDTO.builder().ingredientes(p.getIngredientes())
               .cantidadTotalCalorias(p.cantidadTotalCalorias(peso)).conMasCalorias(p.mayorCalorias()).build();

        return pDTO;
    }
}
