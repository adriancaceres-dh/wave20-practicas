package com.example.link_tracker.repository;

import com.example.link_tracker.entity.Link;

import java.util.List;
import java.util.Optional;

public interface IRepositoryLink {

    List<Link> findAll();

    Optional<Link> findById(long id);

    void save(Link link);

}
