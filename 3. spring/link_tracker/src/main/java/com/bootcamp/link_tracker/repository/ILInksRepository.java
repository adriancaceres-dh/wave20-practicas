package com.bootcamp.link_tracker.repository;

import com.bootcamp.link_tracker.model.Link;

import java.util.List;

public interface ILInksRepository {

    List<Link> getLinks();
    Link findById(int id);
    Link addLink(Link link);
    void removeLink(Link link);
}
