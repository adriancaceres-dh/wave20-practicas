package com.bootcamp.ejercicio_link_tracker.service.interfaces;

import com.bootcamp.ejercicio_link_tracker.dto.request.LinkDTO;
import com.bootcamp.ejercicio_link_tracker.dto.response.LinkCounterDTO;
import com.bootcamp.ejercicio_link_tracker.dto.response.LinkResponseDTO;
import com.bootcamp.ejercicio_link_tracker.exception.ValidationException;
import com.bootcamp.ejercicio_link_tracker.model.Link;

public interface ILinkService
{
    LinkResponseDTO create(LinkDTO link) throws ValidationException;
    LinkCounterDTO getMetrics(int linkId) throws ValidationException;
    Link redirect(int linkId) throws ValidationException;
    boolean invalidate(int linkId);

}
