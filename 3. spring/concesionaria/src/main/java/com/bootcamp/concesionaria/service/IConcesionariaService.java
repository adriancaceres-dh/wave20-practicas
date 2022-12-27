package com.bootcamp.concesionaria.service;

import com.bootcamp.concesionaria.dto.VehiculoConServiceDTO;
import com.bootcamp.concesionaria.dto.VehiculoDTO;

import java.util.List;

public interface IConcesionariaService {
    VehiculoConServiceDTO getVehiculo(int id);
    void cargarVehiculo(VehiculoConServiceDTO vehiculoDTO);
    List<VehiculoDTO> getVehiculos();
    List<VehiculoDTO> getVehiculosPorFecha(String fechaDesde , String fechaHasta);
    List<VehiculoDTO> getVehiculosPorPrecio(int since , int to);
}
