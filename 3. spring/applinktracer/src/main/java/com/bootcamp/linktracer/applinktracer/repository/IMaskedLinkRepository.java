package com.bootcamp.linktracer.applinktracer.repository;

import com.bootcamp.linktracer.applinktracer.model.MaskedLink;

import java.util.List;
import java.util.Optional;

public interface IMaskedLinkRepository {
    int addLink(String url, String password);
    List<MaskedLink> getLinks();
    boolean changeValid(int linkId, String password);
    boolean linkClicked(int linkId);
    MaskedLink getLink(int linkId);

}
