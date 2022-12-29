package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.EntradaBlogRequestDto;
import com.bootcamp.blog.dto.EntradaBlogResponseDto;
import com.bootcamp.blog.dto.MensajeEntradaBlogResponseDto;
import com.bootcamp.blog.dto.MensajeExeptionDto;
import com.bootcamp.blog.exeption.IdExistExeption;
import com.bootcamp.blog.exeption.IdNotFoundExeption;
import com.bootcamp.blog.model.EntradaBlog;
import com.bootcamp.blog.repository.BlogRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService{

    private final ModelMapper mapper = new ModelMapper();
    @Autowired
    BlogRepository blogRepository;

    public BlogService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public List<EntradaBlogResponseDto> getEntradaBlogResponseDtos(String id) {
        if (id == null) {
            return blogRepository.getEntradasBlog().stream()
                    .map(e -> mapper.map(e, EntradaBlogResponseDto.class))
                    .collect(Collectors.toList());
        } else {
            List<EntradaBlogResponseDto> entradaBlogResponseDtos =
                    blogRepository.getEntradasBlog().stream()
                            .filter(e -> e.getId().equals(id))
                            .map(e -> mapper.map(e, EntradaBlogResponseDto.class))
                            .collect(Collectors.toList());
            if(entradaBlogResponseDtos.size() > 0) {
                return entradaBlogResponseDtos;
            } else {
                throw new IdNotFoundExeption(new MensajeExeptionDto("La entrada no existe",HttpStatus.NOT_FOUND));
            }
        }
    }

    @Override
    public MensajeEntradaBlogResponseDto addEntrada(EntradaBlogRequestDto entradaBlogRequestDto) {
        if(blogRepository.agregarEntradaBlog(mapper.map(entradaBlogRequestDto, EntradaBlog.class))){
            return new MensajeEntradaBlogResponseDto("Alta",entradaBlogRequestDto);
        } else {
            throw new IdExistExeption(new MensajeExeptionDto("La entrada ya existe", HttpStatus.NOT_FOUND));

        }

    }
}
