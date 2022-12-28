package com.bootcamp.linkTracker.controller;

import com.bootcamp.linkTracker.linkDTO.LinkDTORequest;
import com.bootcamp.linkTracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<Integer> addLink (@RequestBody LinkDTORequest link) {
        return ResponseEntity.ok(linkService.addLink(link));
    }

    @PostMapping("/link/{linkId}")
    public void invalidateLink (@PathVariable int linkId) {
        linkService.invalidateLink(linkId);
    }

    @GetMapping("/link/{linkId}")
    public String getLink (@PathVariable Integer linkId, @RequestParam String password) {
        return linkService.getUrlByLinkId (linkId, password);
    }

}
