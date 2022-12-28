package com.bootcamp.linkTracker.service;

import com.bootcamp.linkTracker.exceptions.NotAuthorizedException;
import com.bootcamp.linkTracker.exceptions.NotFoundException;
import com.bootcamp.linkTracker.linkDTO.LinkDTORequest;
import com.bootcamp.linkTracker.model.Link;
import com.bootcamp.linkTracker.repo.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LinkService implements ILinkService {

    @Autowired
    ILinkRepository linkRepository;

    public Integer addLink (LinkDTORequest link) {
        return linkRepository.addLink (link.getUrl(), link.getPassword());
    }

    public Set<Link> getLinks() {
        return linkRepository.getLinks();
    }

    public void invalidateLink (Integer id){
        linkRepository.invalidateLink(id);
    }

    public String getUrlByLinkId (Integer linkId, String password) {
        Link link = linkRepository.getLinkById(linkId);
        if (!link.getPassword().equals(password)) {
            throw new NotAuthorizedException("No autorizado");
        }else if (!link.isActive()) {
            throw new NotFoundException("Link no encontrado");
        }
        return link.getUrl();
    }
}
