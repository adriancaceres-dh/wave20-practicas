package com.spring.blog.service;

import com.spring.blog.dto.EntradaBlogRequestDto;
import com.spring.blog.dto.EntradaBlogResponseDto;
import com.spring.blog.dto.MensajeEntradaBlogResponseDto;
import com.spring.blog.exception.IdAlreadyExistException;
import com.spring.blog.exception.IdNotFoundException;
import com.spring.blog.model.EntradaBlog;
import com.spring.blog.repository.BlogRepository;
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
                throw new IdNotFoundException("No se pudo encontrar el blog.");
            }
        }
    }

    @Override
    public MensajeEntradaBlogResponseDto addEntrada(EntradaBlogRequestDto entradaBlogRequestDto) {
        if( blogRepository.agregarEntradaBlog(
                mapper.map(entradaBlogRequestDto, EntradaBlog.class) ) ) {
            return new MensajeEntradaBlogResponseDto("Alta",entradaBlogRequestDto);
        }
        return null;
    }
}
