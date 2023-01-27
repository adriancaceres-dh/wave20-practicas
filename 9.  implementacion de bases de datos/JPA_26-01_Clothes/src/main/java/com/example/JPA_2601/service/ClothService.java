package com.example.JPA_2601.service;

import com.example.JPA_2601.dto.ClothDTO;
import com.example.JPA_2601.dto.MessageDTO;
import com.example.JPA_2601.dto.SaleDTO;
import com.example.JPA_2601.entity.Cloth;
import com.example.JPA_2601.repository.IClothRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothService implements ICrudService<ClothDTO, Integer>{
    @Autowired
    IClothRepository iClothRepository;
    ModelMapper mapper = new ModelMapper();
    @Override
    public ClothDTO saveEntity(ClothDTO clothDTO) {
        var entity = mapper.map(clothDTO, Cloth.class);
        entity = iClothRepository.save(entity);
        return mapper.map(entity, ClothDTO.class);
    }


    @Override
    public ClothDTO getEntityById(Integer integer) {
        var entity = iClothRepository.findById(integer).orElseThrow(
                () -> {
                    throw new RuntimeException("NO puede encontrar la prenda");
                }
        );
        return mapper.map(entity, ClothDTO.class);
    }

    @Override
    public List<ClothDTO> getAllEntities() {

      List<ClothDTO> listClothes = iClothRepository.findAll().stream().map(cloth -> mapper.map(cloth, ClothDTO.class)).collect(Collectors.toList()); ;
      return listClothes;

    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        if (clothExists(integer)){
            iClothRepository.deleteById(integer);
            return MessageDTO.builder().message("Se elimino exitosamente").action("DELETED").build();
        }
        throw new RuntimeException("No se encontro el id para eliminar");
    }

    public boolean clothExists(Integer codigo) {
        return iClothRepository.existsById(codigo);
    }

    public List<ClothDTO> findByTalle(Integer talle){
        var list = iClothRepository.findByTalle(talle);
        return list.stream().map(
                cloth -> mapper.map(cloth, ClothDTO.class)
        ).collect(Collectors.toList());
    }
    public List<ClothDTO> findByNombre(String nombre){
        var list = iClothRepository.findByNombreContains(nombre);
        return list.stream().map(
                cloth -> mapper.map(cloth, ClothDTO.class)
        ).collect(Collectors.toList());
    }
}
