package com.bootcamp.clothes_no_relational.service;

import com.bootcamp.clothes_no_relational.domain.Garment;
import com.bootcamp.clothes_no_relational.dto.common.GarmentDTO;
import com.bootcamp.clothes_no_relational.dto.response.MessageDTO;
import com.bootcamp.clothes_no_relational.repository.IGarmentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GarmentServiceImpl implements IGarmentService {

    private final IGarmentRepository garmentRepository;
    ModelMapper modelMapper = new ModelMapper();

    public GarmentServiceImpl(IGarmentRepository garmentRepository) {
        this.garmentRepository = garmentRepository;

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public MessageDTO create(GarmentDTO garmentDTO) {
        Garment newGarment = modelMapper.map(garmentDTO, Garment.class);
        newGarment = garmentRepository.save(newGarment);

        return new MessageDTO(201, "Created", "The garment was created with the following code: " + newGarment.getCode() + ".");
    }

    @Override
    public List<GarmentDTO> getAll() {
        Page<Garment> clothes = garmentRepository.findAll(Pageable.unpaged());

        return clothes.map(garment -> modelMapper.map(garment, GarmentDTO.class)).toList();
    }

    @Override
    public GarmentDTO getById(Long id) {
        Garment found = garmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Garment not found"));

        return modelMapper.map(found, GarmentDTO.class);
    }

    @Override
    public MessageDTO update(Long id, GarmentDTO garmentDTO) {
        if(!id.equals(garmentDTO.getCode()))
            throw new RuntimeException("The endpoint code must match the payload code.");

        if(!garmentRepository.existsById(id))
            throw new RuntimeException("Garment not found.");

        Garment updated = modelMapper.map(garmentDTO, Garment.class);
        garmentRepository.save(updated);

        return new MessageDTO(200, "Updated", "The garment was updated.");
    }

    @Override
    public MessageDTO deleteById(Long id) {
        if(!garmentRepository.existsById(id))
            throw new RuntimeException("Garment not found.");

        garmentRepository.deleteById(id);

        return new MessageDTO(200, "Deleted", "The garment was deleted.");
    }

    @Override
    public List<GarmentDTO> getBySizeEquals(String size) {
        List<Garment> clothes = garmentRepository.findBySizeEquals(size);

        return clothes.stream().map(garment -> modelMapper.map(garment, GarmentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<GarmentDTO> getByNameContaining(String term) {
        List<Garment> clothes = garmentRepository.findByNameContaining(term);

        return clothes.stream().map(garment -> modelMapper.map(garment, GarmentDTO.class)).collect(Collectors.toList());
    }
}
