package com.bootcamp.Blog.Repository;

import com.bootcamp.Blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class BlogRepository implements IBlogRepository{

    private List<EntradaBlog> entradaBlogList;

    public BlogRepository(){
        entradaBlogList = new ArrayList<>();
    }
    @Override
    public EntradaBlog saveBlog(EntradaBlog entradaBlog){
        entradaBlogList.add(entradaBlog);
        return entradaBlog;
    }
    @Override
    public List<EntradaBlog> findAll(){
        return this.entradaBlogList;
    }
    @Override
    public boolean exist(Long id){
        Optional<EntradaBlog> resultado = entradaBlogList.stream().filter(entradaBlog -> entradaBlog.getId().equals(id)).findAny();
        return resultado.isPresent();
    }
    @Override
    public EntradaBlog findById(Long id){
        return entradaBlogList.stream().filter(entradaBlog -> entradaBlog.getId().equals(id))
                .findFirst().orElse(null);
    }


}
