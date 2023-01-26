package com.example.Empresa.Seguros.Practica.HQL.Vivo.controller;

import com.example.Empresa.Seguros.Practica.HQL.Vivo.dto.response.PatenteMarcaDTO;
import com.example.Empresa.Seguros.Practica.HQL.Vivo.dto.response.PatenteMarcaModeloDTO;
import com.example.Empresa.Seguros.Practica.HQL.Vivo.dto.response.PatenteMarcaModeloWithTotalLossDTO;
import com.example.Empresa.Seguros.Practica.HQL.Vivo.service.interfaces.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehiculoController {

    @Autowired
    IVehiculoService iVehiculoService;

    @GetMapping("/patents")
    public ResponseEntity<List<String>> listarPatentes(){
        return ResponseEntity.ok(iVehiculoService.findAllPatentes());
    }

    @GetMapping("/patentsBrands")
    public ResponseEntity<List<PatenteMarcaDTO>> listPatentsAndBrandsOrderedByYear(){
        return ResponseEntity.ok(iVehiculoService.findAllPatenteMarcaOrderedByAnhoFabricacion());
    }

    @GetMapping("/patentsMoreFourWheelsThisYear")
    public ResponseEntity<List<String>> listPatentsMoreFourWheelsFromThisYear(){
        return ResponseEntity.ok(iVehiculoService.findPatentesRuedasGreaterThan4AndAnhoFabricacionInCurrentYear());
    }

    @GetMapping("/patentsBrandsModelsExpensiveLoss")
    public ResponseEntity<List<PatenteMarcaModeloDTO>> listPatentsBrandsAndModelsWithExpensiveLoss(){
        return ResponseEntity.ok(iVehiculoService.findPatenteMarcaModeloWithExpensiveSiniestro());
    }

    @GetMapping("/patentsBrandsModelsExpensiveLossTotal")
    public ResponseEntity<PatenteMarcaModeloWithTotalLossDTO> listPatentsBrandsAndModelsWithExpensiveLossTotal(){
        return ResponseEntity.ok((iVehiculoService.findPatenteMarcaModeloWithExpensiveSiniestroAndShowTotalLoss()));
    }

}
