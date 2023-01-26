package com.JPA.demo.service.interfaces;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.service.interfaces.generics.ICrudService;

public interface IClientService extends ICrudService<ClientDTO, Integer> {
}
