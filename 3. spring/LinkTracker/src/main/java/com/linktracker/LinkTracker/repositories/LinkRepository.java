package com.linktracker.LinkTracker.repositories;

import com.linktracker.LinkTracker.dto.LinkDTO;

public interface LinkRepository {

    LinkDTO saveLink(String url);

    LinkDTO findLinkDto(int id);

    String findLinkHashMap(int id);


}
