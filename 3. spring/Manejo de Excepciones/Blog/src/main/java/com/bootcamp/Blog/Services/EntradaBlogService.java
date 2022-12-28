package com.bootcamp.Blog.Services;

import com.bootcamp.Blog.DTO.EntradaDto;
import com.bootcamp.Blog.DTO.MensajeDto;
import com.bootcamp.Blog.Models.EntradaBlog;
import com.bootcamp.Blog.Repositories.BlogRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EntradaBlogService {
    @Autowired
    BlogRespository repositoryEntradaBlog;

    public MensajeDto crearEntradaBlog(EntradaDto nuevaEntrada){

        if(nuevaEntrada == null){
            throw new
        }
        boolean agregado = repositoryEntradaBlog.agregarEntradaBlog(nuevaEntrada);
        MensajeDto devolverMensaje =  new MensajeDto();
    }
}
