package com.withHibernate.Burami.service;

import com.withHibernate.Burami.dto.JoyaDTO;
import com.withHibernate.Burami.dto.MessageDTO;
import com.withHibernate.Burami.entity.Joya;
import com.withHibernate.Burami.repository.IJoyasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    @Autowired
    private IJoyasRepository joyasRepository;

    private ModelMapper mapper = new ModelMapper();
    @Override
    public MessageDTO createEntity(JoyaDTO joyaDTO) {

        if(joyaDTO.getIdJoya() != null)
            throw new RuntimeException("No se permite el envio de IDs");

        var entity = mapper.map(joyaDTO, Joya.class);

        entity = joyasRepository.save(entity);

        if(entity.getIdJoya() != null)
            return MessageDTO.builder()
                    .message("Se creo exitosamente joya")
                    .action("CREATED")
                    .build();
        else
            throw new RuntimeException("No pudo crear la joya");
    }

    @Override
    public MessageDTO updateEntity(JoyaDTO joyaDTO) {
        if(!joyasRepository.existsById(joyaDTO.getIdJoya()))
            throw new RuntimeException("No se permite el envio de IDs nulos o inexistentes para actualizar");

        var entity = mapper.map(joyaDTO, Joya.class);

        entity = joyasRepository.save(entity);

        if(entity.getIdJoya() != null)
            return MessageDTO.builder()
                    .message("Se actualizo exitosamente la joya")
                    .action("UPDATED")
                    .build();
        else
            throw new RuntimeException("No pudo actualizarse la joya");

    }

    @Override
    public JoyaDTO getEntityById(Long id) {
        return null;
    }

    @Override
    public List<JoyaDTO> getAllEntities() {
        var list = joyasRepository.findAll();

        return list.stream().map(
                testCase -> mapper.map(testCase, JoyaDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteEntity(Long id) {
        return null;
    }

}
