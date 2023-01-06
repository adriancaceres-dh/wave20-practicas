package com.bootcamp.LinkTracker.repository;

import com.bootcamp.LinkTracker.dto.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository{
    private final Map<Integer, LinkDTO> linkMap = new HashMap<>();

    public LinkDTO save (LinkDTO link){
        if (link.getLinkId() == null){
            link.setLinkId(linkMap.size());
        }
        linkMap.put(link.getLinkId(), link);
        return link;
    }

    public Optional<LinkDTO> findLinkDTOById(Integer id){
        return Optional.ofNullable(linkMap.get(id));
    }

    public void delete (Integer id){
        linkMap.remove(id);
    }


}
