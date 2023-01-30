package com.HQLAutos.HQLAutos.service;

import com.HQLAutos.HQLAutos.DTO.MarcaYPatenteDTO;
import com.HQLAutos.HQLAutos.DTO.MatriculaMarcaYModeloDTO;
import com.HQLAutos.HQLAutos.model.Vehiculo;
import com.HQLAutos.HQLAutos.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {
    @Autowired
    IVehiculoRepository vehiculoRepository;
    @Override
    public List<String> getPatentes() {
        return vehiculoRepository.getPatente();
    }

    @Override
    public String createVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
        return "vehiculo creado";
    }

    @Override
    public List<MarcaYPatenteDTO> getMarcaYPatente() {
        return vehiculoRepository.getMarcaYPatente();
    }

    @Override
    public List<String> getPatentesVehiculos4RuedasYFechaActual() {
        return vehiculoRepository.getPatentesVehiculos4Ruedas();
    }

    @Override
    public List<MatriculaMarcaYModeloDTO> getVehiculosPerdidaMayorA10000() {
        return vehiculoRepository.getVehiculosPerdidaMayorA10000();
    }
}
