package com.bootcamp.siniestrovehiculo.service.interfaces;

import com.bootcamp.siniestrovehiculo.dto.VehiculoDTO;
import com.bootcamp.siniestrovehiculo.entity.templates.VehiculoSiniestroExtendidoTemplate;
import com.bootcamp.siniestrovehiculo.entity.templates.VehiculoSiniestroTemplate;
import com.bootcamp.siniestrovehiculo.service.interfaces.generics.ICrudService;

import java.util.List;

public interface IVehiculoService extends ICrudService<VehiculoDTO, Long> {

    // Listar las patentes de todos los vehículos registrados.
    List<String> getPatentesVehiculo();

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    List<VehiculoSiniestroTemplate> getVehiculosSiniestroOrderByFabricacion();

    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    List<String> getPatentesVehiculoCon4RuedasActual();

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    List<VehiculoSiniestroTemplate> getVehiculosSiniestroConPerdidas10000();

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos
    // y mostrar a cuánto ascendió la pérdida total de todos ellos.
    List<VehiculoSiniestroExtendidoTemplate> getVehiculosSiniestroTotalPerdidas();

}
