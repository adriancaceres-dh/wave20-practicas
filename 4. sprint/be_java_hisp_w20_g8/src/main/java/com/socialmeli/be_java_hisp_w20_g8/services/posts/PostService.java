package com.socialmeli.be_java_hisp_w20_g8.services.posts;

import com.socialmeli.be_java_hisp_w20_g8.dto.PostRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.InvalidArgumentException;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.models.Post;
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
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private IProductService productService;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private PersonRepository personRepository;

    public PostService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        mapper.createTypeMap(PostRequestDTO.class, Post.class)
                .addMapping(src -> src.getProductDTO().getProductId(), Post::setProductId);
    }

    @Override
    public boolean createPost(PostRequestDTO postRequestDTO) {
        // Check if all the fields are present
        if(!Stream.of(postRequestDTO.getUserId(), postRequestDTO.getDate(), postRequestDTO.getProductDTO(), postRequestDTO.getCategory(), postRequestDTO.getPrice())
                .allMatch(Objects::nonNull))
            throw new InvalidArgumentException("All the fields are required");

        // Check if the person exists
        if(!personRepository.checkUser(postRequestDTO.getUserId()))
            throw new OperationFailedException("The specified user does not exist in the database");

        // Create the product if it doesn't exist
        productService.createProduct(postRequestDTO.getProductDTO());

        Post post = mapper.map(postRequestDTO, Post.class);

        return postRepository.createPost(post);
    }
}
