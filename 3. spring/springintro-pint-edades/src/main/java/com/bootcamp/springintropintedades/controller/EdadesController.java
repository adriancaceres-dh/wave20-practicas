package com.bootcamp.springintropintedades.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculo_edad")
public class EdadesController {
    @GetMapping("/{dd}/{mm}/{aaaa}")
    public int calcularEdadPV(@PathVariable int dd,
                              @PathVariable int mm,
                              @PathVariable int aaaa) {
        int birthday = mm * 100 + dd;
        LocalDate now = LocalDate.now();
        int today = now.getMonthValue() * 100 + now.getDayOfMonth();

        int diff = now.getYear() - aaaa;
        return today >= birthday ? diff : diff - 1;
    }
}
