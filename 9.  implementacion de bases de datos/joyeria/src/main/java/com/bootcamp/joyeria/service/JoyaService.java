package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dtos.ActualizaJoyaDto;
import com.bootcamp.joyeria.dtos.JoyaRequestDto;
import com.bootcamp.joyeria.dtos.JoyaResponseDto;
import com.bootcamp.joyeria.dtos.MensajeDto;
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
    public MensajeDto eliminarJoya(Long id) {
        Joya joya = buscarJoya(id);
        MensajeDto mensajeDto = new MensajeDto();
        if (joya != null) {
            joya.setVentaONo(false);
            guardarJoya(joya);
            mensajeDto.setMsg(Params.obtenerString("JoyaEliminada"));
            mensajeDto.setStatus(HttpStatus.OK.value());
        } else {
            mensajeDto.setMsg(Params.obtenerString("JoyaNoEncontrada"));
            mensajeDto.setStatus(HttpStatus.NOT_FOUND.value());
        }
        return mensajeDto;
    }

    public MensajeDto crearJoya(JoyaRequestDto joyaDto) {
        Long id = guardarJoya(mapper.map(joyaDto, Joya.class));
        return new MensajeDto(Params.obtenerString("JoyaCreada") + id, HttpStatus.OK.value());
    }

    @Transactional(readOnly = true)
    public Joya buscarJoya(Long id) {
        return joyaRepo.findById(id).orElse(null);
    }

    public ActualizaJoyaDto actualizarJoya(Long id, JoyaRequestDto joyaDto) {
        Joya joyaActualizada = mapper.map(joyaDto, Joya.class);
        joyaActualizada.setNro_identificatorio(id);
        guardarJoya(joyaActualizada);
        return new ActualizaJoyaDto(mapper.map(joyaActualizada, JoyaResponseDto.class));
    }
}
