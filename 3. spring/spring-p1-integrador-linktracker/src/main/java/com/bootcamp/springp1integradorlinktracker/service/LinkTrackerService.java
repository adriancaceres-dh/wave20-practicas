package com.bootcamp.springp1integradorlinktracker.service;

import com.bootcamp.springp1integradorlinktracker.dto.request.LinkRequestDTO;
import com.bootcamp.springp1integradorlinktracker.dto.response.LinkResponseDTO;
import com.bootcamp.springp1integradorlinktracker.model.Link;
import com.bootcamp.springp1integradorlinktracker.repository.LinkRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LinkTrackerService {
    private static int id = 1;
    @Autowired
    private LinkRepository linkRepository;

    private final ModelMapper mapper = new ModelMapper();

    public LinkResponseDTO add(LinkRequestDTO link){
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        Link linkEntity = mapper.map(link,Link.class);
        linkEntity.setLinkID(id);
        id++;
        linkRepository.add(linkEntity);
        return mapper.map(linkEntity,LinkResponseDTO.class);
    }

}
