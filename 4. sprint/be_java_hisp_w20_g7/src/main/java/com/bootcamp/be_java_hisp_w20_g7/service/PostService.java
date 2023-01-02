package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.entity.Post;
import com.bootcamp.be_java_hisp_w20_g7.exception.DataIsnotCorrectException;
import com.bootcamp.be_java_hisp_w20_g7.exception.PostEmptyException;
import com.bootcamp.be_java_hisp_w20_g7.repository.IPostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

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
        if (postCreateDto == null) {
            throw new PostEmptyException("La publicación esta vacía");
        }
        Post post = modelMapper.map(postCreateDto, Post.class);
        calculateId(post);
        if (post.getPrice() <= 0) {
            throw new DataIsnotCorrectException("Coloque un precio mayor a 0");
        }
        if (iPostRepository.save(post)) {
            return "Se ha registrado el Post de ID " + post.getPostId();
        } else {
            return "No se logro registrar el No. " + post.getPostId();
        }
    }

    public void calculateId(Post post) {
        post.setPostId(iPostRepository.findAll().stream().filter(post1 -> post.getUserId() == post1.getUserId())
                .map(Post::getPostId)
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElseGet(() -> 0) + 1);

    }

}
