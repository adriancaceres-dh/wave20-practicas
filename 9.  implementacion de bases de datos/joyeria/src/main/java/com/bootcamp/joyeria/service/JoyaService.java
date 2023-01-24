package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dtos.JoyaResponseDto;
import com.bootcamp.joyeria.entity.Joya;
import com.bootcamp.joyeria.repository.JoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    private final JoyaRepository joyaRepo;

    public JoyaService(JoyaRepository joyaRepo) {
        this.joyaRepo = joyaRepo;
    }

    public List<JoyaResponseDto> getJoyas() {
        return null;
    }

    public void saveJoya(Joya joya) {

    }

    public boolean deleteJoya(Long id) {
        return false;
    }

    public Joya findJoya(Long id) {
        return null;
    }
}
