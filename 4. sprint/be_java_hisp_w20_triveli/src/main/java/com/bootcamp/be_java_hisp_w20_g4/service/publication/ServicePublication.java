package com.bootcamp.be_java_hisp_w20_g4.service.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostPromotionDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductsPromotionSellerDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.ListedPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.excepcion.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.excepcion.NotFoundException;
import com.bootcamp.be_java_hisp_w20_g4.model.*;
import com.bootcamp.be_java_hisp_w20_g4.repository.category.ICategoryRepository;
import com.bootcamp.be_java_hisp_w20_g4.repository.product.IProductRepository;
import com.bootcamp.be_java_hisp_w20_g4.repository.publication.IPublicationRepository;
import com.bootcamp.be_java_hisp_w20_g4.repository.user.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.bootcamp.be_java_hisp_w20_g4.helpers.Validators.isValidDateOrder;
import static com.bootcamp.be_java_hisp_w20_g4.helpers.user.UserValidator.isValidUser;

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

    /**
     * Este método agrega publicaciones que pueden o no, estar en promoción
     * @param publicationPromotionDto - Son los datos de la publicación, con el producto
     * @return PublicationDTO - Se devuelve un dto de la publicación
     */
    public PublicationDTO addPublicationHasPromotion(PostPromotionDTO publicationPromotionDto) {
        User userFinder = userRepository.findById(publicationPromotionDto.getUser_id());
        if (userFinder == null) throw new BadRequestException("El usuario no es válido");

        if (!(userFinder instanceof Seller)) throw new BadRequestException("Este usuario no puede generar una publicación");

        Category category = categoryRepository.findById(publicationPromotionDto.getCategory());
        if (category == null) throw new BadRequestException("La categoria ingresa no es válida.");
        Product product = mapper.map(publicationPromotionDto.getProduct(), Product.class);
        if (!productRepository.productExist(product)) throw new BadRequestException("El producto no es válido.");
        Publication publication = new Publication(publicationPromotionDto.getDate(), publicationPromotionDto.getPrice(),publicationPromotionDto.isHas_promo(),publicationPromotionDto.getDiscount(),product, category, userFinder.getUser_id());
        List<Publication> publicationsForUser = publicationRepository.getPublicationHasPromotion(userFinder.getUser_id());
        if(publicationsForUser != null){
            if(publicationsForUser.stream().filter(p->p.getProduct().getProduct_id() == publicationPromotionDto.getProduct().getProduct_id()).collect(Collectors.toList()).size() > 0)
                throw new BadRequestException("Ya hay una publicacion igual.");
        }



        if (publicationRepository.addPublication(publication)) {
            ((Seller) userFinder).addPublication(publication);
            return new PublicationDTO(publication.getDate(), mapper.map(publication.getProduct(), ProductDTO.class), category.getId(), publication.getPrice());
        }
        return null;
    }

    /**
     * Este metodo busca la cantidad de publicaciones en promoción que tiene el vendedor
     * @param userId - Id del vendedor del que se consulta la cantidad de publicaciones
     * @return ProductCountDTO - Se devuelve los datos y la cantidad de publicaciones del vendedor solicitado
     */

    public ProductCountDTO countPublicationHasPromo(int userId){
        User userFinder = userRepository.findById(userId);
        if (userFinder == null){
            throw new NotFoundException("No se ha encontrado el usuario");
        }
        if(!(userFinder instanceof Seller)) throw new BadRequestException("Un comprador no tiene publicaciones");
        ProductCountDTO userProductCountDTO = new ProductCountDTO(userId,userFinder.getUser_name(),publicationRepository.getPublicationHasPromotion(userId).size());
        return userProductCountDTO;
    }


    /**
     * Este método busca las publicaciones en promoción y las muestra
     * @param userId - Id del vendedor del que se le consultada las publicaciones en promoción
     * @return ProductsPromotionSellerDTO - Se devuelve las publicaciones del vendedor que tiene en promocion
     */
    public ProductsPromotionSellerDTO ProductHasPromotionOfSeller(int userId){
        User userFinder = userRepository.findById(userId);
        if (userFinder == null){
            throw new NotFoundException("No se ha encontrado el usuario");
        }
        if (!(userFinder instanceof Seller)) throw new BadRequestException("Este usuario no tiene publicaciones");
        List<Publication> publications = publicationRepository.getPublicationHasPromotion(userId);
        List<PostPromotionDTO> promotionDTOs = publications.stream().map(p ->{return new PostPromotionDTO(p.getUser_id(),p.getPost_id(),p.getDate(),mapper.map(p.getProduct(), ProductDTO.class),p.getCategory().getId(),p.getPrice(),p.isHasPromo(),p.getDiscount());}).collect(Collectors.toList());
        ProductsPromotionSellerDTO productsPromotionsOfSeller = new ProductsPromotionSellerDTO(userId,userFinder.getUser_name(),promotionDTOs);
        return productsPromotionsOfSeller;

    }


}
