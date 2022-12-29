package com.example.link_tracker.service;

import com.example.link_tracker.dto.LinkDto;
import com.example.link_tracker.dto.MessageLinkDto;
import com.example.link_tracker.entity.Link;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ILinkService {

    public List<LinkDto> findAll();

    public LinkDto findById(long id);

    public MessageLinkDto save(LinkDto linkDto);

    public void redirect(long id, String password, HttpServletResponse response);
}
