package com.example.LaPerlaCrud.service;

import com.example.LaPerlaCrud.dto.JoyaDTO;
import com.example.LaPerlaCrud.dto.MessageDTO;
import com.example.LaPerlaCrud.entitiy.Joya;
import com.example.LaPerlaCrud.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceJoyaImpl implements IServiceJoya{

    @Autowired
    IJoyaRepository repository;

    ModelMapper mapper = new ModelMapper();

    public MessageDTO saveJoya(JoyaDTO joyaDTO){
        Joya joyaEntity = mapper.map(joyaDTO, Joya.class);
        if(joyaDTO.getVentaONo() == false){
            return new MessageDTO("La joya no se puede crear ventaONo esta en false" ,"Create");
        }else{
            joyaEntity = repository.save(joyaEntity);
            return new MessageDTO("nro identificatorio " + joyaEntity.getId(),"Create");
        }
    }

    public JoyaDTO updateJoya(Integer id_modificar,JoyaDTO joyaDTO){
        if(repository.existsById(id_modificar)) {
            var joyaEntity = repository.findById(id_modificar);
            Joya joya = joyaEntity.get();
            joya.setNombre(joyaDTO.getNombre());
            joya.setMaterial(joyaDTO.getMaterial());
            joya.setPeso(joyaDTO.getPeso());
            joya.setParticularidad(joyaDTO.getParticularidad());
            joya.setPoseePiedra(joyaDTO.getPoseePiedra());
            joya.setVentaONo(joyaDTO.getVentaONo());
            repository.save(joya);
            return mapper.map(joya,JoyaDTO.class);

        }else{
            throw new RuntimeException("No pudo actualizarse el testcase");
        }
    }


    public List<JoyaDTO> getAllJoyas(){
        var list = repository.findAll();

        return list.stream().map(
                joya -> mapper.map(joya, JoyaDTO.class)
        ).collect(Collectors.toList());
    }

    public MessageDTO deleteJoya(Integer id){
        if(repository.existsById(id)) {
            var joyaEntity = repository.findById(id);
            JoyaDTO joyaDTO = mapper.map(joyaEntity, JoyaDTO.class);
            if(joyaDTO.getVentaONo() == true){
                return new MessageDTO("La joya no se puede eliminar porque ventaONo esta en true" ,"DELETE");
            }else{
                repository.deleteById(id);
                return new MessageDTO("La joya fue eliminada" ,"DELETE");
            }
        }else{
            throw new RuntimeException("no se pudo encontrar la joya");
        }
    }
}
