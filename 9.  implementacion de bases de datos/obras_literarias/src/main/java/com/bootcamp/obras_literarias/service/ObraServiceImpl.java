package com.bootcamp.obras_literarias.service;

import com.bootcamp.obras_literarias.domain.Obra;
import com.bootcamp.obras_literarias.dto.MensajeDTO;
import com.bootcamp.obras_literarias.dto.ObraDTO;
import com.bootcamp.obras_literarias.repository.IObraRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObraServiceImpl implements IObraService {

    IObraRepository obraRepository;
    ModelMapper modelMapper = new ModelMapper();

    public ObraServiceImpl(IObraRepository obraRepository) {
        this.obraRepository = obraRepository;

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public MensajeDTO createObra(ObraDTO obraDTO) {
        Obra newObra = modelMapper.map(obraDTO, Obra.class);
        newObra = obraRepository.save(newObra);

        return new MensajeDTO(201, "La obra fue creada con el siguiente ID: " + newObra.getId() + ".");
    }

    @Override
    public List<ObraDTO> getObras() {
        Page<Obra> obras = obraRepository.findAll(Pageable.unpaged());

        return obras.map(obra -> modelMapper.map(obra, ObraDTO.class)).toList();
    }

    @Override
    public List<ObraDTO> getObrasByAutor(String autor) {
        List<Obra> obras = obraRepository.findAllByAutor(autor);

        return obras.stream().map(obra -> modelMapper.map(obra, ObraDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObraDTO> getObrasByPalabra(String palabra) {
        List<Obra> obras = obraRepository.findAllByNombreContaining(palabra);

        return obras.stream().map(obra -> modelMapper.map(obra, ObraDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObraDTO> getObrasAfterPublicacion(Integer publicacion) {
        List<Obra> obras = obraRepository.findAllByPublicacionAfter(publicacion);

        return obras.stream().map(obra -> modelMapper.map(obra, ObraDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObraDTO> getObrasBeforePublicacion(Integer publicacion) {
        List<Obra> obras = obraRepository.findAllByPublicacionBefore(publicacion);

        return obras.stream().map(obra -> modelMapper.map(obra, ObraDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObraDTO> getObrasByEditorial(String editorial) {
        List<Obra> obras = obraRepository.findAllByEditorial(editorial);

        return obras.stream().map(obra -> modelMapper.map(obra, ObraDTO.class)).collect(Collectors.toList());
    }
}
