package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.config.MessagesUtil;
import com.bootcamp.linktracker.exception.LinkNotFoundException;
import com.bootcamp.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLinkRepository implements LinkRepository {
    private List<Link> links;
    private static long currentId = 0;

    public InMemoryLinkRepository() {
        links = new ArrayList<>();
    }

    @Override
    public Link get(long id) {

        return links.stream().filter(link -> link.getId() == id).findFirst()
                .orElseThrow(() -> new LinkNotFoundException(MessagesUtil.LINK_NOT_FOUND));
    }

    @Override
    public boolean update(Link link) {
        return true;
    }

    @Override
    public boolean delete(Link link) {
        return links.remove(link);
    }

    @Override
    public boolean delete(long id) {
        return links.removeIf(link -> link.getId() == id);
    }

    @Override
    public boolean create(Link link) {
        link.setId(currentId++);
        return links.add(link);
    }
}
