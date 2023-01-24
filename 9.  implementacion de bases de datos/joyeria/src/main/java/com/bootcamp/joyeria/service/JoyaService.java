package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.request.JoyaRequestDTO;
import com.bootcamp.joyeria.dto.response.JoyaResponseDTO;
import com.bootcamp.joyeria.mapper.JoyaMapper;
import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{
    private final IJoyaRepository joyaRepository;
    private final JoyaMapper joyaMapper;

    public JoyaService(IJoyaRepository joyaRepository, JoyaMapper joyaMapper) {
        this.joyaRepository = joyaRepository;
        this.joyaMapper = joyaMapper;
    }

    @Override
    public JoyaResponseDTO save(JoyaRequestDTO dto) {
        Joya joya = joyaMapper.dto2Entity(dto);
        joyaRepository.save(joya);
        return joyaMapper.entity2DTO(joya);
    }

    @Override
    public JoyaResponseDTO findById(Long id) {
        Optional<Joya> joya = Optional.ofNullable(joyaRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("No se encontro una joya con el id " + id);
                }
        ));
        return joyaMapper.entity2DTO(joya.get());
    }

    @Override
    public List<JoyaResponseDTO> findAll() {
        return joyaRepository.findAll().stream().map(joyaMapper::entity2DTO).collect(Collectors.toList());
    }

    @Override
    public String delete(Long id) {
        Optional<Joya> joya = Optional.ofNullable(joyaRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("No se encontro una joya con el id " + id);
                }
        ));
        joyaRepository.delete(joya.get());
        return "Se elimino la joya con id " + id;
    }

    @Override
    public String update(Long id, JoyaRequestDTO dto) {
        Optional<Joya> joya = Optional.ofNullable(joyaRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("No se encontro una joya con el id " + id);
                }
        ));
        Joya joyaToUpdate = joya.get();
        joyaToUpdate.setNombre(dto.getNombre());
        joyaToUpdate.setMaterial(dto.getMaterial());
        joyaToUpdate.setPeso(dto.getPeso());
        joyaToUpdate.setParticularidad(dto.getParticularidad());
        joyaToUpdate.setPoseePiedra(dto.isPoseePiedra());
        joyaToUpdate.setVentaONo(dto.isVentaONo());
        joyaRepository.save(joyaToUpdate);
        return "Se modifico la joya con id " + id;
    }
}
