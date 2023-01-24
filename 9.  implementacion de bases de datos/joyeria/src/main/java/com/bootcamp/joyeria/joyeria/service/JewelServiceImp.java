package com.bootcamp.joyeria.joyeria.service;

import com.bootcamp.joyeria.joyeria.dot.JewelDTO;
import com.bootcamp.joyeria.joyeria.dot.MessageDTO;
import com.bootcamp.joyeria.joyeria.models.Jewel;
import com.bootcamp.joyeria.joyeria.repository.IJewelRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JewelServiceImp implements IJewelService{
    private final IJewelRepository jewelRepository;
    ModelMapper modelMapper = new ModelMapper();

    public JewelServiceImp(IJewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public JewelDTO saveJewel(JewelDTO jewelDTO) {
        Jewel savedJewel = jewelRepository.save(modelMapper.map(jewelDTO, Jewel.class));

        return modelMapper.map(savedJewel,JewelDTO.class);
    }

    @Override
    public Optional<Jewel> findJewel(Long id) {
        return jewelRepository.findById(id);
    }

    @Override
    public List<JewelDTO> getAllJewels() {

        List<JewelDTO> dtoResponse = new ArrayList<>();
        jewelRepository.findAll().stream()
                .filter(Jewel::getSaleOrNo)
                .forEach(jewel -> dtoResponse.add( modelMapper.map(jewel,JewelDTO.class)));

        if(dtoResponse.size() != 0){
            return dtoResponse;
        }

        return null;
    }

    @Override
    public MessageDTO deleteJewel(Long id) {
        Jewel foundJewel = findJewel(id).orElseThrow(()-> new RuntimeException("Error"));
        if(foundJewel.getSaleOrNo()){
            foundJewel.setSaleOrNo(false);
            jewelRepository.save(foundJewel);
            return MessageDTO.builder()
                    .action("joya eliminada")
                    .message("Eliminado de la joya realizado con éxito")
                    .build();
        }
        return MessageDTO.builder()
                .action("Error al eliminar la joya")
                .message("No se pudo eliminar la joya, no se encontró o ya ha sido eliminada")
                .build();

    }

}
