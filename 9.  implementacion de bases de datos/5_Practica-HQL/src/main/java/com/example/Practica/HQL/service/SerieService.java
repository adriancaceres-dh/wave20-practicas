package com.example.Practica.HQL.service;

import com.example.Practica.HQL.model.Serie;
import com.example.Practica.HQL.repository.ISerieRepository;
import com.example.Practica.HQL.repository.IUserRepository;
import com.example.Practica.HQL.service.interfaces.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService {

    @Autowired
    ISerieRepository iSerieRepository;

    public List<Serie> findAll(Integer cantSeasons){
        if(cantSeasons!=null)
            return iSerieRepository.findBySeasonsSizeGreaterThan(cantSeasons);
        else
            return iSerieRepository.findAll();
    }
}
