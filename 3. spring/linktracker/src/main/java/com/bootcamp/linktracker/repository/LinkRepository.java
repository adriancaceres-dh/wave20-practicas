package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;

public interface LinkRepository {
    Link get(long id);

    boolean update(Link link);

    boolean delete(Link link);

    boolean delete(long id);

    boolean create(Link link);
}
