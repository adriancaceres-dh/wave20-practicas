package com.JPA.demo.service;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.repository.IClientRepository;
import com.JPA.demo.repository.IProductRepository;
import com.JPA.demo.service.interfaces.IClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    IClientRepository clientRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public ClientDTO saveEntity(ClientDTO personDTO) {
        return null;
    }

    @Override
    public ClientDTO getEntityById(Integer integer) {
        return null;
    }

    @Override
    public List<ClientDTO> getAllEntities() {
        return null;
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        return null;
    }
}
