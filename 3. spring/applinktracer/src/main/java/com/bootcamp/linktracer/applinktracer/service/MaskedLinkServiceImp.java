package com.bootcamp.linktracer.applinktracer.service;

import com.bootcamp.linktracer.applinktracer.dto.InvalidateRequestDto;
import com.bootcamp.linktracer.applinktracer.dto.LinkDto;
import com.bootcamp.linktracer.applinktracer.dto.LinkStatsDto;
import com.bootcamp.linktracer.applinktracer.dto.ResponseDto;
import com.bootcamp.linktracer.applinktracer.exception.OperationFailedException;
import com.bootcamp.linktracer.applinktracer.model.MaskedLink;
import com.bootcamp.linktracer.applinktracer.repository.IMaskedLinkRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaskedLinkServiceImp implements IMaskedLinkService{
    private final ModelMapper mapper = new ModelMapper();
    @Autowired
    IMaskedLinkRepository linkRepository;

    public MaskedLinkServiceImp() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    public List<LinkDto> getLinks(){
        return linkRepository.getLinks().stream()
                .map(l -> mapper.map(l,LinkDto.class)).collect(Collectors.toList());

    }

    @Override
    public LinkDto addLink(String url, String password){
        int linkId = linkRepository.addLink(url,password);
        if(linkId ==0 ){
            return new LinkDto(linkId,"Falló");
        }
        return new LinkDto(linkId,url);
    }

    @Override
    public LinkDto redirect(int linkId) {
            MaskedLink maskedLink = getOneLink(linkId);
            if(!maskedLink.isValid()){
                throw new OperationFailedException("link is not valid, please try again");
            }
            if(linkRepository.linkClicked(linkId)){
                return mapper.map(maskedLink,LinkDto.class);
            }
            else {
                throw new OperationFailedException("Could not redirect for specified url");
            }

    }

    @Override
    public LinkStatsDto urlStats(int linkId) {
        MaskedLink linkFound= linkRepository.getLink(linkId);
        return LinkStatsDto.builder().url(linkFound.getUrl()).clicked(linkFound.getClicked()).build();
    }

    @Override
    public ResponseDto invalidateUrl(int linkId,InvalidateRequestDto invalidateRequestDto){
         if(linkRepository.changeValid(linkId,invalidateRequestDto.getPassword())){
             MaskedLink link = linkRepository.getLink(linkId);
             return ResponseDto.builder().changed(true).url(link.getUrl()
                     ).valid(link.isValid()).build();
         }
         else {
             throw new OperationFailedException("Cannot complete operation");
         }
    }

    public  MaskedLink getOneLink(int linkId){
        return linkRepository.getLink(linkId);
    }
}
