package com.bootcamp.linktracer.applinktracer.controller;

import com.bootcamp.linktracer.applinktracer.dto.*;
import com.bootcamp.linktracer.applinktracer.service.IMaskedLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LinkController {

    @Autowired
    IMaskedLinkService maskedLinkService;

    @PostMapping("/newlink")
    public LinkDto newLink(@RequestBody RequestDto requestBody ){
        return maskedLinkService.addLink(requestBody.getUrl(),requestBody.getPassword());
    }

    @GetMapping("/link/{linkId}")
    public void redirect(@PathVariable int linkId, HttpServletResponse httpServletResponse){

        httpServletResponse.setHeader("location",maskedLinkService.redirect(linkId).getUrl());
        httpServletResponse.setStatus(302);

    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkStatsDto> linkStats(@PathVariable int linkId){
        return new ResponseEntity<>(maskedLinkService.urlStats(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<ResponseDto> invalidLink(@PathVariable int linkId,@RequestBody InvalidateRequestDto invalidateRequest){
        return new ResponseEntity<>(maskedLinkService.invalidateUrl(linkId,invalidateRequest),HttpStatus.OK);
    }

    @GetMapping("/Links")
    public List<LinkDto> getLinks(){
        return maskedLinkService.getLinks();
    }

}
