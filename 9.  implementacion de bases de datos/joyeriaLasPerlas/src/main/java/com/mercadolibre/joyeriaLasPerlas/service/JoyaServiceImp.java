package com.mercadolibre.joyeriaLasPerlas.service;

import com.mercadolibre.joyeriaLasPerlas.DTO.JoyaRequestDTO;
import com.mercadolibre.joyeriaLasPerlas.DTO.JoyaResponseDTO;
import com.mercadolibre.joyeriaLasPerlas.DTO.MessageDTO;
import com.mercadolibre.joyeriaLasPerlas.model.Joya;
import com.mercadolibre.joyeriaLasPerlas.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImp implements  IJoyaService{

    @Autowired
    private IJoyaRepository joyaRepository;
    ModelMapper modelMapper = new ModelMapper();
    @Override
    public MessageDTO crearJoya(JoyaRequestDTO joyaRequestDTO) {

        var joya = modelMapper.map(joyaRequestDTO, Joya.class);
        joyaRepository.save(joya);

        return new MessageDTO("Joya creada exitosamente");

    }

    @Override
    public JoyaResponseDTO obtenerJoya(int id) throws Exception {
        var joya =joyaRepository.findById(id);
        JoyaResponseDTO joyaResponseDto;

        if(joya.isPresent()){
             joyaResponseDto = modelMapper.map(joya,JoyaResponseDTO.class);
        }else{
            throw new Exception("No se encontro la joya");
        }
        return joyaResponseDto;
    }

    @Override
    public List<JoyaResponseDTO> obtenerTodasLasJoyas() throws Exception {

        List<Joya> listaJoyas = joyaRepository.findAll();
        List<JoyaResponseDTO> listajoyaResponseDTO;

        if(listaJoyas.isEmpty()){
            throw new Exception("No hay Joyas por mostrar");
        }else{
           listajoyaResponseDTO = listaJoyas.stream().map(joya -> modelMapper.map(joya,JoyaResponseDTO.class)).collect(Collectors.toList());
        }
        return listajoyaResponseDTO;
    }

    @Override
    public MessageDTO eliminarJoya(int id) {

        if(joyaRepository.existsById(id)){
            joyaRepository.deleteById(id);
            return new MessageDTO("Joya eliminada exitosamente");
        }else{
            return new MessageDTO("La joya no existe");
        }


    }
}
