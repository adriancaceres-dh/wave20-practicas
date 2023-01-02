package com.bootcamp.BlogYoutuber.services;

import com.bootcamp.BlogYoutuber.dto.EntradaBlogDTO;
import com.bootcamp.BlogYoutuber.model.EntradaBlog;
import com.bootcamp.BlogYoutuber.repositories.EntradaBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntradaBlogService {

    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    EntradaBlogRepository entradaBlogRepository;

    public boolean addBlog(EntradaBlogDTO blog){

      List<EntradaBlog> blogExiste = entradaBlogRepository.getBlogs().stream().filter(entradaBlog -> entradaBlog.getId()== blog.getId()).collect(Collectors.toList());
      if(blogExiste.isEmpty()){
          EntradaBlog entrada = modelMapper.map(blog, EntradaBlog.class);
          entradaBlogRepository.addBlog(entrada);
          return true;
      }else{
          return false;
      }
    }

    public List<EntradaBlogDTO> getAllBlogs() {
        return entradaBlogRepository.getBlogs().stream().map(entradaBlog -> modelMapper.map(entradaBlog,EntradaBlogDTO.class)).collect(Collectors.toList());
    }

    public Optional<EntradaBlog> getBlogById(int id) {
        return entradaBlogRepository.getBlogs().stream().filter(entradaBlog -> entradaBlog.getId()==id).findFirst();
    }
}
