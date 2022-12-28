package com.bootcamp.springp1integradorlinktracker.repository;

import com.bootcamp.springp1integradorlinktracker.dto.response.LinkResponseDTO;
import com.bootcamp.springp1integradorlinktracker.model.Link;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements IRepository<Link> {
    private final List<Link> links = new ArrayList<>();
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<Link> filterByUrl(String url) {
        return null;
    }

    @Override
    public boolean contains(Link link) {
        return false;
    }

    @Override
    public boolean add(Link link) {
        return links.add(link);
    }
}
