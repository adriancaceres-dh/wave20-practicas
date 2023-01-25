package com.joyeria.joyeria.service;

import com.joyeria.joyeria.dto.JewelRequestDto;
import com.joyeria.joyeria.dto.JewelResponseDto;
import com.joyeria.joyeria.dto.JewelryListResponseDto;
import com.joyeria.joyeria.dto.MessageDto;
import com.joyeria.joyeria.entity.Jewel;
import com.joyeria.joyeria.repository.IJewelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewelService implements  IJewelService{

    private IJewelRepository jewelRepository;

    private ModelMapper mapper;

    public JewelService(IJewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public JewelResponseDto createJewel(JewelRequestDto jewelDto) {
        return saveJewel(jewelDto);
    }

    @Override
    public JewelryListResponseDto getAll() {

        List<Jewel> entityList = jewelRepository
                .findAll()
                .stream()
                .filter(jewel -> jewel.getIsOnSale())
                .collect(Collectors.toList());

        List<JewelResponseDto> listDto = entityList
                .stream()
                .map(jewel -> mapper.map(jewel, JewelResponseDto.class))
                .collect(Collectors.toList());

        return JewelryListResponseDto.builder().jewelry(listDto).build();
    }

    @Override
    public MessageDto delete(Integer id) {
        if(!jewelRepository.existsById(id))
            throw new RuntimeException("Id no existe");

        Jewel jewel = jewelRepository.findById(id).get();

        jewel.setIsOnSale(false);

        jewelRepository.save(jewel);

        return new MessageDto(jewel.getId(), "Fue borrada con exito");
    }

    @Override
    public JewelResponseDto updateJewel(JewelRequestDto jewelDto) {
        if(!jewelRepository.existsById(jewelDto.getId()))
            throw new RuntimeException("Id no existe");

        return saveJewel(jewelDto);
    }

    private JewelResponseDto saveJewel(JewelRequestDto jewelDto) {
        Jewel jewelEntity = mapper.map(jewelDto, Jewel.class);
        Jewel savedJewel =  jewelRepository.save(jewelEntity);
        return mapper.map(savedJewel, JewelResponseDto.class);
    }
}
