package com.spring.linkTracker.repository;

import com.spring.linkTracker.dto.response.ResponseLinkDTO;
import com.spring.linkTracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class LinkRepository {
    private HashMap<Integer, Link> linkReposity = loadData();

    private HashMap<Integer, Link> loadData() {
        linkReposity = new HashMap<>();
        linkReposity.put(1, Link.builder().id(1).linkRedirect("https://www.google.com").countRedirect(0).build());

        return linkReposity;
    }
    public int getNextId(){
        return linkReposity.size() + 1;
    }

    public Link addLink(Link linkToAdd){
        int id =  getNextId();
        linkToAdd.setId(id);
        linkToAdd.setCountRedirect(0);
       // if(!linkToAdd.getPassword().isEmpty()) linkToAdd.setPassword(linkToAdd.getPassword());
        linkReposity.put(id, linkToAdd);
        return linkToAdd;
    }

    public List<Link> getLinks(){
        List<Link> result = new ArrayList<>();
        for(Integer key : linkReposity.keySet()){
            result.add(linkReposity.get(key));
        }
        return result;
    }
    public Link getLink(int linkId){
        return linkReposity.get(linkId);
    }

    public Link getLinkAndIncrease(int linkId){
        Link link = linkReposity.get(linkId);
        link.setCountRedirect(link.getCountRedirect() + 1);
        linkReposity.put(linkId, link);
        return link;
    }
    public Link updateLink(Link linkToUpdate){
        linkReposity.put(linkToUpdate.getId(), linkToUpdate);
        return linkToUpdate;
    }

}
