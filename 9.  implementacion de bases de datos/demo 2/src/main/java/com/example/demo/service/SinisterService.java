package com.example.demo.service;

import com.example.demo.dto.MessageDto;
import com.example.demo.dto.SinisterDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Sinister;
import com.example.demo.repository.ISinisterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SinisterService implements ISinisterService{

    @Autowired
    ISinisterRepository sinisterRepository;

    ModelMapper mapper = new ModelMapper();


    @Override
    public SinisterDto saveEntity(SinisterDto dto) {
        Sinister sinister = mapper.map(dto, Sinister.class);
        sinister.setEliminado(false);
        return mapper.map(sinisterRepository.save(sinister), SinisterDto.class);
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
    public MessageDto deleteEntity(Integer id) {
        Optional<Sinister> sinister = sinisterRepository.findById(id);
        if (sinister.isPresent() && sinister.get().isEliminado())
            return new MessageDto(400, "El recurso no existe");
        sinisterRepository.logicDelete(id);
        return new MessageDto(200, "El recurso fue eliminado con exito");
    }
}
