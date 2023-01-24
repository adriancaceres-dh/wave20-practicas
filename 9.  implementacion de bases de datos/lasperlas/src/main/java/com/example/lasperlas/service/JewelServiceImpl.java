package com.example.lasperlas.service;

import com.example.lasperlas.dto.JewelOperationResponseDto;
import com.example.lasperlas.dto.JewelRequestDto;
import com.example.lasperlas.dto.JewelResponseDto;
import com.example.lasperlas.dto.Operations;
import com.example.lasperlas.entity.Jewel;
import com.example.lasperlas.exception.NotFoundException;
import com.example.lasperlas.repository.JewelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JewelServiceImpl implements JewelService {
    private final JewelRepository jewelRepository;
    private final ModelMapper modelMapper;

    public JewelServiceImpl(JewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public JewelOperationResponseDto addJewel(JewelRequestDto jewelRequestDto) {
        Jewel newJewel = jewelRepository.save(modelMapper.map(jewelRequestDto, Jewel.class));

        return new JewelOperationResponseDto(Operations.ADDED, newJewel.getId());
    }

    @Override
    public JewelOperationResponseDto setAsUnsellable(Long id) {
        Optional<Jewel> jewelFound = jewelRepository.findById(id);
        if (jewelFound.isPresent()) {
            Jewel updatedJewel = jewelFound.get();
            updatedJewel.setCanBeSold(false);
            jewelRepository.save(updatedJewel);
            return new JewelOperationResponseDto(Operations.DELETED, updatedJewel.getId());
        }
        throw new NotFoundException(id);
    }

    @Override
    public JewelOperationResponseDto updateJewel(Long id, JewelRequestDto jewelRequestDto) {
        if (jewelRepository.existsById(id)) {
            Jewel newJewel = modelMapper.map(jewelRequestDto, Jewel.class);
            newJewel.setId(id);
            jewelRepository.save(newJewel);
            return new JewelOperationResponseDto(Operations.UPDATED, newJewel.getId());
        }
        throw new NotFoundException(id);
    }

    @Override
    public List<JewelResponseDto> getAllSellableJewels() {
        return jewelRepository.findAll()
                .stream()
                .map(j -> modelMapper.map(j, JewelResponseDto.class))
                .filter(JewelResponseDto::isCanBeSold)
                .collect(Collectors.toList());
    }
}
