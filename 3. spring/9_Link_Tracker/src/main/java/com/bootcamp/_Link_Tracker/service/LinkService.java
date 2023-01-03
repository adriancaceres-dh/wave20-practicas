package com.bootcamp._Link_Tracker.service;

import com.bootcamp._Link_Tracker.dto.MessageExceptionDTO;
import com.bootcamp._Link_Tracker.exceptions.InvalidLinkException;
import com.bootcamp._Link_Tracker.exceptions.InvalidPasswordException;
import com.bootcamp._Link_Tracker.model.Link;
import com.bootcamp._Link_Tracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Provider;
@Service
public class LinkService implements ILinkService {
    @Autowired
    ILinkRepository iLinkRepository;

    public Long createLink (String url, String password){
        Long id= iLinkRepository.createId();
        iLinkRepository.addLink(new Link(id,url,password,0,true));
        return id;
    }

    public String redirect (Long id, String password){
        Link link = iLinkRepository.getById(id);
        if(link.getPassword().equals(password) && link.isValid()){
            link.setRedirects(link.getRedirects()+1);
            return link.getUrl();
        }else if(!link.isValid()) {
            throw new InvalidLinkException(new MessageExceptionDTO("INVESTIGAR REDIRECT"));
        }else{
            throw new InvalidPasswordException(new MessageExceptionDTO("INVALID PASSWORD"));
        }
    }

    public Integer getMetrics(Long id){
        return iLinkRepository.getById(id).getRedirects();
    }

    public boolean invalidate(Long id){
        return iLinkRepository.invalidate(id);
    }
}
