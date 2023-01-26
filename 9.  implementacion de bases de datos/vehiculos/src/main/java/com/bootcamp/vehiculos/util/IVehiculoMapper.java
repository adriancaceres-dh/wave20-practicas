package com.bootcamp.vehiculos.util;

import com.bootcamp.vehiculos.dto.VehiculoDTO;
import com.bootcamp.vehiculos.model.Vehiculo;

public interface IVehiculoMapper {
    VehiculoDTO toDTO(Vehiculo vehiculo);

    Vehiculo fromDTO(VehiculoDTO vehiculoDTO);
}
