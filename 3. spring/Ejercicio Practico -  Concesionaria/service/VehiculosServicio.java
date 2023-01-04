package com.bootcamp.prueba.services;

import com.bootcamp.prueba.models.Auto;
import com.bootcamp.prueba.models.AutoDTO;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehiculosServicio implements IVehiculosServicio {

    private Map<Integer, Auto> autos = new HashMap<>();
    private int id;

    public boolean addAuto(Auto auto) {
        this.autos.put(id, auto);
        this.id += 1;
        return true;
    }

    public List<AutoDTO> getAutos() {
        return autos.values().stream().map(this::convertidorAutoDTO).collect(Collectors.toList());
    }

    @Override
    public List<Auto> getAutosEntreFechas(Date desde, Date hasta) {
        return autos.values().stream().map(auto -> {
            if (auto.getManufacturingDate().after(desde) && auto.getManufacturingDate().before(hasta)) {
                return auto;
            }
            return null;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Auto> getAutosEntrePrecios(Double desde, Double hasta) {
        return autos.values().stream().map(auto -> {
            if (auto.getPrice() >= desde && auto.getPrice() <= hasta) {
                return auto;
            }
            return null;
        }).collect(Collectors.toList());
    }

    @Override
    public Auto getCar(int id) {
        return autos.get(id);
    }


    private AutoDTO convertidorAutoDTO(Auto auto) {
        return AutoDTO.builder()
                .brand(auto.getBrand())
                .currency(auto.getCurrency())
                .doors(auto.getDoors())
                .model(auto.getModel())
                .countOfOwners(auto.getCountOfOwners())
                .manufacturingDate(auto.getManufacturingDate())
                .numberOfKilometers(auto.getNumberOfKilometers())
                .price(auto.getPrice())
                .build();
    }
}
