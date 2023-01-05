package com.socialmeli.be_java_hisp_w20_g8.services.posts;


import com.socialmeli.be_java_hisp_w20_g8.dto.*;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.DoesntExistSellerException;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.models.Product;
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
        PostDTO postDTO = new PostDTO(post.getUser_id(), post.getDate(), productService.getProductById(post.getProduct_id()), post.getCategory(), post.getPrice());

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
    public boolean createPostPromo(PromoRequestDTO promoRequestDTO) {
        // Check if all the fields are present
        if(!Stream.of(promoRequestDTO.getUserId(), promoRequestDTO.getDate(), promoRequestDTO.getProductDTO(), promoRequestDTO.getCategory(), promoRequestDTO.getPrice(),promoRequestDTO.getHas_promo(),promoRequestDTO.getDiscount())
                .allMatch(Objects::nonNull))
            throw new InvalidArgumentException("All the fields are required");

        // Get the seller
        Seller seller = personRepository.findSellerById(promoRequestDTO.getUserId());

        // Check if the seller exists
        if(seller == null)
            throw new OperationFailedException("The specified seller does not exist in the database");

        // Create the product if it doesn't exist
        productService.createProduct(promoRequestDTO.getProductDTO());

        // Create the post
        Post post = mapper.map(promoRequestDTO, Post.class);
        int postId = postRepository.createPostPromo(post);


        // Add the post to the seller's list
        return seller.getPost().add(postId);
    }

    public SellerCountPromoDTO sellerCountPromoProduct(int userId){

        Seller seller = personRepository.getById(userId);
        if (seller == null){throw new NotFoundException("User not found: "+userId);}

        Set<Integer> posts= seller.getPost();
        Set<Post> posts1= postRepository.getPosts();
        int sumar=0;
        for(int post:posts){
            Optional<Post> conteo = posts1.stream().filter(x-> x.getId()==post).findFirst();
            try {
                List<?> filtro = conteo.stream().filter(y -> y.getHas_promo()).collect(Collectors.toList());
                if (filtro.size()>=1){
                    sumar=sumar+1;
                }
            }catch (Exception e){
                System.out.println("No tiene");
            }
        }

        SellerCountPromoDTO sellerCountPromoDTO = new SellerCountPromoDTO(userId, seller.getUser_name(),sumar);


        return sellerCountPromoDTO;

    }
    public BonusDTO promoProducts(int userId) {
        Seller seller = personRepository.getById(userId);
        if (seller == null) {
            throw new NotFoundException("User not found: " + userId);
        }
        Set<Integer> posts = seller.getPost();
        Set<Post> posts1 = postRepository.getPosts();
        List<Post> listPosts = new ArrayList<>();

        for (int post : posts) {
            Optional<Post> conteo = posts1.stream().filter(x -> x.getId() == post).findFirst();
            System.out.println(conteo);

            try {
                List<?> filtro = conteo.stream().filter(y -> y.getHas_promo()).collect(Collectors.toList());
                listPosts.add((Post) filtro.get(0));

            } catch (Exception e) {
                System.out.println("No tiene");
            }
        }
        if (listPosts.size() == 0) {
            throw new NotFoundException("User do not have promo posts: " + userId);
        }
        BonusDTO bonusDTO = new BonusDTO(userId, seller.getUser_name(), listPosts);
        return bonusDTO;

    }
}
