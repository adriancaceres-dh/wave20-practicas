package com.bootcamp.Blog.service;

import com.bootcamp.Blog.Repository.IBlogRepository;
import com.bootcamp.Blog.dto.EntradaBlogRequestDTO;
import com.bootcamp.Blog.dto.EntradaBlogResponseDTO;
import com.bootcamp.Blog.dto.MensajeExceptionDTO;
import com.bootcamp.Blog.exception.AlredyExistException;
import com.bootcamp.Blog.exception.NotFoundException;
import com.bootcamp.Blog.model.EntradaBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntradaBlogService implements IEntradaBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    public EntradaBlog dto2Entity(EntradaBlogRequestDTO dto){
        EntradaBlog entradaBlog = new EntradaBlog();
        entradaBlog.setId(dto.getId());
        entradaBlog.setTituloDelBlog(dto.getTituloDelBlog());
        entradaBlog.setNombreDelAutor(dto.getNombreDelAutor());
        return entradaBlog;
    }

    public EntradaBlogResponseDTO entity2dto(EntradaBlog entity){
        EntradaBlogResponseDTO entradaBlogResponseDTO = new EntradaBlogResponseDTO();
        entradaBlogResponseDTO.setTituloDelBlog(entity.getTituloDelBlog());
        entradaBlogResponseDTO.setNombreDelAutor(entity.getNombreDelAutor());
        entradaBlogResponseDTO.setFechaDePublicacion(entity.getFechaDePublicacion().toString());
        return entradaBlogResponseDTO;
    }
    public EntradaBlogRequestDTO crearBlog (EntradaBlogRequestDTO dto){
        if (blogRepository.exist(dto.getId())){
            EntradaBlog entradaBlog = blogRepository.findById(dto.getId());
            throw new AlredyExistException(new MensajeExceptionDTO("El blog ya fue creado", entradaBlog.getFechaDePublicacion().toString()));
        }
        EntradaBlog entradaBlog = this.dto2Entity(dto);
        blogRepository.saveBlog(entradaBlog);
        return dto;
    }

    public List<EntradaBlogResponseDTO> buscarBlog (Long id){
        if (id == null){
            List<EntradaBlogResponseDTO> listaTotal = new ArrayList<>();
            for (EntradaBlog entradaBlog : blogRepository.findAll()){
                listaTotal.add(this.entity2dto(entradaBlog));
            }
            return listaTotal;
        }else {
            List<EntradaBlogResponseDTO> list = new ArrayList<>();
            if (!blogRepository.exist(id)){
                throw new NotFoundException(new MensajeExceptionDTO("El blog no existe"));
            }
            list.add(this.entity2dto(blogRepository.findById(id)));
            return list;
        }
    }


}
