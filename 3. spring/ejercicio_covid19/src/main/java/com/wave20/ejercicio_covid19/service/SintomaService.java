package com.wave20.ejercicio_covid19.service;

import com.wave20.ejercicio_covid19.dto.SintomaDTO;
import com.wave20.ejercicio_covid19.model.Sintoma;
import com.wave20.ejercicio_covid19.repository.PersonaRepository;
import com.wave20.ejercicio_covid19.repository.SintomaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SintomaService {

    @Autowired
    private SintomaRepository sintomaRepository;

    private final ModelMapper mapper = new ModelMapper();

    public SintomaService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }
    public List<SintomaDTO> getSintomas() {
        return mapper.map(sintomaRepository.getSintomas(), List.class);
    }

    public Optional<SintomaDTO> getSintomaPorNombre(String nombre) {
        Optional<Sintoma> sintoma = sintomaRepository.getSintomas().stream().filter(s -> s.getNombre().equals(nombre)).findAny();

        if (sintoma.isPresent()) {
            SintomaDTO s = mapper.map(sintoma.get(), SintomaDTO.class);
            return Optional.of(s);
        } else {
            return Optional.empty();
        }
    }


}
