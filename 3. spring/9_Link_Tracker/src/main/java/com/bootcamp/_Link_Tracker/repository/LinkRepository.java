package com.bootcamp._Link_Tracker.repository;

import com.bootcamp._Link_Tracker.dto.MessageExceptionDTO;
import com.bootcamp._Link_Tracker.exceptions.IdNotFoundException;
import com.bootcamp._Link_Tracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public class LinkRepository implements ILinkRepository{

    private Set<Link> linkDB;

    public Long createId(){
        if(this.linkDB.isEmpty()) return 1L;
        return this.linkDB.stream()
                .map(link -> link.getId())
                .max(Long::compare)
                .get() + 1;
    }

    public boolean addLink(Link link){
        return this.linkDB.add(link);
    }

    public Link getById(Long id){
        Link link= linkDB.stream()
                .filter(l -> l.getId()==id)
                .findFirst().orElseThrow(()->new IdNotFoundException(new MessageExceptionDTO("NOT FOUND")));
        return link;
    }

    public boolean invalidate(Long id){
        getById(id).setValid(false);
        return true;
    }
}
