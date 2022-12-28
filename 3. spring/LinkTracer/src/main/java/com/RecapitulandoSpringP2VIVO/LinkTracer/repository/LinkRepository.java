package com.RecapitulandoSpringP2VIVO.LinkTracer.repository;

import com.RecapitulandoSpringP2VIVO.LinkTracer.dto.DtoRequest;
import com.RecapitulandoSpringP2VIVO.LinkTracer.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinkRepository {
    Map<Integer, Link> linkRepository;
    int contador;

    public LinkRepository() {
        this.linkRepository = new HashMap<>();
        contador = 1;
    }

    public int agregar(DtoRequest dtoRequest)
    {
        linkRepository.put(contador,new Link(dtoRequest.getLink(),dtoRequest.getPassword()));
        return contador++;
    }

    public Link buscar(int id)
    {
        return linkRepository.get(id);
    }

    public Link invalidar(int id)
    {
        return linkRepository.remove(id);
    }
}
