package com.bootcamp._Link_Tracker.controller;

import com.bootcamp._Link_Tracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LinkController {
    @Autowired
    private ILinkService iLinkService;

    @PostMapping("/link")
    public ResponseEntity<Long> createLink(@RequestParam String url,
                                            @RequestParam(required=false) String password){
        return new ResponseEntity<>(iLinkService.createLink(url,password), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<String> redirectToLink(@PathVariable Long linkId,
                                                    @RequestParam(required = false) String password){
        return new ResponseEntity<>(iLinkService.redirect(linkId,password), HttpStatus.OK);
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<Integer> getMetrics(@PathVariable Long linkID){
        return new ResponseEntity<>(iLinkService.getMetrics(linkID), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<Boolean> invalidateLink(@PathVariable Long linkID){
        return new ResponseEntity<>(iLinkService.invalidate(linkID), HttpStatus.OK);
    }
}
