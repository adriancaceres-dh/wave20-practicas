package com.bootcamp.be_java_hisp_w20_g2.utils.mapper;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.request.PromoPostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.PostCreationException;
import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.bootcamp.be_java_hisp_w20_g2.model.PostCategory;
import com.bootcamp.be_java_hisp_w20_g2.model.Product;
import com.bootcamp.be_java_hisp_w20_g2.repository.custom.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductMapper productMapper;

    public Post toPost(PostDTO postDTO) {
        Product product = productMapper.toProduct(postDTO.getProduct());

        PostCategory postCategory = getPostCategoryByCodeOrThrow(postDTO.getCategory());

        return new Post(postDTO.getDate(), product, postCategory, postDTO.getPrice());
    }

    public Post toPost(PromoPostRequestDTO postDTO) {
        Product product = productMapper.toProduct(postDTO.getProduct());

        PostCategory postCategory = getPostCategoryByCodeOrThrow(postDTO.getCategory());

        return new Post(postDTO.getDate(),
                product,
                postCategory,
                postDTO.getPrice(),
                postDTO.isHasPromo(),
                postDTO.getDiscount());
    }

    public PostDTO toDTO(Post post, int userId) {
        return new PostDTO(userId,
                post.getDate(),
                productMapper.toDTO(post.getProduct()),
                post.getPostCategory().getCode(),
                post.getPrice());
    }

    public PostWithIdDTO toWithIdDTO(Post post, int userId) {
        return new PostWithIdDTO(userId,
                post.getDate(),
                productMapper.toDTO(post.getProduct()),
                post.getPostCategory().getCode(),
                post.getPrice(),
                post.getId());
    }

    private PostCategory getPostCategoryByCodeOrThrow(int code) {
        return categoryRepository.findByCode(code)
                .orElseThrow(() -> new PostCreationException("Invalid category code"));
    }
}
