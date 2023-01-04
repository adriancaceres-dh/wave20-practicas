package com.bootcamp.prueba.repository;

import com.bootcamp.prueba.exception.ElementNotFoundException;
import com.bootcamp.prueba.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository {
    private final List<Link> linkList = new ArrayList<>();

    public Link addLink(String url) {
        Link newLink = Link.builder()
                .id(Integer.toString(linkList.size()))
                .timesRedirected(0)
                .valid(true)
                .url(url)
                .build();
        linkList.add(newLink);
        return newLink;
    }

    public Link getLinkById(String linkID) {
        return linkList.get(Integer.parseInt(linkID));
    }

    public boolean invalidateLink(String linkID) {
        try {
            Link invalidatonLink = linkList.get(Integer.parseInt(linkID));
            invalidatonLink.setValid(false);
            return true;
        } catch (ArrayIndexOutOfBoundsException exception) {
           throw new ElementNotFoundException("Link with ID: " + linkID + " not found");
        }
    }

    public void addRedirectCount(String linkID) {
        linkList.get(Integer.parseInt(linkID))
                .setTimesRedirected(linkList.get(Integer.parseInt(linkID)).getTimesRedirected() + 1);
    }
}
