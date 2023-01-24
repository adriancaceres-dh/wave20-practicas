package com.wave20.jpa.service;


import com.wave20.jpa.repository.IPersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final IPersonRepository personRepository;

    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }


}
