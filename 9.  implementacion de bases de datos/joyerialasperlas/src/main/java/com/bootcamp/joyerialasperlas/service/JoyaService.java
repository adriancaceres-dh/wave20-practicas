package com.bootcamp.joyerialasperlas.service;

import com.bootcamp.joyerialasperlas.dto.JoyaRequestDTO;
import com.bootcamp.joyerialasperlas.model.Joya;
import com.bootcamp.joyerialasperlas.repository.IJoyaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    private final IJoyaRepository joyaRepository;
    private ModelMapper mapper;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
        mapper = new ModelMapper();
    }

    @Override
    public Integer crearJoya(JoyaRequestDTO joya) {
        Joya joyaEntrada = mapper.map(joya, Joya.class);
        joyaEntrada.setVentaONo(true);
        joyaEntrada = joyaRepository.save(joyaEntrada);
        return joyaEntrada.getNro_identificatorio();
    }

    @Override
    public List<Joya> getAllJoyas() {
        return joyaRepository.getAll();
    }

    @Override
    public String deleteJoya(Integer id) {
        Joya joyaEliminada = joyaRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("No se encontró joya por ese id");
        });
        joyaEliminada.setVentaONo(false);
        joyaRepository.save(joyaEliminada);
        return "La eliminación fue de perlas";
    }

    @Override
    public Joya updateJoya(JoyaRequestDTO joya, Integer id) {

        Joya busqueda = joyaRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("No se encontró joya por ese id");
        });
        if(!busqueda.getVentaONo()) throw new RuntimeException("No se encontró joya por ese id");
        Joya joyaEntrada = mapper.map(joya, Joya.class);
        joyaEntrada.setNro_identificatorio(id);
        joyaEntrada.setVentaONo(true);
        joyaRepository.save(joyaEntrada);
        return joyaEntrada;
    }
}
