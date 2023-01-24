package com.example.crud_joyeria.service;

import com.example.crud_joyeria.dto.JoyaDto;
import com.example.crud_joyeria.dto.MessageDto;
import com.example.crud_joyeria.dto.request.JoyaCreateDto;
import com.example.crud_joyeria.entity.Joya;
import com.example.crud_joyeria.exceptions.JoyaNotFoundException;
import com.example.crud_joyeria.repository.IJoyaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class JoyaService implements IJoyaService{

    @Autowired
    IJoyaRepository joyaRepository;

    ModelMapper modelMapper;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public MessageDto create(JoyaCreateDto joyaCreateDto) {
        Joya joya = modelMapper.map(joyaCreateDto,Joya.class);
        joya.setVentaONo(true);

        Joya result = joyaRepository.save(joya);

        MessageDto message = new MessageDto("Se creó la joya con el id " + result.getNoIdentificatorio());
        return message;
    }

    @Override
    public List<JoyaDto> findAll() {

        List<JoyaDto> joyas = joyaRepository.findAll().stream().filter(j -> j.getVentaONo() == true)
                .map(j -> modelMapper.map(j,JoyaDto.class)).collect(Collectors.toList());


        return joyas;
    }

    @Override
    public MessageDto logicDelete(Long id) {

        Joya joya = joyaRepository.findById(id).orElseThrow(() -> new JoyaNotFoundException("Joya not found"));
        String message;
        if(joya.getVentaONo()){
            joya.setVentaONo(false);
            joyaRepository.save(joya);
            message = "la joya se ha eliminado logicamente";
        } else {
            message = "La joya ya se encontraba eliminda";
        }

        return new MessageDto(message);
    }

    @Override
    public JoyaDto modify(JoyaDto joyaDto, Long id) {

        Joya joya = joyaRepository.findById(id).orElseThrow(() -> new JoyaNotFoundException("Joya not found"));

        Joya newJoya = modelMapper.map(joyaDto,Joya.class);
        newJoya.setNoIdentificatorio(joya.getNoIdentificatorio());

        Joya result = joyaRepository.save(newJoya);

        return modelMapper.map(result,JoyaDto.class);



    }
}
