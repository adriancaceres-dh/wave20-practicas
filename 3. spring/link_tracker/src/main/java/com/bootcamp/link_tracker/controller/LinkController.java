package com.bootcamp.link_tracker.controller;

import com.bootcamp.link_tracker.dto.*;
import com.bootcamp.link_tracker.exception.IncorrectPasswordException;
import com.bootcamp.link_tracker.exception.LinkNotFoundException;
import com.bootcamp.link_tracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {
    @Autowired
    LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<CreateLinkResponseDto> postLink(@RequestBody CreateLinkRequestDto linkRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(linkService.createLink(linkRequestDto));
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> getLinkRedirection(@PathVariable int linkId, @RequestParam(required = false) String password) {
        if(password == null)
            throw new IncorrectPasswordException();

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(linkService.getLinkByIdAndPassword(linkId, password).getLink())).build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricsResponseDto> getLinkMetrics(@PathVariable int linkId) {
        return ResponseEntity.status(HttpStatus.OK).body(linkService.getLinkMetrics(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<InvalidateLinkResponseDto> postInvalidateLink(@PathVariable int linkId) {
        return ResponseEntity.status(HttpStatus.OK).body(linkService.postInvalidateLink(linkId));
    }

    @ExceptionHandler
    public ResponseEntity<LinkMessageDto> linkNotFoundException(LinkNotFoundException exception) {
        return ResponseEntity.status(404).body(new LinkMessageDto(exception.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<LinkMessageDto> incorrectPasswordException(IncorrectPasswordException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LinkMessageDto(exception.getMessage()));
    }
}
