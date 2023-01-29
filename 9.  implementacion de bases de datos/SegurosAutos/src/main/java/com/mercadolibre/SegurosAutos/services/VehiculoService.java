package com.mercadolibre.SegurosAutos.services;

import com.mercadolibre.SegurosAutos.models.Vehiculo;
import com.mercadolibre.SegurosAutos.repositories.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class VehiculoService  implements ICRUDServices<Vehiculo> {
    @Autowired
    IVehiculoRepository vehiculoRepository;

    public List<Map<String, String>> getMarcaYPatenteService() {

        return vehiculoRepository.getMarcaYPatente();

    }

    @Override
    public List<Vehiculo> getMarcaYPatenteServiceV2() {
        return vehiculoRepository.findAll();
    }

    public List<Map<String, String>> getMarcayPatenteByAnioFabricacionService() {
        return vehiculoRepository.getMarcayPatenteByAnioFabricacion();
    }

    @Override
    public List<Vehiculo> getVehiculoByRuedasYAnioService() {
        LocalDate fechaInicio = LocalDate.parse("2000-01-01", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate fechaFin = LocalDate.parse("2000-12-31", DateTimeFormatter.ISO_LOCAL_DATE);
        return vehiculoRepository.findVehiculosByCantidadRuedasGreaterThanAndAnioFabricacionAfter(4, fechaInicio);
    }

    @Override
    public List<Vehiculo> getBySiniestroService() {
        return vehiculoRepository.getBySiniestro();
    }

    @Override
    public List<Map<String, ?>> get4SQLService() {
        return vehiculoRepository.get4Sql();
    }
}



