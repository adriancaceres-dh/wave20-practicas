package com.socialmeli.be_java_hisp_w20_g8.services.posts;


import com.socialmeli.be_java_hisp_w20_g8.dto.*;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.DoesntExistSellerException;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.IPersonRepository;
import com.socialmeli.be_java_hisp_w20_g8.repositories.posts.IPostRepository;
import com.socialmeli.be_java_hisp_w20_g8.services.products.IProductService;
import com.socialmeli.be_java_hisp_w20_g8.utils.Validators;
import org.springframework.beans.factory.annotation.Autowired;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.InvalidArgumentException;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.models.Post;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class PostService implements IPostService {

    private final ModelMapper mapper = new ModelMapper();
    @Autowired
    private IProductService productService;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IPersonRepository personRepository;

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
        if(!Stream.of(postRequestDTO.getUser_id(), postRequestDTO.getDate(), postRequestDTO.getProductDTO(), postRequestDTO.getCategory(), postRequestDTO.getPrice())
                .allMatch(Objects::nonNull))
            throw new InvalidArgumentException("All the fields are required");

        // Check if all the promo post fields are present
        if(postRequestDTO instanceof PromoPostRequestDTO && (!((PromoPostRequestDTO) postRequestDTO).isHasPromo() || ((PromoPostRequestDTO) postRequestDTO).getDiscount() <= 0.0))
            throw new InvalidArgumentException("The promo post must have a promo and a discount must be set");

        // Get the seller
        Seller seller = personRepository.findSellerById(postRequestDTO.getUser_id());

        // Check if the seller exists
        if(seller == null)
            throw new NotFoundException("The specified seller does not exist in the database");

        // Create the product if it doesn't exist
        productService.createProduct(postRequestDTO.getProductDTO());

        // Create the post
        Post post = mapper.map(postRequestDTO, Post.class);

        // Create the post DTO
        PostDTO postDTO = postRequestDTO instanceof PromoPostRequestDTO
                ? new PromoPostResponseDTO(post, productService.getProductById(post.getProduct_id()), post.isHasPromo(), post.getDiscount())
                : new PostDTO(post, productService.getProductById(post.getProduct_id()));

        int postId = postRepository.createPost(post, postDTO);

        // Add the post to the seller's list
        return seller.getPost().add(postId);
    }

    @Override
    public ResponsePostDTO findSellersByIdUser(int id, String order) {
        if (personRepository.checkUser(id)) {
            Set<Integer> followedSellers = personRepository.getAllFollowed(id);
            Set<Seller> sellers = followedSellers.stream().map(seller_id -> personRepository.findSellerById(seller_id)).collect(Collectors.toSet());
            if(sellers.isEmpty())
                throw new DoesntExistSellerException("The seller doesn't follow any sellers");
            return findPostByIdSeller(sellers, id,order);
        }
        else {
            throw new NotFoundException("The specified user does not exist in the database");
        }
    }

    @Override
    public ResponsePostDTO findPostByIdSeller(Set<Seller> sellers, int idUser,String order) {
       List<PostDTO> listPostSeller = new ArrayList<>();
       sellers.forEach(seller -> {
           if (seller == null)
               throw new DoesntExistSellerException("The seller doesn't follow any sellers");
           listPostSeller.addAll(postRepository.findPostsById(seller.getPost()));
           });

        String orderType = order==null ? "" : order;
        if (!Validators.checkValidatorOptionDate(orderType)) {
            throw new InvalidArgumentException("Invalid sorting option");
        }
        switch(orderType){
           case "date_asc":
               return ResponsePostDTO.builder().id_user(idUser).posts(listPostSeller.stream()
                               .sorted((a,b)->a.getDate().compareTo(b.getDate()))
                               .collect(Collectors.toList()))
                       .build();
           case "date_desc":
            default:
               return ResponsePostDTO.builder().id_user(idUser).posts(listPostSeller.stream()
                               .sorted((a,b)->b.getDate().compareTo(a.getDate()))
                               .collect(Collectors.toList()))
                       .build();

        }

    }

    @Override
    public PromoPostCountDTO getPromoPostCountByUserId(int userId) {
        // Get the seller
        Seller seller = personRepository.findSellerById(userId);

        // Check if the seller exists
        if(seller == null)
            throw new NotFoundException("The specified seller does not exist in the database");

        // Get the number of promo posts
        int promoPostCount = postRepository.getPromoPostsByUserId(userId).size();

        return new PromoPostCountDTO(userId, seller.getUser_name(), promoPostCount);
    }
}
