package com.bootcamp.link_tracker.controller;

import com.bootcamp.link_tracker.dto.request.LinkRequestDTO;
import com.bootcamp.link_tracker.dto.response.LinkResponseDTO;
import com.bootcamp.link_tracker.service.ILinksService;
import com.bootcamp.link_tracker.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkTrackerController {

    @Autowired
    private ILinksService linksService;

    @PostMapping("/addLink")
    public ResponseEntity<LinkResponseDTO> addLink(@RequestBody LinkRequestDTO linkDto){
        return ResponseEntity.ok().body(linksService.addLink(linkDto));
    }

    @GetMapping("link/{linkId}")
    public ResponseEntity<LinkResponseDTO> redirectLink(@PathVariable int linkId ,@RequestParam(required = false) String password){
        return ResponseEntity.ok().body(linksService.redirectLink(linkId, password));
    }

    @GetMapping("metrics/{linkId}")
    public ResponseEntity<Integer> metrics(@PathVariable int linkId){
        return ResponseEntity.ok().body(linksService.getRedirectCount(linkId));
    }

    @GetMapping("invalidate/{linkId}")
    public ResponseEntity<LinkResponseDTO> invalidate(@PathVariable int linkId){
        return ResponseEntity.ok().body(linksService.removeLink(linkId));
    }
}
