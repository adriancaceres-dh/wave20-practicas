package com.bootcamp.showroom.service.interfaces;

import com.bootcamp.showroom.dto.ClothingDto;
import com.bootcamp.showroom.dto.MessageDto;

import java.util.List;

public interface IClothingService {

    ClothingDto createClothing(ClothingDto clothingDto);
    List<ClothingDto> getAllClothing();
    ClothingDto getClothingById(Long id);
    ClothingDto updateClothingById(ClothingDto clothingDto, Long id);
    MessageDto deleteClothingById(Long id);
    List<ClothingDto> getAllClothingBySize(String size);
    List<ClothingDto> getAllClothingByNameContains(String name);
}
