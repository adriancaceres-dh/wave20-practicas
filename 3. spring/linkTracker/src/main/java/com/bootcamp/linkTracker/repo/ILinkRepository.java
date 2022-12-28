package com.bootcamp.linkTracker.repo;

import com.bootcamp.linkTracker.model.Link;

import java.util.Set;

public interface ILinkRepository {

    Integer addLink (String url, String password);
    Set<Link> getLinks ();
    boolean invalidateLink (Integer id);

    Link getLinkById (Integer id);
}
