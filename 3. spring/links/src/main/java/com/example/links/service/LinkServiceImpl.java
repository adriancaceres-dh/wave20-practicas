package com.example.links.service;

import com.example.links.dto.request.LinkRequestDto;
import com.example.links.dto.response.LinkResponseDto;
import com.example.links.exception.BadRequestException;
import com.example.links.exception.NotFoundException;
import com.example.links.model.Link;
import com.example.links.repository.LinkRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

@Service
public class LinkServiceImpl implements LinkServiceInterface {

    private final LinkRepositoryInterface linkRepository;

    @Autowired
    public LinkServiceImpl(LinkRepositoryInterface linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public boolean invalidateLink(long linkId) {
        if (linkRepository.invalidateLink(linkId)) {
            return true;
        }
        throw new NotFoundException("Link doesn't exist");
    }

    @Override
    public long addLink(LinkRequestDto linkRequestDto) {
        try {
            URL url = new URL(linkRequestDto.getUrl());
            Link newLink = new Link(linkRepository.getLinksAmount() + 1, url, linkRequestDto.getPassword());
            linkRepository.addLink(newLink);
            return newLink.getId();
        } catch (MalformedURLException e) { //
            throw new BadRequestException("Given url is not valid");
        }
    }

    @Override
    public Link getLinkForMetrics(long linkId) {
        Link linkFound = linkRepository.getLink(linkId);
        if (linkFound == null) {
            throw new NotFoundException("Link doesn't exist");
        }
        return linkFound;
    }

    @Override
    public Link getLinkForRedirect(long linkId, String password) {
        Link linkFound = linkRepository.getLink(linkId);

        if (linkFound == null) {
            throw new NotFoundException("Link doesn't exist");
        }
        if (!linkFound.isValid()) {
            throw new BadRequestException("Link has been invalidated, can't make the redirect");
        }
        if (Objects.isNull(linkFound.getPassword())) {
            linkFound.addRedirect();
            return linkFound;
        }
        if (!linkFound.getPassword().equals(password)) {
            throw new BadRequestException("Given password doesn't match the saved one");
        }
        linkFound.addRedirect();
        return linkFound;
    }
}
