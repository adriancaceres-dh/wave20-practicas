package com.bootcamp._Link_Tracker.service;

public interface ILinkService {

    public Long createLink (String url, String password);
    public String redirect (Long id, String password);
    public Integer getMetrics(Long id);
    public boolean invalidate(Long id);
}
