package com.bootcamp.Blog.Services;

import com.bootcamp.Blog.DTO.EntradaDto;
import com.bootcamp.Blog.DTO.MensajeDto;
import com.bootcamp.Blog.Exceptions.BlogNullException;
import com.bootcamp.Blog.Models.EntradaBlog;
import com.bootcamp.Blog.Repositories.BlogRespository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EntradaBlogService implements  IEntradaBlogService{
    @Autowired
    BlogRespository repositoryEntradaBlog;

    ModelMapper modelMaper = new ModelMapper();

    public MensajeDto crearEntradaBlog(EntradaDto nuevaEntrada){

        if(nuevaEntrada == null){
            throw new BlogNullException("El objeto a crear no puede ser nulo. Vuelva a intentarlo.");
        }
        EntradaBlog agregarEnLista = modelMaper.map(nuevaEntrada, EntradaBlog.class); // No estoy seguro que funcione bien por el tema de los parámetros.
        agregarEnLista.setIdBlog();
        boolean agregado = repositoryEntradaBlog.agregarEntradaBlog(nuevaEntrada);
        MensajeDto devolverMensaje =  new MensajeDto();
    }
}
