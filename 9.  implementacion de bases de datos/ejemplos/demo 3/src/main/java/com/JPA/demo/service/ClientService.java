package com.JPA.demo.service;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.entity.Client;
import com.JPA.demo.entity.templates.CantInvoicesPerPersonTemplate;
import com.JPA.demo.repository.IClientRepository;
import com.JPA.demo.repository.IPersonRepository;
import com.JPA.demo.service.interfaces.IClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {

    @Autowired
    IClientRepository clientRepository;

    @Autowired
    IPersonRepository personRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public ClientDTO saveEntity(ClientDTO clientDTO) {

        var entity = mapper.map(clientDTO, Client.class);

        //var entityPerson = personRepository.findById(clientDTO.getPerson().getId()).get();
//
        //entity.setPerson(entityPerson);

        entity = clientRepository.save(entity);

        return mapper.map(entity, ClientDTO.class);
    }

    @Override
    public ClientDTO getEntityById(Integer integer) {
        return null;
    }

    @Override
    public List<ClientDTO> getAllEntities() {

        var entities = clientRepository.findAll();

        return entities.stream().map(
                e -> mapper.map(e, ClientDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        return null;
    }


    public List<CantInvoicesPerPersonTemplate> findby(){
        return clientRepository.calculateCantInvoicesPerPerson3();
    }

}
