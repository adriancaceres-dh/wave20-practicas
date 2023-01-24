package com.bootcamp.joyeria.mapper;

import com.bootcamp.joyeria.dto.request.JoyaRequestDTO;
import com.bootcamp.joyeria.dto.response.JoyaResponseDTO;
import com.bootcamp.joyeria.model.Joya;
import org.springframework.stereotype.Component;

@Component
public class JoyaMapper {
    public Joya dto2Entity(JoyaRequestDTO dto){
        Joya joya = new Joya();
        joya.setNombre(dto.getNombre());
        joya.setMaterial(dto.getMaterial());
        joya.setPeso(dto.getPeso());
        joya.setParticularidad(dto.getParticularidad());
        joya.setPoseePiedra(dto.isPoseePiedra());
        joya.setVentaONo(dto.isVentaONo());
        return joya;
    }
    public JoyaResponseDTO entity2DTO(Joya entity){
        JoyaResponseDTO dto = new JoyaResponseDTO();
        dto.setNombre(entity.getNombre());
        dto.setMaterial(entity.getMaterial());
        dto.setPeso(entity.getPeso());
        dto.setParticularidad(entity.getParticularidad());
        dto.setPoseePiedra(entity.isPoseePiedra());
        return dto;
    }
}
