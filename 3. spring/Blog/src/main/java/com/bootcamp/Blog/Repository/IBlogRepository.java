package com.bootcamp.Blog.Repository;

import com.bootcamp.Blog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    public EntradaBlog saveBlog(EntradaBlog entradaBlog);
    public List<EntradaBlog> findAll();
    public boolean exist(Long id);
    public EntradaBlog findById(Long id);
}
