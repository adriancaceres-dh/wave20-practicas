package com.bootcamp.miniseries.controller;

import com.bootcamp.miniseries.dto.MiniSerieDTO;
import com.bootcamp.miniseries.dto.ResultDTO;
import com.bootcamp.miniseries.service.MiniSerieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiniSerieController {
    private MiniSerieService miniSerieService;

    public MiniSerieController(MiniSerieService miniSerieService) {
        this.miniSerieService = miniSerieService;
    }

    @PostMapping("/create")
    public ResultDTO createMiniSerie(@RequestBody MiniSerieDTO miniSerieDTO) {
        return miniSerieService.createSerie(miniSerieDTO);
    }
}
