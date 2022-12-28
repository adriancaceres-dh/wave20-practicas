package com.example.links.service;

import com.example.links.dto.request.LinkRequestDto;
import com.example.links.model.Link;

public interface LinkServiceInterface {
    boolean invalidateLink(long linkId);
    long addLink(LinkRequestDto linkRequestDto);
    Link getLinkForMetrics(long linkId);
    Link getLinkForRedirect(long linkId, String password);
}
