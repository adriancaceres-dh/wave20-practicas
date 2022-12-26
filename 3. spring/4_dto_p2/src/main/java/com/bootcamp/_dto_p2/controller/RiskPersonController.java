package com.bootcamp._dto_p2.controller;

import com.bootcamp._dto_p2.dto.RiskPersonDTO;
import com.bootcamp._dto_p2.service.RiskPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RiskPersonController {

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDTO>> findRiskPerson(){
        List<RiskPersonDTO> riesgosos= RiskPersonService.getAllRiskPersonDTO();
        return new ResponseEntity<>(riesgosos, HttpStatus.OK);
    }

}
