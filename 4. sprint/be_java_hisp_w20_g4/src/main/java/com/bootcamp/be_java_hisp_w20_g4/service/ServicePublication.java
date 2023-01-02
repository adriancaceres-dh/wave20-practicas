package com.bootcamp.be_java_hisp_w20_g4.service;

import com.bootcamp.be_java_hisp_w20_g4.repository.IProductRepository;
import com.bootcamp.be_java_hisp_w20_g4.repository.IPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePublication implements  IServicePublication{

    @Autowired
    IPublicationRepository publicationRepository;

    @Autowired
    IProductRepository productRepository;

    public String addPublication(String publication){
        return "";
    }




}
