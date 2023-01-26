package com.example.seguros.service.interfaces;

import com.example.seguros.dto.SiniestroDto;
import com.example.seguros.dto.templates.TemplateMatriculaMarcaYModelo;
import com.example.seguros.model.Siniestro;
import com.example.seguros.service.interfaces.generic.ICrudService;

import java.util.List;

public interface ISiniestroService extends ICrudService<SiniestroDto,Integer> {
    public List<TemplateMatriculaMarcaYModelo> getAllMarcaModeloPatente();
}
