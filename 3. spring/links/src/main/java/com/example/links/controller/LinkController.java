package com.example.links.controller;


import com.example.links.dto.request.LinkRequestDto;
import com.example.links.dto.response.InvalidateLinkResponseDto;
import com.example.links.dto.response.LinkResponseDto;
import com.example.links.dto.response.NewLinkResponseDto;
import com.example.links.model.Link;
import com.example.links.service.LinkServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LinkController {

    private final LinkServiceInterface linkService;

    @Autowired
    public LinkController(LinkServiceInterface linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<NewLinkResponseDto> addLink(@RequestBody LinkRequestDto linkRequestDto) {
        long newId = linkService.addLink(linkRequestDto);
        return ResponseEntity.ok().body(new NewLinkResponseDto(newId));
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkResponseDto> getLinkForMetrics(@PathVariable long linkId) {
        Link linkFound = linkService.getLinkForMetrics(linkId);
        return ResponseEntity.ok()
                .body(new LinkResponseDto(
                        linkFound.getId(),
                        linkFound.getUrl().toString(),
                        linkFound.isValid(),
                        linkFound.getAmountOfRedirects()
                ));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<InvalidateLinkResponseDto> invalidateLink(@PathVariable long linkId) {
        linkService.invalidateLink(linkId);
        return ResponseEntity.ok().body(new InvalidateLinkResponseDto(linkId));
    }

    @GetMapping(value = "/link/{linkId}", params = {"password"})
    public void redirectToLink(
            @RequestParam(required = false) String password,
            @PathVariable long linkId,
            HttpServletResponse httpServletResponse
    ) {
        String url = linkService.getLinkForRedirect(linkId, password).getUrl().toString();
        httpServletResponse.setHeader("Location", url);
        httpServletResponse.setStatus(302);
    }

}
