package com.linktracker.LinkTracker.repositories;

import com.linktracker.LinkTracker.dto.LinkDTO;
import com.linktracker.LinkTracker.utils.Validators;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepositoryImp implements LinkRepository{

    Validators validators;
    private int autogenerate = 0;
    private HashMap<Integer, LinkDTO> mapLinks = new HashMap<>();


    @Override
    public LinkDTO saveLink(String url) {
        validators = new Validators();
        if(validators.validateUrl(url)){
            autogenerate +=1;
            mapLinks.put(autogenerate, LinkDTO.builder().id(autogenerate).link(url+ autogenerate).build());
            return findLinkDto(autogenerate);
        }
        else {
            return null;
        }
    }

    @Override
    public String findLinkHashMap(int id) {
        if (mapLinks.containsKey(id)){
            String idLink = mapLinks.get(id).getLink();
            return idLink;
        }
        else{
            return null;
        }
    }

    @Override
    public LinkDTO findLinkDto(int id) {
        return mapLinks.get(id);
    }



}
