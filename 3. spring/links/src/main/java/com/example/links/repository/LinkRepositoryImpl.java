package com.example.links.repository;

import com.example.links.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements LinkRepositoryInterface {

    private final List<Link> links = new ArrayList<>();

    @Override
    public boolean invalidateLink(long linkId) {
        Link linkFound = getLink(linkId);
        if (linkFound == null) {
            return false;
        }
        linkFound.setValid(false);
        return true;
    }

    @Override
    public long addLink(Link newLink) {
        links.add(newLink);
        return newLink.getId();
    }

    @Override
    public Link getLink(long linkId) {
        return links.stream()
                .filter(l -> l.getId() == linkId)
                .findAny()
                .orElse(null);
    }

    @Override
    public int getLinksAmount() {
        return links.size();
    }
}
