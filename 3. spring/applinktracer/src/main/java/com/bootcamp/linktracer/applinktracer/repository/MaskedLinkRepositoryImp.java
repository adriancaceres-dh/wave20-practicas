package com.bootcamp.linktracer.applinktracer.repository;

import com.bootcamp.linktracer.applinktracer.exception.AlreadyExistException;
import com.bootcamp.linktracer.applinktracer.exception.NotFoundException;
import com.bootcamp.linktracer.applinktracer.model.MaskedLink;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MaskedLinkRepositoryImp implements IMaskedLinkRepository {

    private List<MaskedLink> maskedLinkList;

    public MaskedLinkRepositoryImp() {
        this.maskedLinkList = new ArrayList<>();
    }

    @Override
    public int addLink(String url, String password) {

        if(maskedLinkList.stream().noneMatch(m -> m.getUrl().equals(url))){
            MaskedLink newMaskedLink = new MaskedLink(maskedLinkList.size()+1,url,password,true );
            maskedLinkList.add(newMaskedLink);
            return newMaskedLink.getId();
        }

        throw new AlreadyExistException("url already existed");
    }

    @Override
    public List<MaskedLink> getLinks() {

        return this.maskedLinkList;
    }

    @Override
    public boolean linkClicked(int linkId){
        MaskedLink maskedLink = getLink(linkId);
        maskedLink.setClicked(maskedLink.getClicked()+1);
        return true;
    }

    @Override
    public boolean changeValid(int linkId, String password){
        for (MaskedLink maskedLink: maskedLinkList) {
            if(maskedLink.getId() == linkId && maskedLink.getPassword().equals(password)){
                if(maskedLink.isValid()){
                    maskedLink.setValid(false);
                    return true;
                }
            }
        }
        throw new NotFoundException("Not url found");
    }

    @Override
    public MaskedLink getLink(int linkId){
        return this.maskedLinkList.stream().filter(link -> link.getId() == linkId).findFirst()
                .orElseThrow(() -> new NotFoundException("Not url found"));
    }

}
