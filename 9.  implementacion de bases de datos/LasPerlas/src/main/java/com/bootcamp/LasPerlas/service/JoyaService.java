package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.request.CompleteJoyaRequestDTO;
import com.bootcamp.LasPerlas.dto.request.JoyaRequestDto;
import com.bootcamp.LasPerlas.dto.response.JoyaResponseDto;
import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    @Autowired
    private IJoyaRepository joyaRepository;
    private ModelMapper mapper;
    public JoyaService (){
        this.mapper = new ModelMapper();
    }
    @Override
    @Transactional(readOnly = true)
    public Joya findJoya(Long id) {
        return this.joyaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JoyaResponseDto> getJoyas() {
        List <JoyaResponseDto> joyas = new ArrayList<>();
        joyas.addAll(this.joyaRepository.findAll()
                        .stream().map(objeto -> mapper.map(objeto, JoyaResponseDto.class))
                        .filter(joya -> joya.isVentaONo())
                        .collect(Collectors.toList()));
        return joyas;
    }

    @Override
    @Transactional
    public void disableJoya(Long id) {
        Joya joya = this.joyaRepository.findById(id).orElse(null);
        joya.setVentaONo(false);
        this.joyaRepository.save(joya);
    }

    @Override
    @Transactional
    public Long saveJoya(JoyaRequestDto joya) {
        Joya newJoya = this.mapper.map(joya,Joya.class);
        if (!newJoya.isVentaONo()) newJoya.setVentaONo(true);

        Long id =this.joyaRepository.save(newJoya).getId();

        return id;
    }

    @Override
    @Transactional
    public JoyaResponseDto editJoya(Long id, JoyaRequestDto joya) {

        Joya oldJoya = this.joyaRepository.findById(id).orElse(null);

        oldJoya.setNombre(joya.getNombre());
        oldJoya.setPeso(joya.getPeso());
        oldJoya.setMaterial(joya.getMaterial());
        oldJoya.setParticularidad(joya.getParticularidad());
        oldJoya.setVentaONo(joya.isVentaONo());
        oldJoya.setPoseePiedra(joya.isPoseePiedra());

        oldJoya = this.joyaRepository.save(oldJoya);
        JoyaResponseDto editedJoya = this.mapper.map(oldJoya,JoyaResponseDto.class);

        return editedJoya;
    }
}
