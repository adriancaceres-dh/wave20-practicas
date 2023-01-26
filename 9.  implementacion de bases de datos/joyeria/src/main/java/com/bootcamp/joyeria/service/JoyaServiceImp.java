package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.JoyaDto;
import com.bootcamp.joyeria.dto.MessageDTO;
import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImp implements IJoyaService{
    private IJoyaRepository joyaRepo;
    public JoyaServiceImp(IJoyaRepository joyaRepo){
        this.joyaRepo = joyaRepo;
    }
    ModelMapper mapper = new ModelMapper();
    /*
    @Override
    public List<JoyaDto> getJoyas() {
        var list = joyaRepo.findAll();
           // List<JoyaDtoRes> joyaList = joyaRepo.findAll();
        return list.stream().map(

        );
    }

    @Override
    public JoyaDto saveJoya(JoyaDto joyaSave) {
        var joyaEntity = mapper.map(joyaSave, Joya.class);
        joyaEntity = joyaRepo.save(joyaEntity);
        return mapper.map(joyaEntity, JoyaDto.class);
    }

    @Override
    public Boolean deleteJoya(Long id) {
        return null;
    }

    @Override
    public JoyaDto findJoya(Long id) {
        return null;
    }


     */
    @Override
    public MessageDTO createEntity(JoyaDto joya) {
        if(joya.getNroIdentificatorio() != null)
            throw new RuntimeException("No se permite el envio de IDs");

        var entity = mapper.map(joya, Joya.class);
        entity = joyaRepo.save(entity);

        if(entity.getNroIdentificatorio() != null)
        return MessageDTO.builder()
                .message("Se creó una nueva joya")
                .action("CREATED")
                .build();
        else
            throw new RuntimeException("No se pudo crear la joya");
    }

    @Override
    public MessageDTO updateEntity(JoyaDto joyaDto) {
        if(!joyaRepo.existsById(joyaDto.getNroIdentificatorio()))
            throw new RuntimeException("No se permite el envio de IDs nulos o inexistentes para actualizar");

        var entity = mapper.map(joyaDto, Joya.class);
        entity = joyaRepo.save(entity);
        if(entity.getNroIdentificatorio() != null)
        return MessageDTO.builder()
                .message("Se modifico la joya " + joyaDto.getNroIdentificatorio())
                .status(200)
                .action("UPDATED")
                .build();
        else
            throw new RuntimeException("No se pudo modificar la joya");
    }


    @Override
    public List<JoyaDto> getAllEntities() {
        var list = joyaRepo.findAll();
        return list.stream().map(
                joya -> mapper.map(joya, JoyaDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteEntity(Long id) {
        return null;
    }
}
