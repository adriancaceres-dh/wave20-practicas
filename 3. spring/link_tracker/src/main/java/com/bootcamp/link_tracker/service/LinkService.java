package com.bootcamp.link_tracker.service;

import com.bootcamp.link_tracker.dto.*;
import com.bootcamp.link_tracker.exception.IncorrectPasswordException;
import com.bootcamp.link_tracker.exception.LinkNotFoundException;
import com.bootcamp.link_tracker.model.Link;
import com.bootcamp.link_tracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService {
    @Autowired
    LinkRepository linkRepository;

    public CreateLinkResponseDto createLink(CreateLinkRequestDto linkRequestDto) {
        Link linkRequest = new Link(linkRequestDto.getLink(), linkRequestDto.getPassword());
        return new CreateLinkResponseDto(linkRepository.createLink(linkRequest));
    }

    public RedirectLinkResponseDto getLinkByIdAndPassword(int linkId, String password) {
        Optional<Link> optionalLink = linkRepository.getLinkById(linkId);

        if(optionalLink.isEmpty())
            throw new LinkNotFoundException();

        if(!optionalLink.get().verifyPassword(password))
            throw new IncorrectPasswordException();

        optionalLink.get().addRedirection();

        return new RedirectLinkResponseDto(optionalLink.get().getLink());
    }

    public LinkMetricsResponseDto getLinkMetrics(int linkId) {
        Optional<Link> optionalLink = linkRepository.getLinkById(linkId);

        if(optionalLink.isEmpty())
            throw new LinkNotFoundException();

        return new LinkMetricsResponseDto(optionalLink.get().getRedirections());
    }

    public InvalidateLinkResponseDto postInvalidateLink(int linkId) {
        Link removedLink = linkRepository.invalidateLink(linkId);

        if(removedLink == null)
            throw new LinkNotFoundException();

        return new InvalidateLinkResponseDto("Link invalidated", removedLink.getLink());
    }
}
