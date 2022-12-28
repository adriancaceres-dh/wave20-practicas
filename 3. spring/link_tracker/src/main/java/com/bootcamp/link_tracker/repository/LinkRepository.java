package com.bootcamp.link_tracker.repository;

import com.bootcamp.link_tracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepository {
    private final Map<Integer, Link> links;
    private int idCount;

    public LinkRepository() {
        this.idCount = 0;
        this.links = new HashMap<>(){{
            put(++idCount, new Link("https://www.google.com", "google"));
            put(++idCount, new Link("https://www.mercadolibre.com.mx", "meli-mx"));
        }};
    }

    public Map<Integer, Link> getLinks() {
        return links;
    }

    public Optional<Link> getLinkById(int id) {
        return links.containsKey(id) ? Optional.of(links.get(id)) : Optional.empty();
    }

    public int createLink(Link link) {
        links.put(++idCount, link);
        return idCount;
    }

    public Link invalidateLink(int linkId) {
        return links.remove(linkId);
    }
}
