package com.bootcamp._excepciones_p1_vivo.repository;

import com.bootcamp._excepciones_p1_vivo.exceptions.IdAlreadyUsedException;
import com.bootcamp._excepciones_p1_vivo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BlogRepository implements IBlogRepository{

    private HashMap<Long, Blog> blogsDB= new HashMap<>();


    public Long addInId(Long id, Blog blog){
        if (blogsDB.containsKey(id)) throw new IdAlreadyUsedException("No se pudo agregar.");
        blogsDB.put(id,blog);
        return id;
    }

    public HashMap<Long,Blog> getAll(){
        return this.blogsDB;
    }

}
