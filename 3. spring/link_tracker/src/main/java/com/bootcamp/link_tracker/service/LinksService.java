package com.bootcamp.link_tracker.service;

import com.bootcamp.link_tracker.dto.request.LinkRequestDTO;
import com.bootcamp.link_tracker.dto.response.LinkResponseDTO;
import com.bootcamp.link_tracker.exception.BadRequestException;
import com.bootcamp.link_tracker.model.Link;
import com.bootcamp.link_tracker.repository.ILInksRepository;
import com.bootcamp.link_tracker.repository.LinksRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinksService implements ILinksService{

    @Autowired
    private ILInksRepository linksRepository;
    ModelMapper mapper = new ModelMapper();
    public LinkResponseDTO addLink(LinkRequestDTO linkRequestDTO){
        Link link = linksRepository.addLink(new Link(linkRequestDTO.getLink(), linkRequestDTO.getPassword()));
        return mapper.map(link, LinkResponseDTO.class);
    }

    public LinkResponseDTO redirectLink(int id, String password){
        Link link = idValidator(id);
        LinkResponseDTO linkResponseDTO = mapper.map(link, LinkResponseDTO.class);

        if(link.getPassword() == null){
            link.incrementCantRedirect();
            return linkResponseDTO;
        }

        if(password == null) throw new BadRequestException("Falta enviar password");
        if(!link.getPassword().equals(password)) throw new BadRequestException("Password incorrecto");
        link.incrementCantRedirect();
        return linkResponseDTO;
    }

    public int getRedirectCount(int id){
        Link link = idValidator(id);
        return link.getCantRedirect();
    }

    public LinkResponseDTO removeLink(int id){
        Link link = idValidator(id);
        linksRepository.removeLink(link);
        return mapper.map(link, LinkResponseDTO.class);
    }

    private Link idValidator(int id){
        Link link = linksRepository.findById(id);
        if(link == null) throw new BadRequestException("No existe un link con el id enviado");
        return link;
    }
}
