package com.bootcamp.vehiculos.service;

import com.bootcamp.vehiculos.dto.VehiculoDTO;
import com.bootcamp.vehiculos.model.template.PatenteMarcaModelo;
import com.bootcamp.vehiculos.model.template.PatenteYMarca;
import com.bootcamp.vehiculos.model.template.VehiculoPerdida;
import com.bootcamp.vehiculos.repository.IVehiculoPerdidaRepository;
import com.bootcamp.vehiculos.repository.IVehiculoRepository;
import com.bootcamp.vehiculos.util.VehiculoModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    private final IVehiculoRepository vehiculoRepository;
    private final IVehiculoPerdidaRepository vehiculoPerdidaRepository;
    private final VehiculoModelMapper vehiculoModelMapper;

    public VehiculoService(IVehiculoRepository vehiculoRepository, IVehiculoPerdidaRepository vehiculoPerdidaRepository, VehiculoModelMapper vehiculoModelMapper) {
        this.vehiculoRepository = vehiculoRepository;
        this.vehiculoPerdidaRepository = vehiculoPerdidaRepository;
        this.vehiculoModelMapper = vehiculoModelMapper;
    }

    public List<String> listarPatentes() {
        return vehiculoRepository.listPatentes();
    }

    public List<PatenteYMarca> listarPatentesYMarcasPorAnio() {
        return vehiculoRepository.listPatenteYMarcaOrderByAnioFabricacion();
    }

    public List<String> listarPatentesDeVehiculosNuevosConMasDe4Ruedas() {
        return vehiculoRepository.listPatentesOfFourWheeledFromCurrentYear();
    }

    public List<PatenteMarcaModelo> listarPatenteMarcaModeloDeVehiculosConSiniestroConGranPerdida() {
        return vehiculoRepository.listPatenteMarcaModeloByGranPerdidaEconomica();
    }

    public List<VehiculoPerdida> listarVehiculosYPerdidaParaVehiculosConGrandesSiniestros() {
        var vehiculoPerdida = vehiculoRepository.listVehiculoPerdida();
        vehiculoPerdidaRepository.saveAll(vehiculoPerdida);
        return vehiculoPerdida;
    }

    public VehiculoDTO crearVehiculo(VehiculoDTO vehiculoDTO) {
        var vehiculo = vehiculoModelMapper.fromDTO(vehiculoDTO);
        vehiculo = vehiculoRepository.save(vehiculo);
        return vehiculoModelMapper.toDTO(vehiculo);
    }
}
