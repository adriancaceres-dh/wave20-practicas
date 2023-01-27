package com.bootcamp.showroom_elastic.service;

import com.bootcamp.showroom_elastic.dto.ClothingDTO;
import com.bootcamp.showroom_elastic.elastic_respositories.ElasticClothingRepository;
import com.bootcamp.showroom_elastic.util.mapper.IClothingMapper;
import com.bootcamp.showroom_elastic.util.mapper.implementation.ClothingMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClothingService {
    private final ElasticClothingRepository elasticClothingRepository;
    private final IClothingMapper clothingMapper;

    public ClothingDTO create(ClothingDTO clothingDTO) {
        var clothing = clothingMapper.fromDTO(clothingDTO);
        clothing = elasticClothingRepository.save(clothing);

        return clothingMapper.toDTO(clothing);
    }

    public List<ClothingDTO> findAll() {
        return elasticClothingRepository.findAll().stream()
                .map(clothingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClothingDTO findById(String id) {
        var maybeClothing = elasticClothingRepository.findById(id);
        return maybeClothing.map(clothingMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Clothing not found"));
    }

    public ClothingDTO update(String id, ClothingDTO clothingDTO) {
        if(!elasticClothingRepository.existsById(id)){
            throw new RuntimeException("Clothing not found");
        }
        var clothing = clothingMapper.fromDTO(clothingDTO);
        clothing.setId(id);
        clothing = elasticClothingRepository.save(clothing);

        return clothingMapper.toDTO(clothing);
    }

    public String delete(String id) {
        elasticClothingRepository.deleteById(id);
        return "Clothing deleted";
    }

    public List<ClothingDTO> findBySize(String size) {
        return elasticClothingRepository.findBySize(size).stream()
                .map(clothingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<ClothingDTO> findByNameContains(String name) {
        return elasticClothingRepository.findByNameContains(name).stream()
                .map(clothingMapper::toDTO)
                .collect(Collectors.toList());
    }
}
