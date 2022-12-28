package com.bootcamp.linkTracker.repo;

import com.bootcamp.linkTracker.exceptions.NotFoundException;
import com.bootcamp.linkTracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class LinkRepository implements ILinkRepository {

    private static Set<Link> links;
    private static Integer counter = 0;

    LinkRepository () {
        links = new HashSet<>();
    }

    public Integer addLink(String url, String password) {
        links.add(new Link(++counter, url, password, true));
        return counter;
    }

    public Set<Link> getLinks () {
        return links;
    }

    public Link getLinkById (Integer id) {
        return links.stream()
                .filter(link -> link.getId().equals(id))
                .findFirst().orElseThrow(() -> new NotFoundException("Link no encontrado"));
    }

    public boolean invalidateLink (Integer id) {
        try {
            links.stream()
                    .filter(link -> link.getId().equals(id))
                    .findFirst().get().setActive(false);
        } catch (Exception e) {
            throw new NotFoundException ("El link a invalidar no existe");
        }
        return true;
    }
}
