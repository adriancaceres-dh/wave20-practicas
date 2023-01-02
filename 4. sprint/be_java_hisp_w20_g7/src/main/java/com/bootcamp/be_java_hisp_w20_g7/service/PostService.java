package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.entity.Post;
import com.bootcamp.be_java_hisp_w20_g7.repository.IPostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    IPostRepository iPostRepository;

    ModelMapper modelMapper;

    public PostService() {
        modelMapper = new ModelMapper();
    }


    @Override
    public String createPost(PostCreateDto postCreateDto) {
        Post post = modelMapper.map(postCreateDto, Post.class);
        post.setPostId(calculateId());
        //TODO: Validar que no exista un producto con el mismo id o precios negativos
        if (iPostRepository.save(post)) {
            return "Se ha registrado el Post de ID " + post.getPostId();
        } else {
            return "No se logro registrar el No. " + post.getPostId();
        }

    }

    @Override
    public int calculateId() {
        // TODO: Podria usarse una lambda
        List<Post> posts = iPostRepository.findAll();
        if (posts.isEmpty()) {
            return 1;
        }
        return posts.get(posts.size() - 1).getPostId() + 1;
    }


}
