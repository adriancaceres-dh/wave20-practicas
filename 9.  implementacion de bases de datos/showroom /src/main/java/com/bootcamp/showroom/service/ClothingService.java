package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.ClothingDto;
import com.bootcamp.showroom.dto.MessageDto;
import com.bootcamp.showroom.entity.Clothing;
import com.bootcamp.showroom.repository.ClothingRepository;
import com.bootcamp.showroom.service.interfaces.IClothingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothingService implements IClothingService {

    private final ClothingRepository clothingRepo;

    private final ModelMapper mapper;

    public ClothingService(ClothingRepository clothingRepo) {
        this.clothingRepo = clothingRepo;
        this.mapper = new ModelMapper();
    }

    @Override
    public ClothingDto createClothing(ClothingDto clothingDto) {
        Long id = saveClothing(mapper.map(clothingDto, Clothing.class));
        clothingDto.setId(id);
        return clothingDto;
    }

    @Override
    public List<ClothingDto> getAllClothing() {
        return clothingRepo.findAll().stream()
                .map(clothing -> mapper.map(clothing, ClothingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClothingDto getClothingById(Long id) {
        return mapper.map(clothingRepo.findById(id), ClothingDto.class);
    }

    @Override
    public ClothingDto updateClothingById(ClothingDto clothingDto, Long id) {
        if (!clothingRepo.existsById(id)) throw new RuntimeException("Requested id does not exist.");
        clothingDto.setId(id);
        saveClothing(mapper.map(clothingDto, Clothing.class));
        return clothingDto;
    }

    @Override
    public MessageDto deleteClothingById(Long id) {
        if (!clothingRepo.existsById(id)) throw new RuntimeException("Requested id does not exist.");
        clothingRepo.deleteById(id);
        return MessageDto.builder()
                .message("Requested entry was deleted successfully")
                .action("DELETE")
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @Override
    public List<ClothingDto> getAllClothingBySize(String size) {
        return clothingRepo.getAllBySizeEqualsIgnoreCase(size).stream()
                .map(clohing -> mapper.map(clohing, ClothingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClothingDto> getAllClothingByNameContains(String name) {
        if (name == null) return getAllClothing();
        return clothingRepo.getAllByNameContains(name).stream()
                .map(clohing -> mapper.map(clohing, ClothingDto.class))
                .collect(Collectors.toList());
    }

    private Long saveClothing(Clothing clothing) {
        return clothingRepo.save(clothing).getId();
    }
}
