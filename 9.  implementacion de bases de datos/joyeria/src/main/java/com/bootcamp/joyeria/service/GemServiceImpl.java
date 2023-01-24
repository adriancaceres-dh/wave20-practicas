package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.GemDto;
import com.bootcamp.joyeria.dto.MessageDto;
import com.bootcamp.joyeria.model.Gem;
import com.bootcamp.joyeria.repository.IGemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GemServiceImpl implements IGemService {

    @Autowired
    IGemRepository gemRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public MessageDto createGem(GemDto gemDto) {
        Gem gem = Gem.builder()
                .nombre(gemDto.getNombre())
                .material(gemDto.getMaterial())
                .peso(gemDto.getPeso())
                .particularidad(gemDto.getParticularidad())
                .poseePiedra(gemDto.isPoseePiedra())
                .ventaONo(gemDto.isVentaONo())
                .build();
        gemRepository.save(gem);
        return MessageDto.builder()
                .message("Nro identificatorio " + gem.getNroIdentificatorio())
                .action("CREADO")
                .build();
    }

    @Override
    public List<GemDto> getAllGem() {
        List<Gem> gemDtoList = gemRepository.findAll();
        List<Gem> gemList = gemDtoList.stream().filter(Gem::isVentaONo).collect(Collectors.toList());
        return gemList.stream().map(gem -> mapper.map(gem, GemDto.class)).collect(Collectors.toList());
    }

    @Override
    public MessageDto deleteGem(Long id) {
        Gem gem = gemRepository.findById(id).orElse(null);
       if(gem != null){
           gem.setVentaONo(false);
           gemRepository.save(gem);
       }
        return MessageDto.builder()
                .message("Nro identificatorio eliminado " + gem.getNroIdentificatorio())
                .action("Eliminado")
                .build();
    }

    @Override
    public GemDto UpDate(Long id,GemDto gemDto) {
        Gem gem = gemRepository.findById(id).orElse(null);
        if(gem != null){
            gem.setNombre(gemDto.getNombre());
            gem.setPeso(gemDto.getPeso());
            gem.setMaterial(gemDto.getMaterial());
            gem.setParticularidad(gemDto.getParticularidad());
            gem.setVentaONo(gemDto.isVentaONo());
            gem.setPoseePiedra(gemDto.isPoseePiedra());
            gemRepository.save(gem);
        }

        return mapper.map(gem, GemDto.class);
    }
}
