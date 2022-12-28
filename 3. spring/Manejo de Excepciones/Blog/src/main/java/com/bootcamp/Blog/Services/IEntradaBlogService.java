package com.bootcamp.Blog.Services;

import com.bootcamp.Blog.DTO.EntradaDto;
import com.bootcamp.Blog.DTO.MensajeDto;
import org.modelmapper.ModelMapper;

public interface IEntradaBlogService {
    MensajeDto crearEntradaBlog(EntradaDto nuevaEntrada);
}
