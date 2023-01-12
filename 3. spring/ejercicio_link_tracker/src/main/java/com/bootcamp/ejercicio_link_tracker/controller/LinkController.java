package com.bootcamp.ejercicio_link_tracker.controller;

import com.bootcamp.ejercicio_link_tracker.dto.request.LinkDTO;
import com.bootcamp.ejercicio_link_tracker.dto.response.LinkCounterDTO;
import com.bootcamp.ejercicio_link_tracker.dto.response.LinkResponseDTO;
import com.bootcamp.ejercicio_link_tracker.exception.ValidationException;
import com.bootcamp.ejercicio_link_tracker.service.interfaces.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/link")
public class LinkController
{
    @Autowired
    private ILinkService linkService;

    @PostMapping
    public ResponseEntity<LinkResponseDTO> create (@RequestBody LinkDTO link) throws ValidationException {
        return ResponseEntity.ok(linkService.create(link));
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<?> redirect(@PathVariable int linkId) throws ValidationException, URISyntaxException {
        String url = linkService.redirect(linkId).getURL();
        URI uri = new URI(url);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkCounterDTO> getMetrics(@PathVariable int linkId) throws ValidationException {
        return ResponseEntity.ok(linkService.getMetrics(linkId));
    }
    @GetMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidate(@PathVariable int linkId) throws ValidationException {
        return ResponseEntity.ok(linkService.invalidate(linkId));
    }
}
