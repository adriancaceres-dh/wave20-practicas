package com.bootcamp.BlogYoutuber.repositories;

import com.bootcamp.BlogYoutuber.dto.EntradaBlogDTO;
import com.bootcamp.BlogYoutuber.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository {

    List<EntradaBlog> listaBlogs;
    public EntradaBlogRepository(){
        listaBlogs = new ArrayList<>();
        listaBlogs.add(new EntradaBlog(1,"Cumpleaños","Diego", LocalDate.now()));
        listaBlogs.add(new EntradaBlog(2,"Cumpleaños","Maria", LocalDate.of(2019,2,6)));
        listaBlogs.add(new EntradaBlog(3,"Cumpleaños","Luz", LocalDate.of(2022,7,9)));
        listaBlogs.add(new EntradaBlog(4,"Cumpleaños","Adrían", LocalDate.of(2006,2,8)));
    }

    public List<EntradaBlog> getBlogs(){
        return listaBlogs;
    }
    public void addBlog(EntradaBlog blog){
        listaBlogs.add(blog);
    }

}
