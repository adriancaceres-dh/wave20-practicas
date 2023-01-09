package com.bootcamp.link_tracker.repository;

import com.bootcamp.link_tracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinksRepository implements ILInksRepository{

    private List<Link> links;

    public LinksRepository(){
        links = new ArrayList<>();
    }

    public List<Link> getLinks(){
        return this.links;
    }

    public Link findById(int id){
        return this.links.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
    }

    public Link addLink(Link link){
        this.links.add(link);
        return link;
    }

    public void removeLink(Link link){
        this.links.remove(link);
    }
}
