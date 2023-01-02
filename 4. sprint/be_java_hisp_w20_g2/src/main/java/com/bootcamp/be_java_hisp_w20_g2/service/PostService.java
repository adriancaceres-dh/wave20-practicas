package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.request.PostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.exception.PostCreationException;
import com.bootcamp.be_java_hisp_w20_g2.model.Category;
import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.bootcamp.be_java_hisp_w20_g2.model.Product;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.ICategoryService;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;


@Service
public class PostService implements IPostService {
    @Autowired
    private PostRepository postRepository;
    // Esto lo vamos a cambiar como dijo adri y dejar los repos directamente?
    @Autowired
    private IUserService userService; // Por principio SOLID se da la responsabilidad de acceder al repo al servicio de usuarios.
    @Autowired
    private ICategoryService categoryService; // Por principio SOLID se da la responsabilidad de acceder al repo al servicio de usuarios.

    public PostService() {

    }

    @Override
    public void createPost(PostRequestDTO postRequestDTO) {
        /*
         * Validar que exista el userId. Si está no existe no es posible crearla, ya que no debería crearse un nuevo
         * usuario desde una nueva publicación.
         * Validar que exista la categoria. Si está no existe no es posible crearla, ya que no debería crearse una nueva
         * categoria desde una nueva publicación.
         *
         * Funciona lo siguiente en postman localhost:8080/products/post:
         * {
            "user_id": 1,
            "date": "29-04-2021",
            "product": {
                "product_id": 1,
                "product_name": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": 12,
            "price": 1500.50
            }
         */
        Post newPost = toObject(postRequestDTO);
        User updatedUser = userService.findUser(postRequestDTO.getUserId());
        updatedUser.addPost(newPost);

        userService.saveUser(updatedUser);
    }

    public Post toObject(PostRequestDTO postRequestDTO) {
        ProductDTO productDTO = postRequestDTO.getProduct();
        Product product = new Product(
                productDTO.getProductId(),
                productDTO.getProductName(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes());
        // Está bien que un Service devuelva un objecto de modelo o solo los repositorios lo hacen?
        Category category = categoryService.findCategoryByCode(postRequestDTO.getCategory())
                .orElseThrow(() -> new PostCreationException("Invalid category code"));
        User user = userService.findUser(postRequestDTO.getUserId());
        if (user == null) {
            // Tiramos exception sobre que el usuario no es correcto.
            throw new PostCreationException("The given userId does not exist.");
        }

        return new Post(postRequestDTO.getDate(), product, category, postRequestDTO.getPrice());
    }

    @Override
    public PostResponseDTO sendLastPostOfFollowed(int userId){
        User user = userService.findUser(userId);
        if(user == null) {
            throw new BadRequestException("The given userId not exist.");
        }

        PostResponseDTO postResponse = new PostResponseDTO(userId);

        user.getFollowing()
                .forEach(followedUser -> {
                    followedUser.getPosts().stream()
                            .sorted(Comparator.comparing(Post::getDate).reversed())
                            .filter(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                            .forEach(post -> postResponse.addPost(post, followedUser.getId()));
                });

        return postResponse;
    }

}
