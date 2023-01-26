package com.example.ejercicioopcional.service;

import com.example.ejercicioopcional.dto.ClothDTO;
import com.example.ejercicioopcional.dto.MessageDTO;
import com.example.ejercicioopcional.entity.Cloth;
import com.example.ejercicioopcional.repository.IClothRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothService implements ICrudService<ClothDTO, Integer>{

    @Autowired
    IClothRepository clothRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public ClothDTO saveEntity(ClothDTO entityDTO) {


        var entity = mapper.map(entityDTO, Cloth.class);

        entity = clothRepository.save(entity);

        return mapper.map(entity, ClothDTO.class);
    }

    public Boolean clothExists(Integer id){
        return clothRepository.existsById(id);
    }


    @Override
    public ClothDTO getEntityById(Integer integer) {

        var entity = clothRepository.findById(integer).orElseThrow(
                () -> { throw new RuntimeException("No pude encontrar la prenda");}
        );

        return mapper.map(entity, ClothDTO.class);
    }

    @Override
    public List<ClothDTO> getAllEntities() {
        var list = clothRepository.findAll();
        return list.stream().map(
                cloth -> mapper.map(cloth, ClothDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {

        if(clothExists(integer)) {
            clothRepository.deleteById(integer);
            return MessageDTO.builder()
                    .message("El id: " + integer + " fue borrado con exito")
                    .action("DELETED")
                    .build();
        }
        throw new RuntimeException("No se encontro la prenda");
    }

    public List<ClothDTO> findBySize(Integer size){

        var list = clothRepository.findBySizeEquals(size);

        return list.stream().map(
                cloth -> mapper.map(cloth, ClothDTO.class)
        ).collect(Collectors.toList());
    }

    public List<ClothDTO> findByName(String name){
        var list = clothRepository.findByNameContains(name);

        return list.stream().map(
                cloth -> mapper.map(cloth, ClothDTO.class)
        ).collect(Collectors.toList());
    }
}
