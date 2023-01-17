package com.bootcamp.be_java_hisp_w20_g2_podio.utils.mapper;

import com.bootcamp.be_java_hisp_w20_g2_podio.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.exception.PostCreationException;
import com.bootcamp.be_java_hisp_w20_g2_podio.model.Category;
import com.bootcamp.be_java_hisp_w20_g2_podio.model.Post;
import com.bootcamp.be_java_hisp_w20_g2_podio.model.Product;
import com.bootcamp.be_java_hisp_w20_g2_podio.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    private CategoryRepository categoryRepository;
    private ProductMapper productMapper;

    public PostMapper(CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    public Post toPost(PostDTO postDTO) {
        Product product = productMapper.toProduct(postDTO.getProduct());

        Category postCategory = getPostCategoryByCodeOrThrow(postDTO.getCategory());

        return new Post(postDTO.getDate(), product, postCategory, postDTO.getPrice());
    }

    public PostDTO toDTO(Post post, int userId) {
        return new PostDTO(userId,
                post.getDate(),
                productMapper.toDTO(post.getProduct()),
                post.getCategory().getCode(),
                post.getPrice());
    }

    public PostWithIdDTO toWithIdDTO(Post post, int userId) {
        return new PostWithIdDTO(userId,
                post.getDate(),
                productMapper.toDTO(post.getProduct()),
                post.getCategory().getCode(),
                post.getPrice(),
                post.getId());
    }

    private Category getPostCategoryByCodeOrThrow(int code) {
        return categoryRepository.findByCode(code)
                .orElseThrow(() -> new PostCreationException("Invalid category code"));
    }
}