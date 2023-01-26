package com.example.Empresa.Seguros.Practica.HQL.Vivo.service.interfaces;

import com.example.Empresa.Seguros.Practica.HQL.Vivo.dto.response.PatenteMarcaDTO;
import com.example.Empresa.Seguros.Practica.HQL.Vivo.dto.response.PatenteMarcaModeloDTO;
import com.example.Empresa.Seguros.Practica.HQL.Vivo.dto.response.PatenteMarcaModeloWithTotalLossDTO;

import java.util.List;

public interface IVehiculoService {

    public List<String> findAllPatentes();
    public List<PatenteMarcaDTO> findAllPatenteMarcaOrderedByAnhoFabricacion();
    public List<String> findPatentesRuedasGreaterThan4AndAnhoFabricacionInCurrentYear();
    public List<PatenteMarcaModeloDTO> findPatenteMarcaModeloWithExpensiveSiniestro();
    public PatenteMarcaModeloWithTotalLossDTO findPatenteMarcaModeloWithExpensiveSiniestroAndShowTotalLoss();

}
