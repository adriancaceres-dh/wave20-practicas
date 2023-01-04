package com.socialmeli.be_java_hisp_w20_g8.services.posts;


import com.socialmeli.be_java_hisp_w20_g8.dto.PostDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponsePostDTO;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.IPersonRepository;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepositoryImp;
import com.socialmeli.be_java_hisp_w20_g8.repositories.posts.IPostRepository;
import com.socialmeli.be_java_hisp_w20_g8.repositories.posts.IPostRepositoryImp;
import com.socialmeli.be_java_hisp_w20_g8.services.products.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import com.socialmeli.be_java_hisp_w20_g8.dto.PostRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.InvalidArgumentException;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.models.Post;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class PostService implements IPostService {

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    PersonRepositoryImp personRepositoryImp;

    @Autowired
    IPostRepositoryImp postRepositoryImp;

    @Autowired
    private IProductService productService;
    @Autowired
    private IPostRepository IPostRepository;
    @Autowired
    private IPersonRepository IPersonRepository;

    public PostService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        mapper.createTypeMap(PostRequestDTO.class, Post.class)
                .addMapping(src -> src.getProductDTO().getProduct_id(), Post::setProductId);
    }

    @Override
    public boolean createPost(PostRequestDTO postRequestDTO) {
        // Check if all the fields are present
        if(!Stream.of(postRequestDTO.getUserId(), postRequestDTO.getDate(), postRequestDTO.getProductDTO(), postRequestDTO.getCategory(), postRequestDTO.getPrice())
                .allMatch(Objects::nonNull))
            throw new InvalidArgumentException("All the fields are required");

        // Get the seller
        Seller seller = IPersonRepository.findSellerById(postRequestDTO.getUserId());

        // Check if the seller exists
        if(seller == null)
            throw new NotFoundException("The specified seller does not exist in the database");

        // Create the product if it doesn't exist
        productService.createProduct(postRequestDTO.getProductDTO());

        // Create the post
        Post post = mapper.map(postRequestDTO, Post.class);
        int postId = IPostRepository.createPost(post);

        // Add the post to the seller's list
        return seller.getPost().add(postId);
    }

    @Override
    public ResponsePostDTO findSellersByIdUser(int id) {
        if (personRepositoryImp.checkUser(id)) {
            Set<Integer> followedSellers = personRepositoryImp.getAllFollowed(id);
            Set<Seller> sellers = followedSellers.stream().map(seller_id -> personRepositoryImp.findSellerById(seller_id)).collect(Collectors.toSet());
            return findPostByIdSeller(sellers, id);
        }
        else {
            return null;
        }
    }

    @Override
    public ResponsePostDTO findPostByIdSeller(Set<Seller> sellers, int idUser) {
       Set<PostDTO> setPostSeller = new HashSet<>();
       sellers.stream().forEach(seller -> postRepositoryImp.findPostsById(seller.getPost()).forEach(x-> setPostSeller.add(x)));

       return ResponsePostDTO.builder().id_user(idUser).posts(setPostSeller).build();
    }
}
