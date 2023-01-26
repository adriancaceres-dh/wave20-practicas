package com.bootcamp.seguros.service.imple;

import com.bootcamp.seguros.dto.SinisterDTO;
import com.bootcamp.seguros.model.Sinister;
import com.bootcamp.seguros.model.Vehicle;
import com.bootcamp.seguros.repository.SinisterRepository;
import com.bootcamp.seguros.repository.VehicleRepository;
import com.bootcamp.seguros.service.ISinisterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SinisterServiceImpl implements ISinisterService {
    @Autowired
    private SinisterRepository sinisterRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    ModelMapper mapper = new ModelMapper();
    @Override
    public SinisterDTO createSinister(SinisterDTO sinisterDTO, Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        Sinister sinister = Sinister.builder()
                .fechaDelSiniestro(sinisterDTO.getFechaDelSiniestro())
                .perdidaEconomica(sinisterDTO.getPerdidaEconomica())
                .vehicle(vehicle)
                .build();
        sinisterRepository.save(sinister);
        return mapper.map(sinister, SinisterDTO.class);
    }
}
