package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.LinkRequestDTO;
import com.bootcamp.linktracker.dto.LinkResponseDTO;
import com.bootcamp.linktracker.dto.OperationResultDTO;
import com.bootcamp.linktracker.exception.LinkNotFoundException;
import com.bootcamp.linktracker.exception.WrongOrEmptyPasswordException;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.repository.InMemoryLinkRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class LinkService {
    @Autowired
    private InMemoryLinkRepository linkRepository;

    public OperationResultDTO<LinkResponseDTO> createLink(LinkRequestDTO link) {
        Link linkObject = convertToObject(link);
        linkRepository.create(linkObject);
        return new OperationResultDTO<>(
                Optional.of(new LinkResponseDTO(linkObject)),
                "Link successfully created",
                true);
    }

    public String getRedirectionLink(long id, Optional<String> password) {
        Link link = linkRepository.get(id);
        validate(link, password);
        if (!link.getIsValid()) {
            throw new LinkNotFoundException("No valid link found for given id");
        }
        link.addVisit();
        linkRepository.update(link);
        return linkRepository.get(id).getLink();
    }

    public OperationResultDTO<LinkResponseDTO> getLinkMetrics(long id, Optional<String> password) {
        Link link = linkRepository.get(id);
        validate(link, password);
        return new OperationResultDTO(
                Optional.of(new LinkResponseDTO(link)),
                "Metrics for link with id " + id,
                true);
    }

    public OperationResultDTO<LinkResponseDTO> invalidateLink(long id, Optional<String> password) {
        Link link = linkRepository.get(id);
        validate(link, password);
        link.setIsValid(false);
        linkRepository.update(link);
        return new OperationResultDTO<>(
                Optional.of(new LinkResponseDTO(link)),
                "Link with id " + id + " invalidated",
                true);
    }

    private Link convertToObject(LinkRequestDTO link) {
        if (link.getPassword() != null)
            return new Link(link.getLink(), link.getPassword());
        else
            return new Link(link.getLink());
    }

    private void validate(Link link, Optional<String> password) {
        if (link.getPassword().isPresent()) {
            if (password.isEmpty() || !link.getPassword().get().equals(Hashing.sha256()
                    .hashString(password.get(), StandardCharsets.UTF_8)
                    .toString())) {
                throw new WrongOrEmptyPasswordException("Invalid access to link with id " + link.getId());
            }
        }
    }
}
