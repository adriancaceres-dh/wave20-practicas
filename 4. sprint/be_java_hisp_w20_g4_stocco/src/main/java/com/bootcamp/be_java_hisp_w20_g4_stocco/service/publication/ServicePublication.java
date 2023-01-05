package com.bootcamp.be_java_hisp_w20_g4_stocco.service.publication;

import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.request.PostPromoDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.publication.*;
import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.product.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.excepcion.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4_stocco.model.*;
import com.bootcamp.be_java_hisp_w20_g4_stocco.repository.category.ICategoryRepository;
import com.bootcamp.be_java_hisp_w20_g4_stocco.repository.product.IProductRepository;
import com.bootcamp.be_java_hisp_w20_g4_stocco.repository.publication.IPublicationRepository;
import com.bootcamp.be_java_hisp_w20_g4_stocco.repository.user.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.bootcamp.be_java_hisp_w20_g4_stocco.helpers.Validators.isValidDateOrder;
import static com.bootcamp.be_java_hisp_w20_g4_stocco.helpers.user.UserValidator.isSeller;
import static com.bootcamp.be_java_hisp_w20_g4_stocco.helpers.user.UserValidator.isValidUser;
import static com.bootcamp.be_java_hisp_w20_g4_stocco.helpers.category.CategoryValidator.isValidCategory;

@Service
public class ServicePublication implements IServicePublication {

    @Autowired
    IPublicationRepository publicationRepository;
    @Autowired
    IProductRepository productRepository;
    @Autowired
    ICategoryRepository categoryRepository;
    @Autowired
    IUserRepository userRepository;


    ModelMapper mapper = new ModelMapper();

    /**
     * Este método crea una nueva publicación y la enlaza con el vendedor que la creó
     * @param publicationDto - Son los datos de la publicación
     * @return PublicationDTO - Se devuelve un dto de la publicación creada
     */
    public PublicationDTO addPublication(PostDTO publicationDto){
        User user =  userRepository.findById(publicationDto.getUser_id());
        if(user == null) throw new BadRequestException("El usuario no es válido");

        if(!(user instanceof Seller))throw new BadRequestException("Este usuario no puede generar una publicación");

        Category category = categoryRepository.findById(publicationDto.getCategory());
        if(category == null) throw new BadRequestException("La categoria ingresa no es válida.");
        Product product = mapper.map(publicationDto.getProduct(), Product.class);
        if(!productRepository.productExist(product)) throw new BadRequestException("El producto no es válido.");
        Publication publication = new Publication(publicationDto.getDate(), publicationDto.getPrice(), product, category, user.getUser_id());

        if(publicationRepository.addPublication(publication)){
            ((Seller) user).addPublication(publication);
            return new PublicationDTO(publication.getDate(), mapper.map(publication.getProduct(), ProductDTO.class), category.getId(), publication.getPrice());

        }
        return null;
    }

    /**
     * Este método obtiene las publicaciones de las últimas dos semanas de los vendedores que sigue el usuario recibido
     * @param userId - Id del que obtendrá la lista de seguidos para buscar las publicaciones
     * @param order - Especifica el tipo de ordenamiento que se desea (Opciones aceptadas: "date_asc" , "date_desc", null)
     * @return ProductTwoWeeksResponseDTO - Se devuelve la información de las publicaciones requeridas
     */
    public ProductTwoWeeksResponseDTO getLastTwoWeeksPublications(int userId, String order) {
        isValidDateOrder(order);

        User user = userRepository.findById(userId);
        isValidUser(user);

        List<Integer> followedIds = user.getFollowed().values().stream().map(u -> u.getUser_id()).collect(Collectors.toList());

        List<Publication> publications = publicationRepository.getPublicationLastNDays(followedIds, 15);

        List<ListedPostDTO> listedPostDTO = publications.stream().map(p -> mapper.map(p, ListedPostDTO.class)).collect(Collectors.toList());

        if(order == null || order.equals("date_desc")) Collections.reverse(listedPostDTO);

        return new ProductTwoWeeksResponseDTO(user.getUser_id(), listedPostDTO);
    }

    @Override
    public PublicationPromoDTO addPublicationPromo(PostPromoDTO postPromoDTO) {
        User user = userRepository.findById(postPromoDTO.getUser_id());
        isValidUser(user);
        isSeller(user);
        Category category = categoryRepository.findById(postPromoDTO.getCategory());
        if(category == null) throw new BadRequestException("La categoría ingresada no es válida.");

        Product product = mapper.map(postPromoDTO.getProduct(), Product.class);
        if(productRepository.findById(product) == null) throw  new BadRequestException("El producto no es válido");
        if(postPromoDTO.isHasPromo() == false) throw new BadRequestException("El producto no está en promoción");

        Publication publication = new Publication(postPromoDTO.getDate(),postPromoDTO.getPrice(), postPromoDTO.isHasPromo(), postPromoDTO.getDiscount(), postPromoDTO.getProduct(), postPromoDTO.getCategory(), postPromoDTO.getUser_id());
        publication.setHasPromo(true);

        if(publicationRepository.addPublication(publication)){
            ((Seller) user).addPublication(publication);
            return new PublicationPromoDTO(publication.getDate(), mapper.map(publication.getProduct(), ProductDTO.class), category.getId(), publication.getPrice(), publication.isHasPromo(), publication.getDiscount());

        }
         return null;
    }

    @Override
    public PromoCountDTO countPublicationPromo(int user_id) {
        User user = userRepository.findById(user_id);
        isValidUser(user);
        isSeller(user);
       int count = publicationRepository.countPromos(user_id);
         PromoCountDTO promoCountDTO = new PromoCountDTO(user_id, user.getUser_name(),count);
        return promoCountDTO;
    }

    @Override
    public PublicationSellerPromoDTO publicationSellerPromo(int user_id) {
        User user = userRepository.findById(user_id);
        isValidUser(user);
        isSeller(user);
        List<Publication> publications = publicationRepository.promoSellerList(user_id);
        List<PostPromoDTO> posts = publications.stream()
                .filter(p->p.getUser_id() == user_id)
                .filter(p->p.isHasPromo())
                .map(p-> mapper.map(p, PostPromoDTO.class))
                .collect(Collectors.toList());

        PublicationSellerPromoDTO publicationSellerPromoDTO = new PublicationSellerPromoDTO(user_id,user.getUser_name(),posts);
        return  publicationSellerPromoDTO;

    }

}
