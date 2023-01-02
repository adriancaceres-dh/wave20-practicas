package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IProductService;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IProductService productService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ModelMapper mapper;

    private final int initialId = 1;

    @Override
    public boolean add(PostRequestDto postDto) {
        if (postDto == null || postDto.getUserId()== 0) {
            return false;
        } else {
            if (!productService.alreadyExist(postDto.getProduct().getId()) &&
                    userService.alreadyExists(postDto.getUserId())) {

                ProductRequestDto productDto = postDto.getProduct();
                productService.add(productDto);
                postRepository.add(convertPost(postDto, productDto.getId()));
                userService.updateUser(postDto.getUserId());
                
                return true;
            } else {
                return false;
            }
        }
    }

    public Post convertPost(PostRequestDto postDto, int productId) {
        Post post = mapper.map(postDto, Post.class);
        post.setProductId(productId);
        if (postRepository.getPosts().isEmpty()) {
            post.setId(initialId);
        } else {
            Optional<Integer> lastId = postRepository.getPosts().stream().map(p -> p.getId()).max(Comparator.comparing(Integer::valueOf));
            if (lastId.isPresent()) {
                Integer aux = lastId.get();
                post.setId(++aux);
            }
        }
        return post;
    }
}
