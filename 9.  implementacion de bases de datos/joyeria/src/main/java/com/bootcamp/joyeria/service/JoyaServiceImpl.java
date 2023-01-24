package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.common.JoyaDTO;
import com.bootcamp.joyeria.dto.request.CreateJoyaDTO;
import com.bootcamp.joyeria.dto.response.MessageDTO;
import com.bootcamp.joyeria.dto.response.UpdatedJoyaDTO;
import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImpl implements IJoyaService {

    private final IJoyaRepository joyaRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public JoyaServiceImpl(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public MessageDTO createJoya(CreateJoyaDTO joyaDTO) {
        if(!joyaDTO.getVentaONo())
            throw new RuntimeException("El campo 'ventaONo' debe ser siempre verdadero.");

        Joya newJoya = modelMapper.map(joyaDTO, Joya.class);

        Joya created = joyaRepository.save(newJoya);
        return new MessageDTO(201, "Se creó la joya con el siguiente número identificatorio: " + created.getNro_identificatorio() + ".");
    }

    @Override
    public List<JoyaDTO> getJoyas() {
        List<Joya> joyas = joyaRepository.findAll();
        return joyas.stream().filter(Joya::getVentaONo).map(joya -> modelMapper.map(joya, JoyaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public JoyaDTO getJoyaById(Long id) {
        Joya found = joyaRepository.findById(id).orElseThrow(() -> new RuntimeException("Joya no encontrada."));
        return modelMapper.map(found, JoyaDTO.class);
    }

    @Override
    public UpdatedJoyaDTO updateJoya(Long id, CreateJoyaDTO joyaDTO) {
        if(!joyaRepository.existsById(id))
            throw new RuntimeException("Joya no encontrada.");

        Joya updatedJoya = modelMapper.map(joyaDTO, Joya.class);
        updatedJoya.setNro_identificatorio(id);
        updatedJoya = joyaRepository.save(updatedJoya);

        return new UpdatedJoyaDTO(200, modelMapper.map(updatedJoya, JoyaDTO.class));
    }

    @Override
    public MessageDTO deleteJoyaById(Long id) {
        Joya found = joyaRepository.findById(id).orElseThrow(() -> new RuntimeException("Joya no encontrada."));

        if(!found.getVentaONo())
            return new MessageDTO(400, "La joya solicitada ya ha sido eliminada.");

        found.setVentaONo(false);
        joyaRepository.save(found);

        return new MessageDTO(200, "Se eliminó la joya con el siguiente número identificatorio: " + found.getNro_identificatorio() + ".");
    }
}
