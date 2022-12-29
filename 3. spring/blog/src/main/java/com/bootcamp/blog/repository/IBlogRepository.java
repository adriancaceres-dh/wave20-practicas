package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    public List<EntradaBlog> getEntradasBlog();

    public boolean agregarEntradaBlog(EntradaBlog entradaBlog);
}
