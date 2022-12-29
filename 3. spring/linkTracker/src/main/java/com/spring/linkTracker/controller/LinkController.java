package com.spring.linkTracker.controller;

import com.spring.linkTracker.dto.request.RequestLinkDTO;
import com.spring.linkTracker.dto.response.ResponseLinkDTO;
import com.spring.linkTracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    ILinkService iLinkService;

    @PostMapping("/create_link")
    public ResponseEntity<ResponseLinkDTO> createLink(@RequestBody RequestLinkDTO requestLinkDTO){
        return new ResponseEntity<>(iLinkService.createLink(requestLinkDTO), HttpStatus.CREATED);
    }
    @GetMapping("/links")
    public ResponseEntity<List<ResponseLinkDTO>> getAllLinks(){
        return new ResponseEntity<>(iLinkService.getAllLinks(), HttpStatus.OK);
    }
    @GetMapping("/{linkId}")
    public RedirectView redirect(@PathVariable int linkId){
        return iLinkService.redirect(linkId);
    }
    @GetMapping("/{linkId}/{password}")
    public RedirectView redirectPassword(@PathVariable int linkId, @RequestParam String password){
        return iLinkService.redirect(linkId, password);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<ResponseLinkDTO> getMetricsLink(@PathVariable int linkId){
        return new ResponseEntity<>(iLinkService.getMetricsLink(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<ResponseLinkDTO> invalidateLink(@PathVariable int linkId){
        return new ResponseEntity<>(iLinkService.invalidateLink(linkId), HttpStatus.OK);
    }

    @PostMapping("/create_link_password")
    public ResponseEntity<ResponseLinkDTO> createLinkPassword(@RequestBody RequestLinkDTO requestLinkDTO){
        return new ResponseEntity<>(iLinkService.createLink(requestLinkDTO), HttpStatus.CREATED);
    }

}
