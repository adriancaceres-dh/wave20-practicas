package com.JPA.demo.service.interfaces;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.entity.templates.CantInvoicesPerPersonTemplate;
import com.JPA.demo.service.interfaces.generics.ICrudService;

import java.util.List;

public interface IClientService extends ICrudService<ClientDTO, Integer> {

    List<CantInvoicesPerPersonTemplate> findby();

}
