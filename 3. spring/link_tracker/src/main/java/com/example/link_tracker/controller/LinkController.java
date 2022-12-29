package com.example.link_tracker.controller;

import com.example.link_tracker.dto.LinkDto;
import com.example.link_tracker.dto.MessageLinkDto;
import com.example.link_tracker.entity.Link;
import com.example.link_tracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.IIOException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

@RestController
public class LinkController {

    @Autowired
    ILinkService iLinkService;

    @PostMapping("/save")
    public ResponseEntity<MessageLinkDto> save(@RequestBody LinkDto linkDto){


        MessageLinkDto messageLinkDto = iLinkService.save(linkDto);
        return new ResponseEntity<>(messageLinkDto, HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public void redirect(@PathVariable Long id, @RequestParam String password,HttpServletResponse response) {

        iLinkService.redirect(id,password,response);


    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkDto> metrics(HttpServletResponse response, @PathVariable Long id) {

        LinkDto linkDto = iLinkService.findById(id);
        return new ResponseEntity<>(linkDto, HttpStatus.OK);

    }

}
