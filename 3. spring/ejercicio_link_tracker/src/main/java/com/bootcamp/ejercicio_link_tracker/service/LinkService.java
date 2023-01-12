package com.bootcamp.ejercicio_link_tracker.service;

import com.bootcamp.ejercicio_link_tracker.dto.request.LinkDTO;
import com.bootcamp.ejercicio_link_tracker.dto.response.LinkCounterDTO;
import com.bootcamp.ejercicio_link_tracker.dto.response.LinkResponseDTO;
import com.bootcamp.ejercicio_link_tracker.exception.ValidationException;
import com.bootcamp.ejercicio_link_tracker.model.Link;
import com.bootcamp.ejercicio_link_tracker.repository.interfaces.ILinkRepository;
import com.bootcamp.ejercicio_link_tracker.service.interfaces.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {
    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public LinkResponseDTO create(LinkDTO linkDTO) throws ValidationException {
        Link link = linkRepository.create(linkDTO);
        return new LinkResponseDTO(link.getId());
    }

    @Override
    public LinkCounterDTO getMetrics(int linkId) throws ValidationException {
        return new LinkCounterDTO(linkRepository.getById(linkId).getCounter());
    }

    @Override
    public Link redirect(int linkId) throws ValidationException {
        try{
            Link link = linkRepository.getById(linkId);
            if(link != null){
                link.setCounter(link.getCounter()+1);
                linkRepository.update(link);
            }
            return link;
        }catch (Exception exception){
            throw new ValidationException("LinkId no valido");
        }
    }

    @Override
    public boolean invalidate(int linkId) {
        return linkRepository.delete(linkId);
    }
}
