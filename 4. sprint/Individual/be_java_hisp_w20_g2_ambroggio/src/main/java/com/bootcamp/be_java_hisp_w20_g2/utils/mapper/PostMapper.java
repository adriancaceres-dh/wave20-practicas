package com.bootcamp.be_java_hisp_w20_g2.utils.mapper;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.PostPromoDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.exception.PostCreationException;
import com.bootcamp.be_java_hisp_w20_g2.model.Category;
import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.bootcamp.be_java_hisp_w20_g2.model.Product;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.CategoryRepository;
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

    public Post postPromoToPost (PostPromoDTO postPromoDTO) {
        Product product = productMapper.toProduct(postPromoDTO.getProduct());
        if (product == null || postPromoDTO.getDiscount() == 0.0){
            throw new BadRequestException("The required parameters are incorrect");
        }
        Category postCategory = getPostCategoryByCodeOrThrow(postPromoDTO.getCategory());

        return new Post(postPromoDTO.getDate(), product, postCategory, postPromoDTO.getPrice(), postPromoDTO.isHasPromo(), postPromoDTO.getDiscount());
    }
    public PostPromoDTO toPostPromoDTO (Post post, int userId){
        PostPromoDTO postPromoDTO = new PostPromoDTO();
        postPromoDTO.setUserId(userId);
        postPromoDTO.setDate(post.getDate());
        postPromoDTO.setProduct(productMapper.toDTO(post.getProduct()));
        postPromoDTO.setCategory(post.getCategory().getCode());
        postPromoDTO.setPrice(post.getPrice());
        postPromoDTO.setHasPromo(post.isHasPromo());
        postPromoDTO.setDiscount(post.getDiscount());
        return postPromoDTO;
    }

}