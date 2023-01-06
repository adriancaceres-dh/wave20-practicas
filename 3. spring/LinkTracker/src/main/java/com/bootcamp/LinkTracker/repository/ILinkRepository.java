package com.bootcamp.LinkTracker.repository;

import com.bootcamp.LinkTracker.dto.LinkDTO;

import java.util.Optional;

public interface ILinkRepository {
    public LinkDTO save (LinkDTO link);
    public Optional<LinkDTO> findLinkDTOById(Integer id);
    public void delete (Integer id);

}
