package com.bootcamp.clothes.service;

import com.bootcamp.clothes.dto.request.ClotheDTO;
import com.bootcamp.clothes.dto.response.MessageDTO;
import com.bootcamp.clothes.entity.Clothe;
import com.bootcamp.clothes.repository.IClotheRepository;
import com.bootcamp.clothes.service.interfaces.IClotheService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClotheService implements IClotheService {

    @Autowired
    private IClotheRepository clotheRepository;

    ModelMapper mapper = new ModelMapper();


    @Override
    public MessageDTO saveEntity(ClotheDTO clotheDTO) {
        Clothe clothe = mapper.map(clotheDTO, Clothe.class);
        clotheRepository.save(clothe);
        return MessageDTO.builder()
                .action("CREATED")
                .message("Clothing has been successfully saved")
                .build();
    }

    @Override
    public ClotheDTO getEntityById(Integer code) {
        Clothe clothe = clotheRepository.findById(code).orElseThrow(() -> new RuntimeException("clothe with code " + code + " not found"));
        return mapper.map(clothe, ClotheDTO.class);
    }

    @Override
    public List<ClotheDTO> getAllEntities() {
        List<Clothe> clothes = clotheRepository.findAll();
        return clothes.stream().map(c -> mapper.map(c, ClotheDTO.class)).collect(Collectors.toList());
    }

    @Override
    public MessageDTO updateEntity(Integer code, ClotheDTO clotheDTO) {
        var clothe = clotheRepository.findById(code).orElseThrow(() -> new RuntimeException("clothe with code " + code + " not found"));
        clothe = mapper.map(clotheDTO, Clothe.class);
        clothe.setCode(code);
        clotheRepository.save(clothe);
        return MessageDTO.builder()
                .action("UPDATE")
                .message("The garment has been successfully modified")
                .build();
    }

    @Override
    public MessageDTO deleteEntity(Integer code) {
        Clothe clothe = clotheRepository.findById(code).orElseThrow(() -> new RuntimeException("clothe with code " + code + " not found"));
        clotheRepository.delete(clothe);
        return MessageDTO.builder()
                .action("DELETE")
                .message("The garment has been successfully removed")
                .build();
    }

    public List<ClotheDTO> sizeClothe(Integer size) {
        List<Clothe> clothes = clotheRepository.findAllBySize(size);
        return clothes.stream().map(c -> mapper.map(c, ClotheDTO.class)).collect(Collectors.toList());
    }

    public List<ClotheDTO> nameContainsClothe(String name) {
        List<Clothe> clothes = clotheRepository.findAllByNameContains(name);
        return clothes.stream().map(clothe -> mapper.map(clothe, ClotheDTO.class)).collect(Collectors.toList());
    }
}
