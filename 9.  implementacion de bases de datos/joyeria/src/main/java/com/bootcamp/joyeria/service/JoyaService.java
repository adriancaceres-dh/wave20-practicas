package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dtos.JoyaDto;
import com.bootcamp.joyeria.entity.Joya;
import com.bootcamp.joyeria.repository.JoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    private final JoyaRepository joyaRepo;
    private ModelMapper mapper;

    public JoyaService(JoyaRepository joyaRepo, ModelMapper mapper) {
        this.joyaRepo = joyaRepo;
        this.mapper = mapper;
    }

    @Transactional (readOnly = true)
    public List<JoyaDto> getJoyas() {
        List<Joya> joyaList = joyaRepo.findAll();
        return null;
    }

    @Transactional
    public Long saveJoya(JoyaDto joyaDto) {
        Joya joya = mapper.map(joyaDto, Joya.class);
        return joyaRepo.save(joya).getNro_identificatorio();
    }

    @Transactional
    public boolean deleteJoya(Long id) {
        boolean deleted = findJoya(id) != null;
        joyaRepo.deleteById(id);
        return deleted;
    }

    @Transactional (readOnly = true)
    public Joya findJoya(Long id) {
        return joyaRepo.findById(id).orElse(null);
    }
}
