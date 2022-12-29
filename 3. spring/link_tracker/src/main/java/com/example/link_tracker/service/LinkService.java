package com.example.link_tracker.service;

import com.example.link_tracker.dto.LinkDto;
import com.example.link_tracker.dto.MessageLinkDto;
import com.example.link_tracker.entity.Link;
import com.example.link_tracker.exception.InvalidRedirectException;
import com.example.link_tracker.exception.LinkAlreadyExist;
import com.example.link_tracker.repository.IRepositoryLink;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkService implements ILinkService{

    ModelMapper modelMapper;

    public LinkService(){
        modelMapper = new ModelMapper();
    }
    @Autowired
    private IRepositoryLink iRepositoryLink;

    @Override
    public List<LinkDto> findAll() {
        return iRepositoryLink.findAll().stream().map(e -> modelMapper.map(e,LinkDto.class)).collect(Collectors.toList());
    }

    @Override
    public LinkDto findById(long id) {
        return modelMapper.map(iRepositoryLink.findById(id).get(),LinkDto.class);
    }

    @Override
    public MessageLinkDto save(LinkDto linkDto) {


        if(iRepositoryLink.findAll().stream().anyMatch(e -> e.getId() == linkDto.getId() || e.getUrl().equals(linkDto.getUrl()))){
            System.out.println(linkDto);

            throw new LinkAlreadyExist(new MessageLinkDto("id no encontrado",linkDto));
        }

        iRepositoryLink.save(modelMapper.map(linkDto, Link.class));

        return new MessageLinkDto("OK!",linkDto);
    }

    @Override
    public void redirect(long id, String password, HttpServletResponse response) {
        if(!verifyRedirect(id,password)){
            throw new InvalidRedirectException("id or paswword wrong");
        }

        Link link = iRepositoryLink.findById(id).get();
        link.setNumberOfRedirections(link.getNumberOfRedirections() + 1);

        try {
            response.sendRedirect(link.getUrl());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    private boolean verifyRedirect(long id, String password) {

        LinkDto linkDto = findById(id);

        if(linkDto == null || !password.equals(linkDto.getPassword())){
            return false;
        }

        return true;

    }
}
