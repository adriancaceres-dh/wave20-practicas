package com.spring.linkTracker.service;

import com.spring.linkTracker.dto.request.RequestLinkDTO;
import com.spring.linkTracker.dto.response.ResponseLinkDTO;
import com.spring.linkTracker.exception.LinkNotFoundException;
import com.spring.linkTracker.exception.PasswordNotCorrectException;
import com.spring.linkTracker.exception.UrlNotValidException;
import com.spring.linkTracker.model.Link;
import com.spring.linkTracker.repository.LinkRepository;
import com.spring.linkTracker.utils.UrlHelper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkService implements ILinkService{
    @Autowired
    LinkRepository linkRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseLinkDTO createLink(RequestLinkDTO requestLinkDTO) {
        if(UrlHelper.checkUrl(requestLinkDTO.getLink())) {
            Link linkToAdd = Link.builder().linkRedirect(requestLinkDTO.getLink()).build();
            return modelMapper.map(linkRepository.addLink(linkToAdd), ResponseLinkDTO.class);
        }else {
            throw new UrlNotValidException("El link ingresado no es valido");
        }
    }

    @Override
    public List<ResponseLinkDTO> getAllLinks() {
        List<ResponseLinkDTO> responseLinkDTOList = new ArrayList<>();
        for(Link link : linkRepository.getLinks()){
            responseLinkDTOList.add(modelMapper.map(link, ResponseLinkDTO.class));
        }
        return responseLinkDTOList;
    }

    @Override
    public RedirectView redirect(int linkId) {
        Link link = linkRepository.getLinkAndIncrease(linkId);
        if(link == null) throw new LinkNotFoundException("Link no encontrado.");
        return new RedirectView(link.getLinkRedirect());
    }
    @Override
    public RedirectView redirect(int linkId, String password) {
        Link link = linkRepository.getLinkAndIncrease(linkId);
        if(link == null) throw new LinkNotFoundException("Link no encontrado.");
        if(link.getPassword().equals(password)){
            return new RedirectView(link.getLinkRedirect());
        }else{
            throw new PasswordNotCorrectException("Contraseña incorrecta");
        }
    }

    @Override
    public ResponseLinkDTO getMetricsLink(int linkId) {
        Link link = linkRepository.getLink(linkId);
        if(link == null) throw new LinkNotFoundException("Link no encontrado.");
        return modelMapper.map(link, ResponseLinkDTO.class);
    }

    @Override
    public ResponseLinkDTO invalidateLink(int linkId) {
        Link link = linkRepository.getLink(linkId);
        if(link == null) throw new LinkNotFoundException("Link no encontrado.");
        link.setLinkRedirect("");
        return modelMapper.map(linkRepository.updateLink(link), ResponseLinkDTO.class);
    }

}
