package com.bootcamp.Blog.service;

import com.bootcamp.Blog.dto.EntradaBlogRequestDTO;
import com.bootcamp.Blog.dto.EntradaBlogResponseDTO;
import com.bootcamp.Blog.model.EntradaBlog;

import java.util.List;

public interface IEntradaBlogService {

    public EntradaBlog dto2Entity(EntradaBlogRequestDTO dto);
    public EntradaBlogResponseDTO entity2dto(EntradaBlog entity);
    public EntradaBlogRequestDTO crearBlog (EntradaBlogRequestDTO dto);
    public List<EntradaBlogResponseDTO> buscarBlog (Long id);
}
