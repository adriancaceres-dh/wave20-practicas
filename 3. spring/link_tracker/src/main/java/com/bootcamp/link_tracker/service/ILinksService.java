package com.bootcamp.link_tracker.service;

import com.bootcamp.link_tracker.dto.request.LinkRequestDTO;
import com.bootcamp.link_tracker.dto.response.LinkResponseDTO;

public interface ILinksService {

    LinkResponseDTO addLink(LinkRequestDTO linkRequestDTO);
    LinkResponseDTO redirectLink(int id, String password);
    int getRedirectCount(int id);
    LinkResponseDTO removeLink(int id);
}
