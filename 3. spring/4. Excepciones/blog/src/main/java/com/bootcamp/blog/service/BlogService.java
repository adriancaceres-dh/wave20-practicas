package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.EntradaBlogRequestDto;
import com.bootcamp.blog.dto.EntradaBlogResponseDto;
import com.bootcamp.blog.dto.MensajeEntradaBlogResponseDto;
import com.bootcamp.blog.exceptions.BlogExistExceptions;
import com.bootcamp.blog.exceptions.BlogNotFoundException;
import com.bootcamp.blog.exceptions.ExceptionConfig;
import com.bootcamp.blog.model.EntradaBlog;
import com.bootcamp.blog.repository.BlogRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
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
                    blogRepository.getEntradasBlog().stream().filter(e -> e.getId().equals(id)).collect(Collectors.toList())
                            .stream().map(e -> mapper.map(e, EntradaBlogResponseDto.class)).collect(Collectors.toList());
            if(entradaBlogResponseDtos.size() > 0) {
                return entradaBlogResponseDtos;
            } else {
                throw new BlogNotFoundException("No existe el blog solicitado con identificador "+id);
                //return null;
            }
        }
    }

    @Override
    public MensajeEntradaBlogResponseDto addEntrada(EntradaBlogRequestDto entradaBlogRequestDto) {
        if( blogRepository.agregarEntradaBlog(
                mapper.map(entradaBlogRequestDto, EntradaBlog.class) ) ) {
            return new MensajeEntradaBlogResponseDto("Alta",entradaBlogRequestDto);
        } else {
            throw new BlogExistExceptions("entrada de blog ya existe");
            //return null;
        }
    }
}
