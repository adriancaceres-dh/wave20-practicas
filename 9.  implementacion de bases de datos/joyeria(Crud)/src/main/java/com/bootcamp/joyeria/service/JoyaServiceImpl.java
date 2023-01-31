package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.request.JoyaDTORequest;
import com.bootcamp.joyeria.dto.response.JoyaDTOResponse;
import com.bootcamp.joyeria.dto.response.MessageDTO;
import com.bootcamp.joyeria.entity.Joya;
import com.bootcamp.joyeria.exception.BadRequestException;
import com.bootcamp.joyeria.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImpl implements IJoyaService {

    @Autowired
    private IJoyaRepository repository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public MessageDTO save(JoyaDTORequest joyaDTO){
        Joya joya = mapper.map(joyaDTO, Joya.class);
        joya = repository.save(joya);
        return MessageDTO.builder()
                .message("Se creó una nueva joya con el número identificatorio " + joya.getNroIdentificatorio())
                .action("CREATE")
                .build();
    }

    @Override
    public List<JoyaDTOResponse> getAll() {
        List<Joya> joyas = repository.findAll();
        return joyas.stream().filter(j -> j.isVentaONo()).map(j -> mapper.map(j, JoyaDTOResponse.class)).collect(Collectors.toList());
    }

    @Override
    public MessageDTO delete(Integer id) {
        Joya joya = repository.findById(id).orElse(null);
        if(joya == null) throw new BadRequestException("No hay una joya con ese id");
        joya.setVentaONo(false);
        repository.save(joya);
        return MessageDTO.builder()
                .message("Se eliminó de manera logica la joya con el número identificatorio " + id)
                .action("DELETE")
                .build();
    }

    @Override
    public JoyaDTOResponse update(JoyaDTORequest joyaDTORequest, Integer id){
        if(!repository.existsById(id))
            throw new BadRequestException("Numero de indentificación erroneo");
        Joya joya = mapper.map(joyaDTORequest, Joya.class);
        joya.setNroIdentificatorio(id);
        repository.save(joya);
        return mapper.map(joya, JoyaDTOResponse.class);
    }
}
