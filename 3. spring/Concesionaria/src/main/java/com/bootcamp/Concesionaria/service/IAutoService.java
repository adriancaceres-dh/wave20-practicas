package com.bootcamp.Concesionaria.service;

import com.bootcamp.Concesionaria.model.Automovil;

import java.util.List;

public interface IAutoService {

    public List<Automovil> obtenerListaAutos ();

    public Automovil obtenerAutoPorId(String id);

    public List<Automovil> obtenerPorFecha(String since, String to);

    public List<Automovil> obtenerPorPrice(String since, String to);

    public String guardarAuto(Automovil automovil);
}
