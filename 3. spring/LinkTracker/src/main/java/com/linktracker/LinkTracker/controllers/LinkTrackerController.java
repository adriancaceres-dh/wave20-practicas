package com.linktracker.LinkTracker.controllers;


import com.linktracker.LinkTracker.dto.LinkDTO;
import com.linktracker.LinkTracker.services.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class LinkTrackerController {


    @Autowired
    LinkService linkService;


    @PostMapping("/saveLink")
    private ResponseEntity<LinkDTO> saveLink(@RequestBody String url){
        return new ResponseEntity<>(linkService.saveLink(url), HttpStatus.OK);
    }


    @GetMapping("/link/{linkId}")
    private void redirectUrl(@PathVariable int linkId, HttpServletResponse httpServletResponse) throws IOException {
        if (linkService.findLinkHashMap(linkId) != null) {
            httpServletResponse.sendRedirect(linkService.findLinkHashMap(linkId));
        } else {
            httpServletResponse.sendError(404, "Error en el redireccionamiento!!");
        }
    }
}
