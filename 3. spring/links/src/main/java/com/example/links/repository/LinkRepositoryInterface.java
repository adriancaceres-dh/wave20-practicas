package com.example.links.repository;

import com.example.links.model.Link;

public interface LinkRepositoryInterface {
    boolean invalidateLink(long linkId);
    long addLink(Link newLink);
    Link getLink(long linkId);
    int getLinksAmount();
}
