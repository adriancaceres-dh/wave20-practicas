package com.RecapitulandoSpringP2VIVO.LinkTracer.service;

import com.RecapitulandoSpringP2VIVO.LinkTracer.dto.DtoRequest;
import com.RecapitulandoSpringP2VIVO.LinkTracer.model.Link;
import com.RecapitulandoSpringP2VIVO.LinkTracer.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {
    @Autowired
    LinkRepository linkRepository;

    public int agregar(DtoRequest dtoRequest)
    {
        return linkRepository.agregar(dtoRequest);
    };
    public String reedireccionar(int id, String password)
    {
        Link link = linkRepository.buscar(id);

        if(link != null)
        {
            if(link.getPassword().equals(password))
            {
                link.incrementarVisitas();
                return link.getLink();
            }
        }
        return null;
    };

    public int metrics(int id)
    {
        Link link = linkRepository.buscar(id);

        if(link!=null)
        {
            return link.getVisitas();
        }

        return 0;
    };
    public Link invalidate(int id)
    {
        return linkRepository.invalidar(id);
    };

}
