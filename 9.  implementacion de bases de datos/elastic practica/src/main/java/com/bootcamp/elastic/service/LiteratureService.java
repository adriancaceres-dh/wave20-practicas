package com.bootcamp.elastic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;

@Service
public class LiteratureService {
    
    @Autowired
    LiteratureRepository literatureRepository;


    public List<Literature> findByAuthorIs(String author) {
        return this.literatureRepository.findByAuthor(author);
    }

    public List<Literature> findByTitleContains(String title) {
        return this.literatureRepository.findByTitleContains(title);
    }

    public List<Literature> findByCantPagesGreaterThan(Integer canInteger){
        return this.literatureRepository.findByCantPagesGreaterThan(canInteger);
    }

}
