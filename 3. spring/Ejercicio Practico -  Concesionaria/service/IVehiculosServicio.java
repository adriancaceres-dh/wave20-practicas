package com.bootcamp.prueba.services;


import com.bootcamp.prueba.models.Auto;
import com.bootcamp.prueba.models.AutoDTO;

import java.util.Date;
import java.util.List;

public interface IVehiculosServicio {

    boolean addAuto(Auto auto);

    List<AutoDTO> getAutos();

    List<Auto> getAutosEntreFechas(Date desde, Date hasta);

    List<Auto> getAutosEntrePrecios(Double desde, Double hasta);

    Auto getCar(int id);
}
