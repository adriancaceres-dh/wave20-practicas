package com.bootcamp.ejercicio_link_tracker.repository.interfaces;

import com.bootcamp.ejercicio_link_tracker.dto.request.LinkDTO;
import com.bootcamp.ejercicio_link_tracker.exception.ValidationException;
import com.bootcamp.ejercicio_link_tracker.model.Link;

import java.util.List;

public interface ILinkRepository
{
    Link getById(int id);
    Link create(LinkDTO linkDTO) throws ValidationException;
    Link update(Link link);
    boolean delete(int id);

}
