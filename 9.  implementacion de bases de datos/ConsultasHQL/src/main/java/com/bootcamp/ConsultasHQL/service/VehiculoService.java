package com.bootcamp.ConsultasHQL.service;

import com.bootcamp.ConsultasHQL.dto.request.VehiculoResquestDTO;
import com.bootcamp.ConsultasHQL.dto.response.VehiculoResponseDTO;
import com.bootcamp.ConsultasHQL.model.Vehiculo;
import com.bootcamp.ConsultasHQL.model.template.PatenteMarcaDeVehiculoTemplate;
import com.bootcamp.ConsultasHQL.model.template.PatenteMarcaModeloDeVehiculoTemplate;
import com.bootcamp.ConsultasHQL.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService{
    private final IVehiculoRepository vehiculoRepository;
    ModelMapper mapper = new ModelMapper();

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public VehiculoResponseDTO create(VehiculoResquestDTO dto) {
        var entity = mapper.map(dto, Vehiculo.class);
        vehiculoRepository.save(entity);
        return mapper.map(entity, VehiculoResponseDTO.class);
    }
    @Override
    public List<String> findAllPatentes() {
        return vehiculoRepository.findAllPatentes();
    }
    @Override
    public List<PatenteMarcaDeVehiculoTemplate> findPatenteMarcaOrderByAnoFabricacion() {
        return vehiculoRepository.findPatenteMarcaOrderByAnoFabricacion();
    }

    @Override
    public List<String> findPatentesByRuedasYAno(Integer ruedas) {
        return vehiculoRepository.findPatentesByRuedasYAno(ruedas);
    }

    @Override
    public List<PatenteMarcaModeloDeVehiculoTemplate> findPatenteMarcaModeloBySiniestro() {
        return vehiculoRepository.findPatenteMarcaModeloBySiniestro();
    }
}
