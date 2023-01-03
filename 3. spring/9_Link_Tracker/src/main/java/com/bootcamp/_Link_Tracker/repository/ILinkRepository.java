package com.bootcamp._Link_Tracker.repository;

import com.bootcamp._Link_Tracker.model.Link;

public interface ILinkRepository {

    public Long createId();
    public boolean addLink(Link link);
    public Link getById(Long id);
    public boolean invalidate(Long id);
}
