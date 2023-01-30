package com.HQLAutos.HQLAutos.service;

import com.HQLAutos.HQLAutos.DTO.MarcaYPatenteDTO;
import com.HQLAutos.HQLAutos.DTO.MatriculaMarcaYModeloDTO;
import com.HQLAutos.HQLAutos.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    public List<String> getPatentes();

    public String createVehiculo(Vehiculo vehiculo);
    public List<MarcaYPatenteDTO> getMarcaYPatente();
    public List<String> getPatentesVehiculos4RuedasYFechaActual();
    public List<MatriculaMarcaYModeloDTO> getVehiculosPerdidaMayorA10000();
}
