package com.bootcamp.joyeria.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.bootcamp.joyeria.dtos.JoyaRequestDto;
import com.bootcamp.joyeria.dtos.JoyaResponseDto;
import com.bootcamp.joyeria.dtos.MessageDto;
import com.bootcamp.joyeria.entity.Joya;
import com.bootcamp.joyeria.repository.JoyaRepository;
import com.bootcamp.joyeria.util.Params;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService {

    private final JoyaRepository joyaRepo;
    private final ModelMapper mapper;

    public JoyaService(JoyaRepository joyaRepo) {
        this.joyaRepo = joyaRepo;
        this.mapper = new ModelMapper();
    }

    @Transactional(readOnly = true)
    public List<JoyaResponseDto> obtenerJoyas() {
        return joyaRepo.findAll().stream()
                .filter(Joya::getVentaONo)
                .map(joya -> mapper.map(joya, JoyaResponseDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public Long guardarJoya(Joya joya) {
        return joyaRepo.save(joya).getNro_identificatorio();
    }

    @Transactional
    public MessageDto eliminarJoya(Long id) {
        Joya joya = buscarJoya(id);
        MessageDto messageDto = new MessageDto();
        if (joya != null) {
            joya.setVentaONo(false);
            guardarJoya(joya);
            messageDto.setMsg(Params.obtenerString("JoyaEliminada"));
            messageDto.setStatus(HttpStatus.OK.value());
        } else {
            messageDto.setMsg(Params.obtenerString("JoyaNoEncontrada"));
            messageDto.setStatus(HttpStatus.NOT_FOUND.value());
        }
        return messageDto;
    }

    public MessageDto crearJoya(JoyaRequestDto joyaDto) {
        Long id = guardarJoya(mapper.map(joyaDto, Joya.class));
        System.out.println(joyaDto);
        return new MessageDto(Params.obtenerString("JoyaCreada") + id, HttpStatus.OK.value());
    }

    @Transactional(readOnly = true)
    public Joya buscarJoya(Long id) {
        return joyaRepo.findById(id).orElse(null);
    }
}
