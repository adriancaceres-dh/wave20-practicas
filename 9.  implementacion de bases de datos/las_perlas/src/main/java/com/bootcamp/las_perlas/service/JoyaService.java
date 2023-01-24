package com.bootcamp.las_perlas.service;

import com.bootcamp.las_perlas.dto.JoyaConIdDTO;
import com.bootcamp.las_perlas.dto.JoyaDTO;
import com.bootcamp.las_perlas.repository.IJoyaRepository;
import com.bootcamp.las_perlas.util.mapper.IJoyaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    private IJoyaRepository joyaRepository;
    private IJoyaMapper joyaMapper;

    public JoyaService(IJoyaRepository joyaRepository, IJoyaMapper joyaMapper) {
        this.joyaRepository = joyaRepository;
        this.joyaMapper = joyaMapper;
    }

    @Override
    public JoyaConIdDTO crear(JoyaDTO joyaDTO) {
        var joya = joyaMapper.fromDTO(joyaDTO);
        joya.setVentaONo(true);
        var joyaConId = joyaRepository.save(joya);
        return joyaMapper.toDTO(joyaConId);
    }

    @Override
    public List<JoyaConIdDTO> listarEnVenta() {
        return joyaRepository.findByVentaONo(true).stream()
                .map(joyaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JoyaConIdDTO darDeBaja(Long id) {
        var joyaAEliminar = joyaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la joya a eliminar."));
        joyaAEliminar.setVentaONo(false);
        joyaRepository.save(joyaAEliminar);
        return joyaMapper.toDTO(joyaAEliminar);
    }

    @Override
    public JoyaConIdDTO actualizar(Long id, JoyaDTO joyaDTO) {
        if (!joyaRepository.existsById(id)){
            throw new RuntimeException("Se intento modificar una joya inexistente.");
        }
        var joyaActualizada = joyaMapper.fromDTO(joyaDTO);
        joyaActualizada.setNumeroIdentificatorio(id);
        joyaActualizada.setVentaONo(true);
        return joyaMapper.toDTO(joyaRepository.save(joyaActualizada));
    }
}
