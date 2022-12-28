package com.bootcamp._excepciones_p1_vivo.service;

import com.bootcamp._excepciones_p1_vivo.dto.request.RequestBlogDto;
import com.bootcamp._excepciones_p1_vivo.dto.response.ResponseBlogDto;
import com.bootcamp._excepciones_p1_vivo.exceptions.IdNotFoundException;
import com.bootcamp._excepciones_p1_vivo.model.Blog;
import com.bootcamp._excepciones_p1_vivo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;

    public Long addBlogInId(RequestBlogDto blogDto){
        Blog blog = new Blog(blogDto.getTitulo(),blogDto.getNombre(),LocalDate.parse(blogDto.getAnio()+"-"+blogDto.getMes()+"-"+blogDto.getDia()));
        return blogRepository.addInId(blogDto.getId(),blog);
    }

    public ResponseBlogDto getBlogById (Long id){
        Blog blog = blogRepository.getAll().get(id);
        if(blog==null)throw new IdNotFoundException("No existe blog");
        return new ResponseBlogDto(blog.getTitulo(), blog.getNombre(), blog.getFechaPublicacion().toString());
    }

    public List<ResponseBlogDto> getAll(){
        return blogRepository.getAll().entrySet().stream()
                .map(x->new ResponseBlogDto(x.getValue().getTitulo(),x.getValue().getNombre(),x.getValue().getFechaPublicacion().toString()))
                .collect(Collectors.toList());
    }

}
