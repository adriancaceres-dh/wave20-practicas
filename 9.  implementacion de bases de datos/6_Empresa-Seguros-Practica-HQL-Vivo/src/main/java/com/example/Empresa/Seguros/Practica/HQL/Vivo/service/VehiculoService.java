package com.example.Empresa.Seguros.Practica.HQL.Vivo.service;

import com.example.Empresa.Seguros.Practica.HQL.Vivo.dto.response.PatenteMarcaDTO;
import com.example.Empresa.Seguros.Practica.HQL.Vivo.dto.response.PatenteMarcaModeloDTO;
import com.example.Empresa.Seguros.Practica.HQL.Vivo.dto.response.PatenteMarcaModeloWithTotalLossDTO;
import com.example.Empresa.Seguros.Practica.HQL.Vivo.repository.IVehiculoRepository;
import com.example.Empresa.Seguros.Practica.HQL.Vivo.service.interfaces.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    IVehiculoRepository iVehiculoRepository;

    public List<String> findAllPatentes(){
        return iVehiculoRepository.findAll().stream()
                .map(vehiculo -> vehiculo.getPatente())
                .collect(Collectors.toList());
    }

    public List<PatenteMarcaDTO> findAllPatenteMarcaOrderedByAnhoFabricacion(){
        return iVehiculoRepository.findAllByOrderByAnhoFabricacion().stream()
                .map(vehiculo -> new PatenteMarcaDTO(vehiculo.getPatente(), vehiculo.getMarca()))
                .collect(Collectors.toList());
    }

    public List<String> findPatentesRuedasGreaterThan4AndAnhoFabricacionInCurrentYear(){
        return iVehiculoRepository.findAllByCantRuedasGreaterThanAndAnhoFabricacionEquals(4, Year.now().getValue()).stream()
                .map(vehiculo -> vehiculo.getPatente())
                .collect(Collectors.toList());
    }

    public List<PatenteMarcaModeloDTO> findPatenteMarcaModeloWithExpensiveSiniestro(){
        return iVehiculoRepository.findAllExpensiveSiniestro(10000.0).stream()
                .map(vehiculo -> new PatenteMarcaModeloDTO(vehiculo.getPatente(), vehiculo.getMarca(), vehiculo.getModelo()))
                .collect(Collectors.toList());
    }

    public PatenteMarcaModeloWithTotalLossDTO findPatenteMarcaModeloWithExpensiveSiniestroAndShowTotalLoss(){
        List<PatenteMarcaModeloDTO> lista = iVehiculoRepository.findAllExpensiveSiniestro(10000.0).stream()
                .map(vehiculo -> new PatenteMarcaModeloDTO(vehiculo.getPatente(), vehiculo.getMarca(), vehiculo.getModelo()))
                .collect(Collectors.toList());
        Double totalLoss = iVehiculoRepository.findTotalLossMoreExpensiveThan(10000.0);
        return new PatenteMarcaModeloWithTotalLossDTO(totalLoss,lista);
    }

}
