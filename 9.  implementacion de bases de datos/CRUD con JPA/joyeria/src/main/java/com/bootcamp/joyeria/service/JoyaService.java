package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.request.JoyaDTORequest;
import com.bootcamp.joyeria.dto.response.JoyaDTOResponse;
import com.bootcamp.joyeria.entity.Joya;
import com.bootcamp.joyeria.exception.NotFoundException;
import com.bootcamp.joyeria.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    @Autowired
    IJoyaRepository joyaRepository;

    private final ModelMapper mapper = new ModelMapper();

    public JoyaService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true);
    }

    @Override
    public JoyaDTOResponse addJewel(JoyaDTORequest joyaDTO) {
        Joya joya = mapper.map(joyaDTO, Joya.class);
        joya.setVentaONo(true);
        Joya joyaCreated = joyaRepository.save(joya);
        return mapper.map(joyaCreated, JoyaDTOResponse.class);
    }

    @Override
    public List<JoyaDTOResponse> getJewels() {
        return joyaRepository.findAll().stream().filter(x-> x.isVentaONo()).map(j -> mapper.map(j,JoyaDTOResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public JoyaDTOResponse updateJewel(JoyaDTORequest joyaDTO, Long id_modificar) {
        if (!joyaRepository.existsById(id_modificar)){
            throw new NotFoundException("Esa joya no existe");
        }
        Joya joya = mapper.map(joyaDTO, Joya.class);
        joya.setId(id_modificar);
        Joya joyaUpdated = joyaRepository.save(joya);
        return mapper.map(joyaUpdated, JoyaDTOResponse.class);
    }

    @Override
    public String deleteJewel(Long id) {
        if (!joyaRepository.existsById(id)){
            throw new NotFoundException("Esa joya no existe");
        }
        Joya joya = joyaRepository.findById(id).get();
        joya.setVentaONo(false);
        Joya joyaUpdated = joyaRepository.save(joya);
        return "La joya ha sido eliminada.";
    }
}
