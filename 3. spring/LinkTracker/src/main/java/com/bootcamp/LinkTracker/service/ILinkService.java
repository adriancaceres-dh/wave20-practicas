package com.bootcamp.LinkTracker.service;

import com.bootcamp.LinkTracker.dto.LinkDTO;

public interface ILinkService {
    public LinkDTO create (LinkDTO link);
    public LinkDTO redirect(Integer linkId);
    public LinkDTO redirect(Integer linkId, String password);
    public LinkDTO getMetrics(Integer linkId);
    public boolean eliminarLink(Integer linkId);

}
