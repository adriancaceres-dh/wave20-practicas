package com.bootcamp.be_java_hisp_w20_g4_pereyra.service.publication;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.request.product.ProductDTORequest;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.request.publication.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.request.publication.PostDiscountDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product.PromoProductsCountDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.ListedPostDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.ListedPublicationDiscountDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.PublicationDiscountDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.excepcion.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.*;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.repository.category.ICategoryRepository;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.repository.product.IProductRepository;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.repository.publication.IPublicationRepository;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.repository.user.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.bootcamp.be_java_hisp_w20_g4_pereyra.helpers.category.CategoryHelper.isValidCategory;
import static com.bootcamp.be_java_hisp_w20_g4_pereyra.helpers.Validators.isValidDateOrder;
import static com.bootcamp.be_java_hisp_w20_g4_pereyra.helpers.user.UserValidator.isSeller;
import static com.bootcamp.be_java_hisp_w20_g4_pereyra.helpers.user.UserValidator.isValidUser;

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
        Publication publication = this.createPublication(user, publicationDto.getCategory(), publicationDto.getProduct(), publicationDto.getDate(), publicationDto.getPrice(), false, 0d);
        if(publicationRepository.addPublication(publication)){
            ((Seller) user).addPublication(publication);
            return new PublicationDTO(publication.getDate(), mapper.map(publication.getProduct(), ProductDTO.class), publication.getCategory().getId(), publication.getPrice());
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
     * Este método crea una nueva publicación con descuento y la enlaza con el vendedor que la creó
     * @param postDiscountDTO
     * @return PublicationDiscountDTO - Se devuelve el dto de la publicación con descuento creada
     */
    @Override
    public PublicationDiscountDTO addPromoPublication(PostDiscountDTO postDiscountDTO) {
        User user =  userRepository.findById(postDiscountDTO.getUser_id());
        Publication publication = this.createPublication(user, postDiscountDTO.getCategory(), postDiscountDTO.getProduct(), postDiscountDTO.getDate(), postDiscountDTO.getPrice(), postDiscountDTO.isHas_promo(), postDiscountDTO.getDiscount());
        if(publicationRepository.addPublication(publication)){
            ((Seller) user).addPublication(publication);
            return new PublicationDiscountDTO(publication.getPost_id(),publication.getDate(), mapper.map(publication.getProduct(), ProductDTO.class), publication.getCategory(), publication.getPrice(), publication.isHasPromo(),publication.getDiscount());
        }
        return null;
    }
    /**
     * Método que se encarga de crear una publicación y hacer las validaciones necesarias.
     * Para crear la publicación utiliza los datos enviados en el payload de la request
     * @param user Usuario que crea la publicación
     * @param category_id Id de la categoria de la publicación
     * @param productDTO Producto recibido en la request
     * @param date Fecha de creación de la publicación
     * @param price Precio de la publicación
     * @param has_promo Indica si tiene descuento
     * @param discount Descuento de la publicación
     * @return Devuelve una publicación
     */
    private Publication createPublication(User user, int category_id, ProductDTO productDTO, LocalDate date, double price, boolean has_promo, double discount){
        isValidUser(user);
        isSeller(user);
        Category category = categoryRepository.findById(category_id);
        isValidCategory(category);
        Product product = mapper.map(productDTO, Product.class);
        if(!productRepository.productExist(product)) throw new BadRequestException("El producto no es válido.");
        if(!has_promo) return new Publication(date, price, product, category, user.getUser_id());
        else return new Publication(user.getUser_id(), date, price, has_promo, discount, product, category);
    }

    /**
     * Este método devuelve la cantidad de productos con descuento que tiene un usuario
     * @param user_id - id del usuario
     * @return PromoProductsCountDTO - devuelve el dto de con la cantidad de productos con descuento
     */
    @Override
    public PromoProductsCountDTO getCountProductsWithDiscount(int user_id) {
        User user = userRepository.findById(user_id);
        isValidUser(user);
        isSeller(user);
        return new PromoProductsCountDTO(user_id, user.getUser_name(), publicationRepository.getPublicationUser(user_id).size());
    }

    /**
     * El método devuelve todos los productos con descuento de un determinado usuario
     * @param user_id id del usuario
     * @return ListedPublicationDiscountDTO - devuelve los dto de la publicaciones con descuento
     */
    @Override
    public ListedPublicationDiscountDTO getProductsWithDiscount(int user_id) {
        User user = userRepository.findById(user_id);
        isValidUser(user);
        isSeller(user);
        List<PublicationDiscountDTO> publicationDiscountDTOS = publicationRepository.getPublicationUser(user_id).stream()
                .map(p ->  new PublicationDiscountDTO(p.getPost_id(), p.getDate(), mapper.map(p.getProduct(), ProductDTO.class),
                        p.getCategory(), p.getPrice(), p.isHasPromo(),p.getDiscount()))
                .collect(Collectors.toList());
        return new ListedPublicationDiscountDTO(user_id, user.getUser_name(), publicationDiscountDTOS);
    }

    @Override
    public ProductDTO createProduct(ProductDTORequest productDTORequest) {
        return null;
    }

}
