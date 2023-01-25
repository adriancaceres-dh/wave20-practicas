package com.JPA.demo.service.interfaces;

import com.JPA.demo.dto.PersonDTO;
import com.JPA.demo.entity.Person;
import com.JPA.demo.service.interfaces.generics.ICrudService;

import java.util.List;

public interface IPersonService extends ICrudService<PersonDTO, Integer> {

    Double findby();
}
