package com.bootcamp20.lasPerlas.service;

import com.bootcamp20.lasPerlas.dtos.JewelryDTO;
import com.bootcamp20.lasPerlas.dtos.MessageDTO;
import com.bootcamp20.lasPerlas.entity.Jewelry;
import com.bootcamp20.lasPerlas.exceptions.OperationFailedException;
import com.bootcamp20.lasPerlas.repository.IJewelryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JewelryServiceImpl implements IJewelryService {

    @Autowired
    private IJewelryRepository jewelryRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public MessageDTO saveJewelry(JewelryDTO jewelryDTO) {
        if (jewelryDTO.isSaleONo()) {
            var jewelryEntity = mapper.map(jewelryDTO, Jewelry.class);
            jewelryRepository.save(jewelryEntity);
            return MessageDTO.builder()
                    .message("Joya agregada correctamente!")
                    .nro_identifying(jewelryEntity.getNro_identifying())
                    .build();
        }
        throw new OperationFailedException("El atributo esta en venta no puede ser false!");
    }

    @Override
    public JewelryDTO getJewelryById(Integer nro_identifying) {
        if (jewelryRepository.existsById(nro_identifying)) {
            Optional<Jewelry> jewelry = jewelryRepository.findById(nro_identifying);
            return mapper.map(jewelry, JewelryDTO.class);
        }
        throw new OperationFailedException("No fue encontrada la joya con id " + nro_identifying);
    }

    @Override
    public MessageDTO updateJewelry(Integer id_modify, JewelryDTO jewelryDTO) {
        if (jewelryRepository.existsById(id_modify)) {
            Jewelry jewelry = mapper.map(jewelryDTO, Jewelry.class);
            jewelry.setNro_identifying(id_modify);
            jewelryRepository.save(jewelry);

            return MessageDTO.builder()
                    .message("Joya modificada correctamente!")
                    .nro_identifying(jewelry.getNro_identifying())
                    .build();

        }
        throw new OperationFailedException("El id_modificar no existe!");
    }

    @Override
    public List<JewelryDTO> getAllJewelry() {
        List<Jewelry> jewelryList = jewelryRepository.findAll();
        if (!jewelryList.isEmpty())
            return jewelryList.stream().filter(Jewelry::isSaleONo).map(jewelry -> mapper.map(jewelry, JewelryDTO.class)).collect(Collectors.toList());
        throw new OperationFailedException("No hay registros en la Base de Datos!");
    }

    @Override
    public MessageDTO deleteJewelry(Integer nro_identifying) {
        if (jewelryRepository.existsById(nro_identifying)) {
            JewelryDTO jewelryDTO = getJewelryById(nro_identifying);
            Jewelry jewelry = mapper.map(jewelryDTO, Jewelry.class);
            jewelry.setNro_identifying(nro_identifying);
            jewelry.setSaleONo(false);
            jewelryRepository.save(jewelry);

            return MessageDTO.builder()
                    .message("Joya se ha eliminado correctamente!")
                    .nro_identifying(nro_identifying)
                    .build();
        }
        throw new OperationFailedException("El id no existe!");
    }
}
