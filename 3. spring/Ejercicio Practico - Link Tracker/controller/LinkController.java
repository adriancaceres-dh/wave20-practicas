package com.bootcamp.prueba.controller;

import com.bootcamp.prueba.dto.LinkDTO;
import com.bootcamp.prueba.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {

    @Autowired
    LinkService linkService;

    @PostMapping("/add")
    public LinkDTO addLink(@RequestBody String url) {
        return linkService.addLink(url);
    }

    @GetMapping(value = "redirect/{linkID}")
    public ResponseEntity<Object> redirect(@PathVariable String linkID) {
        return linkService.redirect(linkID);
    }

    @GetMapping("/metrics/{linkID}")
    public int getLinkStats(String linkID) {
        return linkService.getLinkStats(linkID);
    }

    @PostMapping("/invalidate/{linkID}")
    public boolean invalidateLink(String linkID) {
        return linkService.invalidateLink(linkID);
    }
}
