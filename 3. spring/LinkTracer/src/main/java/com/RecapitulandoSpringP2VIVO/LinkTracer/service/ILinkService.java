package com.RecapitulandoSpringP2VIVO.LinkTracer.service;

import com.RecapitulandoSpringP2VIVO.LinkTracer.dto.DtoRequest;
import com.RecapitulandoSpringP2VIVO.LinkTracer.model.Link;

public interface ILinkService {
    public int agregar(DtoRequest dtoRequest);
    public String reedireccionar(int id, String password);
    public int metrics(int id);
    public Link invalidate(int id);
}
