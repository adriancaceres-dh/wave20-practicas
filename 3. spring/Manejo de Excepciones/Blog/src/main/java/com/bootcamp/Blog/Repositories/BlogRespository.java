package com.bootcamp.Blog.Repositories;

import com.bootcamp.Blog.DTO.EntradaDto;
import com.bootcamp.Blog.Models.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BlogRespository {
    List<EntradaBlog> listaEntradasBlog = crearListaEntrada();

    private List<EntradaBlog> crearListaEntrada() {
        List<EntradaBlog> entradas = new LinkedList<>();
        entradas.add(EntradaBlog.crearEntradaBlog("12LK1", "Los días sin Milhouse", "Milhouse", LocalDate.of(2006, Month.JANUARY, 12)));
        entradas.add(EntradaBlog.crearEntradaBlog("12LK2", "Los meses sin Milhouse", "Milhouse", LocalDate.of(2006, Month.APRIL, 12)));
        return entradas;
    }

    public boolean agregarEntradaBlog(EntradaDto nuevaEntrada) {

        listaEntradasBlog.add(nuevaEntrada);
        return true;
    }

    // Buscamos la existencia de si existe una entradaBlog en nuestra BD a través de un idBlog.
    public boolean encontrarBlog(String idBlog) {
        EntradaBlog blogBuscado = listaEntradasBlog.stream().filter(x -> x.getIdBlog().equals(idBlog)).findAny().orElse(null);
        if (blogBuscado == null) {
            return false;
        }
        return true;
    }
}
