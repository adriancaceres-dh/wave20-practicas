package com.example.Empresa.Seguros.Practica.HQL.Vivo.service;

import com.example.Empresa.Seguros.Practica.HQL.Vivo.repository.ISiniestroRepository;
import com.example.Empresa.Seguros.Practica.HQL.Vivo.service.interfaces.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiniestroService implements ISiniestroService {

    @Autowired
    ISiniestroRepository iSiniestroRepository;

}
