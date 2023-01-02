package com.socialmeli.be_java_hisp_w20_g8.services.posts;

import com.socialmeli.be_java_hisp_w20_g8.dto.PostRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ProductRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.InvalidArgumentException;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.models.Post;
import com.socialmeli.be_java_hisp_w20_g8.models.Product;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepository;
import com.socialmeli.be_java_hisp_w20_g8.repositories.posts.IPostRepository;
import com.socialmeli.be_java_hisp_w20_g8.services.products.IProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;

@Service
public class PostService implements IPostService {
    private  final ModelMapper mapper = new ModelMapper();

    @Autowired
    IProductService productService;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private PersonRepository personRepository;

    public PostService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public boolean createPost(PostRequestDTO postRequestDTO) {
        // Check if all the fields are present
        if(!Stream.of(postRequestDTO.getUserId(), postRequestDTO.getDate(), postRequestDTO.getProduct(), postRequestDTO.getCategory(), postRequestDTO.getPrice())
                .allMatch(Objects::nonNull))
            throw new InvalidArgumentException("All the fields are required");

        // Check if the person exists
        if(!personRepository.checkUser(postRequestDTO.getUserId()))
            throw new OperationFailedException("The specified user does not exist in the database");

        // Create the product if it doesn't exist
        productService.createProduct(postRequestDTO.getProduct());

        Post post = mapper.createTypeMap(PostRequestDTO.class, Post.class)
                .addMapping(src -> src.getProduct().getProductId(), Post::setProductId)
                .map(postRequestDTO);

        return postRepository.createPost(post);
    }
}
