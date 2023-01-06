package com.bootcamp.linktracer.applinktracer.service;

import com.bootcamp.linktracer.applinktracer.dto.InvalidateRequestDto;
import com.bootcamp.linktracer.applinktracer.dto.LinkDto;
import com.bootcamp.linktracer.applinktracer.dto.LinkStatsDto;
import com.bootcamp.linktracer.applinktracer.dto.ResponseDto;

import java.util.List;

public interface IMaskedLinkService {

    List<LinkDto> getLinks();
    LinkDto addLink(String url, String password);
    LinkDto redirect(int linkId);
    ResponseDto invalidateUrl(int linkId, InvalidateRequestDto invalidateRequestDto);
    LinkStatsDto urlStats(int linkId);
}
