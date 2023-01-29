package com.mercadolibre.SegurosAutos.services;


import com.mercadolibre.SegurosAutos.models.Vehiculo;

import java.util.List;
import java.util.Map;

public interface ICRUDServices <T>{

    public List<Map<String,String>> getMarcaYPatenteService();
    public List<Vehiculo> getMarcaYPatenteServiceV2();
    public List<Map<String,String>> getMarcayPatenteByAnioFabricacionService();
    public List<Vehiculo> getVehiculoByRuedasYAnioService();
    List<Vehiculo> getBySiniestroService();
    public List<Map<String, ?>> get4SQLService();





}
