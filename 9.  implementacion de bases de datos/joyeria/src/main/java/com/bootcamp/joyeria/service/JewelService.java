package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.JewelDTO;
import com.bootcamp.joyeria.dto.MessageDTO;
import com.bootcamp.joyeria.dto.UpdatedDTO;
import com.bootcamp.joyeria.entity.Jewel;
import com.bootcamp.joyeria.repository.IJewelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JewelService implements IJewelService{

    private final IJewelRepository jewelRepository;

    public JewelService(IJewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    ModelMapper mapper = new ModelMapper();

    @Override
    public MessageDTO addJewel(JewelDTO jewelDTO) {

        var jewelEntity = mapper.map(jewelDTO, Jewel.class);

        jewelEntity = jewelRepository.save(jewelEntity);

        return MessageDTO.builder().message("Joya creada con id: "+jewelEntity.getNroIdentificatorio()).status("CREATED").build();
    }

    @Override
    public List<JewelDTO> getJewerly() {
        var list = jewelRepository.findAll();

        return list.stream().map(jewel -> mapper.map(jewel, JewelDTO.class)).filter(jewelDTO -> jewelDTO.getVentaONo() == true).collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteJewl(Integer id) {
        if(!jewelRepository.existsById(id)){
            return MessageDTO.builder().message("No existe una Joya asociada a ese Id").status("ID NOT FOUND").build();
        }
        var jewelEntity = jewelRepository.findById(id);
        if(!jewelEntity.get().getVentaONo()){
            return MessageDTO.builder().message("No existe una Joya asociada a ese Id").status("ID NOT FOUND").build();
        }
        jewelEntity.get().setVentaONo(false);
        jewelRepository.save(jewelEntity.get());
        return MessageDTO.builder().message("Joya con Id "+jewelEntity.get().getNroIdentificatorio()+" eliminado").status("DELETED").build();
    }

    @Override
    public Object updateJewel(Integer id, JewelDTO jewelDTO) {
        if(!jewelRepository.existsById(id)){
            return MessageDTO.builder().message("No existe una Joya asociada a ese Id").status("ID NOT FOUND").build();
        }
        var jewelEntity = jewelRepository.findById(id);
        jewelEntity.get().setMaterial(jewelDTO.getMaterial());
        jewelEntity.get().setNombre(jewelDTO.getNombre());
        jewelEntity.get().setVentaONo(jewelDTO.getVentaONo());
        jewelEntity.get().setPeso(jewelDTO.getPeso());
        jewelEntity.get().setParticularidad(jewelDTO.getParticularidad());
        jewelEntity.get().setPoseePiedra(jewelDTO.getPoseePiedra());
        jewelRepository.save(jewelEntity.get());
        return UpdatedDTO.builder().jewelDTO(mapper.map(jewelEntity, JewelDTO.class)).nroIdentificatorio(id).build();
    }
}
