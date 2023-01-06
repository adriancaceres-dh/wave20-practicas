package com.bootcamp.LinkTracker.service;

import com.bootcamp.LinkTracker.dto.LinkDTO;
import com.bootcamp.LinkTracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService implements ILinkService{
    @Autowired
    private ILinkRepository linkRepository;

    public LinkDTO create (LinkDTO link){
        return linkRepository.save(link);
    }

    public LinkDTO redirect(Integer linkId){
        Optional<LinkDTO> link = linkRepository.findLinkDTOById(linkId);
        link.ifPresent(this::sumMetric);
        return link.orElse(null);
    }

    public LinkDTO redirect(Integer linkId, String password){
        Optional<LinkDTO> link = linkRepository.findLinkDTOById(linkId);
        LinkDTO resultado = null;
        if (link.isPresent()){
            resultado = verificarPassword(link.get(), password);
        }
        return resultado;
    }
    public LinkDTO getMetrics(Integer linkId){
        Optional<LinkDTO> linkDTO = linkRepository.findLinkDTOById(linkId);
        return linkDTO.orElse(null);
    }
    public boolean eliminarLink(Integer linkId){
        Optional<LinkDTO> linkDTO = linkRepository.findLinkDTOById(linkId);
        linkDTO.ifPresent(dto -> linkRepository.delete(dto.getLinkId()));
        return true;
    }
    private void sumMetric (LinkDTO linkDTO){
        linkDTO.sumCount();
        linkRepository.save(linkDTO);
    }
    private LinkDTO verificarPassword (LinkDTO linkDTO, String password){
        LinkDTO link = null;
        if (linkDTO.getPassword() != null && linkDTO.getPassword().equals(password)){
            link = linkDTO;
            linkDTO.sumCount();
            linkRepository.save(linkDTO);
        }
        return link;
    }

}
