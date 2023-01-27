package com.example.Practica.HQL.service;

import com.example.Practica.HQL.model.Episode;
import com.example.Practica.HQL.repository.IEpisodeRepository;
import com.example.Practica.HQL.service.interfaces.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService implements IEpisodeService {

    @Autowired
    IEpisodeRepository iEpisodeRepository;

    public List<Episode> findAll(String actorName){
        if(actorName!=null)
            return iEpisodeRepository.findByFullNameLike(actorName);
        else
            return iEpisodeRepository.findAll();
    }
}
