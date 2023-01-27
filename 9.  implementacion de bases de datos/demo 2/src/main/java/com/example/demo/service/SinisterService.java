package com.example.demo.service;

import com.example.demo.dto.MessageDto;
import com.example.demo.dto.SinisterDto;
import com.example.demo.dto.VehicleDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Sinister;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.ISinisterRepository;
import com.example.demo.repository.IVehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SinisterService implements ISinisterService{

    @Autowired
    ISinisterRepository sinisterRepository;

    @Autowired
    IVehicleRepository vehicleRepository;

    ModelMapper mapper = new ModelMapper();


    @Override
    public SinisterDto saveEntity(SinisterDto dto) {
        Sinister sinister = mapper.map(dto, Sinister.class);
        sinister.setEliminado(false);
        //Por lógica de negocio, se registra primero el vehiculo y luego el siniestro.
        //No se puede ingresar un siniestro para un vehiculo no registrado, por ende, puedo recuperar el vehiculo.
        Vehicle vehicle = vehicleRepository.findById(dto.getVehiculo()).get();
        sinister.setVehicle(vehicle);
        Sinister saveSinister = sinisterRepository.save(sinister);
        //Le seteo el siniestro ingresado al vehiculo correspondiente.
        List<Sinister> sinisters = new ArrayList<>();
        sinisters.add(sinister);
        vehicle.setSinisters(sinisters);
        //Retorno el siniestro registrado
        dto.setId(saveSinister.getId());
        return dto;
    }

    @Override
    public SinisterDto getEntityById(Integer id) throws NotFoundException {
        Optional<Sinister> sinister = sinisterRepository.findById(id);
        if (!sinister.isPresent())
            throw new NotFoundException(new MessageDto(404, "No se encontró el recurso solicitado"));
        return mapper.map(sinister.get(), SinisterDto.class);
    }

    @Override
    public List<SinisterDto> getAllEntities() {
        List<Sinister> sinisters = sinisterRepository.findAll();
        return sinisters.stream().map(s -> mapper.map(s, SinisterDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MessageDto deleteEntity(Integer id) {
        Optional<Sinister> sinister = sinisterRepository.findById(id);
        if (sinister.isPresent() && sinister.get().isEliminado())
            return new MessageDto(400, "El recurso no existe");
        sinisterRepository.logicDelete(id);
        return new MessageDto(200, "El recurso fue eliminado con exito");
    }


    public List<SinisterDto> getEntityByFecha(LocalDateTime fecha) {
        List<Sinister> sinisters = sinisterRepository.findByFecha(fecha);
        return sinisters.stream().map(s -> mapper.map(s, SinisterDto.class)).collect(Collectors.toList());
    }
}
