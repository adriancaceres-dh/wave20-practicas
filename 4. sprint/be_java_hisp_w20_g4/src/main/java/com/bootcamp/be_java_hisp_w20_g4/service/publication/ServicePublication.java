package com.bootcamp.be_java_hisp_w20_g4.service.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.*;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.excepcion.BadRequestException;
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

import static com.bootcamp.be_java_hisp_w20_g4.helpers.Validators.*;
import static com.bootcamp.be_java_hisp_w20_g4.helpers.category.CategoryValidator.isValidCategory;
import static com.bootcamp.be_java_hisp_w20_g4.helpers.user.UserValidator.*;;

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
        isValidSeller(user);
        Category category = categoryRepository.findById(publicationDto.getCategory());
        isValidCategory(category);
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
     * Este método agrega una publicacion en promocion
     * @param promoPostDTO - Payload requerido para dar de alta una publicacion en promocion
     * @return PromoPublicationDTO - Se devuelve la información de la publicacion en promocion publicada
     */
    @Override
    public PromoPublicationDTO addPromoPublication(PromoPostDTO promoPostDTO) {
        User user =  userRepository.findById(promoPostDTO.getUser_id());
        isValidSeller(user);
        Category category = categoryRepository.findById(promoPostDTO.getCategory());
        isValidCategory(category);
        Product product = mapper.map(promoPostDTO.getProduct(), Product.class);
        if(!productRepository.productExist(product)) throw new BadRequestException("El producto no es válido.");

        Publication publication = new Publication(promoPostDTO.getDate(), promoPostDTO.getPrice(), product, category, user.getUser_id(),promoPostDTO.isHas_promo(),promoPostDTO.getDiscount());

        if(publicationRepository.addPublication(publication)) {
            ((Seller) user).addPublication(publication);
            return new PromoPublicationDTO(publication.getDate(), mapper.map(publication.getProduct(), ProductDTO.class), category.getId(), publication.getPrice(), publication.isHasPromo(), publication.getDiscount());

        }
        return null;
    }

    /**
     * Este método retorna la cantidad de publicaciones en promocion que tiene un usuario
     * @param userId - El id del usuario al cual se le van a consultar la cantidad de publicaciones en promocion
     * @return PromoPublicationCountDTO - Objeto que contiene la estructura requerida para retornar la cantidad de publicaciones
     */
    @Override
    public PromoPublicationCountDTO getCountPromoPublications(Integer userId) {
        isValidUserParam(userId);
        User user = userRepository.findById(userId);
        isValidUser(user);
        isSeller(user);
        List<Publication> publications = publicationRepository.getPromoPublications(userId);
        PromoPublicationCountDTO promoPublicationCountDTO = new PromoPublicationCountDTO(userId,user.getUser_name(),publications.size());
        return promoPublicationCountDTO;
    }

    /**
     * Este método retorna las publicaciones en promocion que tiene un usuario
     * @param userId - El id del usuario al cual se le van a consultar las publicaciones en promocion
     * @return PromoPublicationListDTO - Objeto que contiene la estructura requerida para retornar las publicaciones en promocion
     */
    @Override
    public PromoPublicationListDTO getPromoPublications(Integer userId) {
        isValidUserParam(userId);
        User user = userRepository.findById(userId);
        isValidUser(user);
        isSeller(user);
        List<Publication> publications = publicationRepository.getPromoPublications(userId);
        List<ListedPromoPostDTO> listedPromoPostDTOList = publications.stream().map(publication -> new ListedPromoPostDTO(userId,publication.getPost_id(),publication.getDate(),mapper.map(publication.getProduct(),ProductDTO.class),publication.getCategory().getId(),publication.getPrice(),publication.isHasPromo(),publication.getDiscount())).collect(Collectors.toList());
        return new PromoPublicationListDTO(userId,user.getUser_name(),listedPromoPostDTOList);
    }

    /**
     * Este método retorna las publicaciones de los vendedores que son seguidos por el usuario pasado por parametro
     * cuyo precio de publicacion se encuentra dentro del rango pasado en los parametros from y to
     * @param userId - El id del usuario al cual se le van a consultar las publicaciones de los vendedores que sigue
     * @param from - El rango inicial de los precios
     * @param to - El rango final de los precios
     * @param order - El orden por fecha por el que se van a ordenar las publicaciones
     * @return PromoPublicationListDTO - Objeto que contiene la estructura requerida para retornar las publicaciones en promocion filtradas por precio
     */
    @Override
    public PromoPublicationListDTO getPromoPublicationsInRangePrice(Integer userId, Double from, Double to, String order) {
        isValidRangeParams(from,to);
        isValidDateOrder(order);
        isValidUserParam(userId);
        User user = userRepository.findById(userId);
        isValidUser(user);
        List<Integer> followedIds = user.getFollowed().values().stream().map(u -> u.getUser_id()).collect(Collectors.toList());
        List<Publication> publications = publicationRepository.getPromoPublicationsInRangePrice(followedIds, from,to);
        if (order.equals("date_desc")) Collections.reverse(publications);
        List<ListedPromoPostDTO> listedPromoPostDTOList = publications.stream().map(publication -> new ListedPromoPostDTO(publication.getUser_id(),publication.getPost_id(),publication.getDate(),mapper.map(publication.getProduct(),ProductDTO.class),publication.getCategory().getId(),publication.getPrice(),publication.isHasPromo(),publication.getDiscount())).collect(Collectors.toList());
        return new PromoPublicationListDTO(userId,user.getUser_name(),listedPromoPostDTOList);
    }
}
