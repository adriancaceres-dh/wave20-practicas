package com.bootcamp.blog.repository;

import com.bootcamp.blog.dto.EntradaBlogResponseDto;
import com.bootcamp.blog.dto.MensajeEntradaBlogResponseDto;
import com.bootcamp.blog.dto.MensajeExeptionDto;
import com.bootcamp.blog.exeption.IdExistExeption;
import com.bootcamp.blog.model.EntradaBlog;
import org.springframework.http.HttpStatus;
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
        if(entradasBlog.stream().anyMatch(e -> e.getId().equals(entradaBlog.getId()))){
           return false;
        }
        entradasBlog.add(entradaBlog);
        return true;
    }

}
