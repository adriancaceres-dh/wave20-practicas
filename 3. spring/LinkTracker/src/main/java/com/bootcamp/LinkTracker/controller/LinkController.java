package com.bootcamp.LinkTracker.controller;

import com.bootcamp.LinkTracker.dto.LinkDTO;
import com.bootcamp.LinkTracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LinkController {
    @Autowired
    private ILinkService linkService;

    @PostMapping("create")
    public ResponseEntity<LinkDTO> create (@RequestBody LinkDTO linkDTO){
        return new ResponseEntity<>(linkService.create(linkDTO), HttpStatus.OK);
    }

    @GetMapping("link/{linkId}")
    public void redirect(@PathVariable Integer linkId, HttpServletResponse response) throws IOException {
        LinkDTO link = linkService.redirect(linkId);
        if (link != null){
            response.sendRedirect(link.getLink());
        } else {
            response.sendError(404);
        }
    }

    @GetMapping(value = "link/{linkId}", params = {"password"})
    public void redirect(@PathVariable Integer linkId, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        LinkDTO link = linkService.redirect(linkId, password);
        if (link != null){
            response.sendRedirect(link.getLink());
        } else {
            response.sendError(404);
        }
    }

    @GetMapping("metrics/{linkId}")
    public ResponseEntity<LinkDTO> getMetrics (@PathVariable Integer linkId){
        return new ResponseEntity<>(linkService.getMetrics(linkId), HttpStatus.OK);
    }

    @PostMapping("invalidate/{linkId}")
    public ResponseEntity<?> invalidate (@PathVariable Integer linkId){
        return new ResponseEntity<>(linkService.eliminarLink(linkId), HttpStatus.OK);
    }

}
