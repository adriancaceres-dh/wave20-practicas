package com.linktracker.LinkTracker.services;


import com.linktracker.LinkTracker.dto.LinkDTO;
import com.linktracker.LinkTracker.exceptions.DoesntExistLinks;
import com.linktracker.LinkTracker.exceptions.InvalidatedUrlException;
import com.linktracker.LinkTracker.repositories.LinkRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LinkService {

    @Autowired
    LinkRepositoryImp linkRepositoryImp;

    public LinkDTO saveLink(String url) {
        if (linkRepositoryImp.saveLink(url) != null){
            return linkRepositoryImp.saveLink(url);
        }
        else{
            throw new InvalidatedUrlException("Url invalido :c !!");
        }
    }

    public String findLinkHashMap(int id) {
        if (linkRepositoryImp.findLinkHashMap(id) != null){
            return linkRepositoryImp.findLinkHashMap(id);
        }
        else{
            throw new DoesntExistLinks("No se encontro el link!!");
        }
    }
}
