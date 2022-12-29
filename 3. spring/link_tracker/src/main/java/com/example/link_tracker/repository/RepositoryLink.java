package com.example.link_tracker.repository;

import com.example.link_tracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryLink implements IRepositoryLink{

    List<Link> links;

    public RepositoryLink(){
        links = new ArrayList<>();
        links.add(new Link(1L,"https://www.google.com/?hl=es",0,"google"));
        links.add(new Link(2L,"https://codigoshttp.com/",0,"mdn"));
        links.add(new Link(3L,"https://open.spotify.com/",0,"spotify"));
        links.add(new Link(4L,"https://es-la.facebook.com/",0,"facebook"));
    }
    @Override
    public List<Link> findAll() {
        return links;
    }

    @Override
    public Optional<Link> findById(long id) {
        return links.stream().filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public void save(Link link) {
        links.add(link);
    }
}
