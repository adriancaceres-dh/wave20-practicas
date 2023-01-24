package com.bootcamp.Joyeria.service;

import com.bootcamp.Joyeria.dto.MessageExceptionDTO;
import com.bootcamp.Joyeria.dto.request.JoyaRequestDTO;
import com.bootcamp.Joyeria.dto.response.JoyaResponseDTO;
import com.bootcamp.Joyeria.exceptions.JoyaNotFoundException;
import com.bootcamp.Joyeria.model.Joya;
import com.bootcamp.Joyeria.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{
    @Autowired
    IJoyaRepository iJoyaRepository;

    public Long createJoya(JoyaRequestDTO joyaRequestDTO){
        Joya joya = new Joya(null,joyaRequestDTO.getNombre(),joyaRequestDTO.getMaterial(),joyaRequestDTO.getPeso(),joyaRequestDTO.getParticularidad(),joyaRequestDTO.getPosee_piedra(),true);
        return iJoyaRepository.save(joya).getNro_identificatorio();
    }

    public List<JoyaResponseDTO> findAll(){
        List<Joya> joyas= iJoyaRepository.findAll().stream()
                .filter(Joya::getVentaONo)
                .collect(Collectors.toList());
        List<JoyaResponseDTO> responseDTOS = new ArrayList<>();
        joyas.stream().forEach(j->responseDTOS.add(new JoyaResponseDTO(j.getNombre(),j.getMaterial(),j.getParticularidad(),j.getPeso(),j.getPosee_piedra(),j.getVentaONo())));
        return responseDTOS;
    }

    public Boolean deleteById (Long id){
        Optional<Joya> joya = iJoyaRepository.findById(id);
        if (joya.isEmpty()){
            return false;
        }else{
            joya.get().setVentaONo(false);
            iJoyaRepository.save(joya.get());
            return true;
        }
    }

    public JoyaResponseDTO updateJoya(Long id, JoyaRequestDTO joyaRequestDTO){
        Optional<Joya> joya = iJoyaRepository.findById(id);
        if(joya.isEmpty()){
            throw new JoyaNotFoundException(new MessageExceptionDTO("No se encontro la joya a actualizar."));
        }else {
            Joya joyaModificada= new Joya(joya.get().getNro_identificatorio(),joyaRequestDTO.getNombre(),joyaRequestDTO.getMaterial(),joyaRequestDTO.getPeso(),joyaRequestDTO.getParticularidad(),joyaRequestDTO.getPosee_piedra(),joya.get().getVentaONo());
            iJoyaRepository.save(joyaModificada);
            JoyaResponseDTO joyaResponseDTO= new JoyaResponseDTO(joyaModificada.getNombre(),joyaModificada.getMaterial(),joyaModificada.getParticularidad(),joyaModificada.getPeso(),joyaModificada.getPosee_piedra(),joyaModificada.getVentaONo());
            return joyaResponseDTO;
        }
    }
}
