package com.bootcamp.MiniSeries.controller;

import com.bootcamp.MiniSeries.model.MiniSerie;
import com.bootcamp.MiniSeries.service.IMiniSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MiniserieController {
    @Autowired
    private IMiniSerieService miniSerieService;

    @PostMapping("/create")
    public String createMiniserie(@RequestBody MiniSerie miniserie){
        this.miniSerieService.saveMiniSerie(miniserie);
        return "Mini serie agregada con éxito";
    }

    @GetMapping("/miniseries")
    public List<MiniSerie> getMiniSeries (){
        return this.miniSerieService.getMiniSeries();
    }

    @PostMapping("/edit/{id}")
    public MiniSerie editMiniSerie(@PathVariable long id,
                                   @RequestParam ("name") String newName,
                                   @RequestParam ("rating") Double rating,
                                   @RequestParam ("amountOfAwards") int amountOfAwards ){
        MiniSerie miniSerie = this.miniSerieService.findMiniSerie(id);
        miniSerie.setName(newName);
        miniSerie.setRating(rating);
        miniSerie.setAmountOfAwards(amountOfAwards);
        this.miniSerieService.saveMiniSerie(miniSerie);

        return miniSerie;
    }

    @PostMapping("/delete/{id}")
    public String deleteMiniserie(@PathVariable long id){
        this.miniSerieService.deleteMiniSerie(id);

        return "Mini serie eliminada con éxito";
    }
}
