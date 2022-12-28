package com.bootcamp.linkTracker.service;

import com.bootcamp.linkTracker.exceptions.NotAuthorizedException;
import com.bootcamp.linkTracker.exceptions.NotFoundException;
import com.bootcamp.linkTracker.linkDTO.LinkDTORequest;
import com.bootcamp.linkTracker.model.Link;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface ILinkService {

     Integer addLink (LinkDTORequest link);
     Set<Link> getLinks ();
     void invalidateLink (Integer id);
     String getUrlByLinkId (Integer linkId, String password);
}
