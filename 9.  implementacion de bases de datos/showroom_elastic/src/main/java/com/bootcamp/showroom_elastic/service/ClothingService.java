package com.bootcamp.showroom_elastic.service;

import com.bootcamp.showroom_elastic.dto.ClothingDTO;
import com.bootcamp.showroom_elastic.elastic_respositories.ElasticClothingRepository;
import com.bootcamp.showroom_elastic.elastic_respositories.ElasticSellRepository;
import com.bootcamp.showroom_elastic.util.mapper.implementation.ClothingMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.internal.util.Lists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClothingService {
    private final ElasticClothingRepository elasticClothingRepository;
    private final ElasticSellRepository elasticSellRepository;
    private final ClothingMapper clothingMapper;

    public ClothingDTO createClothing(ClothingDTO clothingDTO) {
        var clothing = clothingMapper.fromDTO(clothingDTO);
        clothing = elasticClothingRepository.save(clothing);

        return clothingMapper.toDTO(clothing);
    }

    public List<ClothingDTO> findAll() {
        return elasticClothingRepository.findAll().stream()
                .map(clothingMapper::toDTO)
                .collect(Collectors.toList());
    }
}
