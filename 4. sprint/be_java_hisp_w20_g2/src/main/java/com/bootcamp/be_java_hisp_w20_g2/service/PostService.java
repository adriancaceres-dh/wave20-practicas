package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.request.PostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.model.Category;
import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.bootcamp.be_java_hisp_w20_g2.model.Product;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    @Autowired
    private PostRepository postRepository;
    public PostService(){

    }

    @Override
    public void createPost(PostRequestDTO postRequestDTO) {
        /*
        * Validar que exista el userId
        * Validar que exista la categoria
        * Validar que las fechas esten correctas
        */
        // boolean userFind = userService.findUser(postRequestDTO.getUserId());
        // boolean categoryFind = categoryService.findCategory(postRequestDTO.getCategory());
        // boolean correctDate = LocalDate.

    }

    /* TODO
    public Post toObject(PostRequestDTO postRequestDTO) {
        //
        ProductDTO productDTO = postRequestDTO.getProduct();
        Product product = new Product(
                productDTO.getProductId(),
                productDTO.getProductName(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes());
        // Está bien que un Service devuelva un objecto de modelo o solo los repositorios lo hacen?
        Category category = categoryService.findCategory(postRequestDTO.getCategory());
        Post post = new Post(postRequestDTO.getDate(), product, category, postRequestDTO.getPrice());
    }
    */
}
