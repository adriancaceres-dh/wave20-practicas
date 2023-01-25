package com.JPA.demo.service.interfaces;

import com.JPA.demo.dto.PersonDTO;
import com.JPA.demo.service.interfaces.generics.ICrudService;

public interface IPersonService extends ICrudService<PersonDTO, Integer> {

}
