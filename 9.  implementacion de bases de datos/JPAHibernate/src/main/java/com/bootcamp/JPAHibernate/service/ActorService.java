package com.bootcamp.JPAHibernate.service;

import com.bootcamp.JPAHibernate.repository.ActorRepository;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }
}
