package com.spring.blog.repository;

import com.spring.blog.dto.MensajeEntradaBlogResponseDto;
import com.spring.blog.exception.IdAlreadyExistException;
import com.spring.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository {

    private List<EntradaBlog> entradasBlog;

    public BlogRepository() {
        entradasBlog = new ArrayList<>();
        entradasBlog.add(new EntradaBlog("1","Hoy","Juan",
                LocalDate.of(2022,12,1)));
    }

    public List<EntradaBlog> getEntradasBlog() {
        return entradasBlog;
    }

    public boolean agregarEntradaBlog(EntradaBlog entradaBlog) {
        if(entradasBlog.stream().filter(e-> e.getId().equals(entradaBlog.getId())).count()>0 ){
            throw new IdAlreadyExistException("Ya existe el blog.");
        }
        entradasBlog.add(entradaBlog);
        return true;
    }



}
