package com.bootcamp.ejercicio_link_tracker.repository;

import com.bootcamp.ejercicio_link_tracker.dto.request.LinkDTO;
import com.bootcamp.ejercicio_link_tracker.exception.ValidationException;
import com.bootcamp.ejercicio_link_tracker.model.Link;
import com.bootcamp.ejercicio_link_tracker.repository.interfaces.ILinkRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository
{
    private HashMap<Integer,Link> linkHashMap;

    public LinkRepository() {
        linkHashMap = new HashMap<>();
        linkHashMap.put(0,new Link(0,0,"https://google.com"));
    }



    @Override
    public Link getById(int id) {
        return linkHashMap.get(id);
    }

    @Override
    public Link create(LinkDTO linkDTO) throws ValidationException {
        if(linkDTO.getUrl() == null || linkDTO.getUrl().length() < 4){
            throw new ValidationException("El URL no es válido");
        }
        int id = linkHashMap.size() + 1;
        Link link = new Link(id,0,linkDTO.getUrl());
        linkHashMap.put(id,link);
        return link;
    }

    @Override
    public Link update(Link link) {
        this.linkHashMap.put(link.getId(),link);
        return link;
    }

    @Override
    public boolean delete(int id) {
        Link link = getById(id);
        if(link != null){
            this.linkHashMap.remove(id);
            return true;
        }else{
            return false;
        }
    }
}
