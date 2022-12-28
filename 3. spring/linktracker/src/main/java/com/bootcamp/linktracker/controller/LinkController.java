package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.LinkRequestDTO;
import com.bootcamp.linktracker.dto.LinkResponseDTO;
import com.bootcamp.linktracker.dto.OperationResultDTO;
import com.bootcamp.linktracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class LinkController {
    @Autowired
    private LinkService linkService;

    @PostMapping("/link")
    public OperationResultDTO<LinkResponseDTO> createLink(@RequestBody LinkRequestDTO linkRequestDTO) {
        return linkService.createLink(linkRequestDTO);
    }

    @GetMapping("/link/{id}")
    public ModelAndView redirect(@PathVariable long id, @RequestParam Optional<String> password) {
        return new ModelAndView("redirect:" + linkService.getRedirectionLink(id, password));
    }

    @GetMapping("/metrics/{id}")
    public OperationResultDTO<LinkResponseDTO> viewMetrics(@PathVariable long id, @RequestParam Optional<String> password) {
        return linkService.getLinkMetrics(id, password);
    }

    @PostMapping("/invalidate/{id}")
    public OperationResultDTO<LinkResponseDTO> invalidateLink(@PathVariable long id, @RequestParam Optional<String> password) {
        return linkService.invalidateLink(id, password);
    }

}
