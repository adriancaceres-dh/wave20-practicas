package com.bootcamp.prueba.service;

import com.bootcamp.prueba.dto.LinkDTO;
import com.bootcamp.prueba.model.Link;
import com.bootcamp.prueba.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class LinkService {

    @Autowired
    LinkRepository linkRepository;

    public LinkDTO addLink(String link) {
        Link newLink = linkRepository.addLink(link);
        return LinkDTO.builder()
                .id(newLink.getId())
                .url(newLink.getUrl())
                .build();
    }

    public ResponseEntity<Object> redirect(String linkID) {
        linkRepository.addRedirectCount(linkID);
        Link redirectLink = linkRepository.getLinkById(linkID);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create(redirectLink.getUrl()));

        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    public int getLinkStats(String linkID) {
        return linkRepository.getLinkById(linkID).getTimesRedirected();
    }

    public boolean invalidateLink(String linkID) {
        return linkRepository.invalidateLink(linkID);
    }
}
