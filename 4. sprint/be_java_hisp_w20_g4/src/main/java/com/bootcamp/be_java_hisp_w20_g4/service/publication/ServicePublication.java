package com.bootcamp.be_java_hisp_w20_g4.service.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.ListedPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PromoPublicationCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PromoPublicationDTO;
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

import static com.bootcamp.be_java_hisp_w20_g4.helpers.Validators.isValidDateOrder;
import static com.bootcamp.be_java_hisp_w20_g4.helpers.Validators.isValidUserParam;
import static com.bootcamp.be_java_hisp_w20_g4.helpers.user.UserValidator.isSeller;
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


    @Override
    public PromoPublicationDTO addPromoPublication(PromoPostDTO promoPostDTO) {
        User user =  userRepository.findById(promoPostDTO.getUser_id());
        isValidUser(user);
        isSeller(user);

        Category category = categoryRepository.findById(promoPostDTO.getCategory());
        if(category == null) throw new BadRequestException("La categoria ingresa no es válida.");
        Product product = mapper.map(promoPostDTO.getProduct(), Product.class);
        if(!productRepository.productExist(product)) throw new BadRequestException("El producto no es válido.");

        Publication publication = new Publication(promoPostDTO.getDate(), promoPostDTO.getPrice(), product, category, user.getUser_id(),promoPostDTO.isHas_promo(),promoPostDTO.getDiscount());

        if(publicationRepository.addPublication(publication)) {
            ((Seller) user).addPublication(publication);
            return new PromoPublicationDTO(publication.getDate(), mapper.map(publication.getProduct(), ProductDTO.class), category.getId(), publication.getPrice(), publication.isHasPromo(), publication.getDiscount());

        }
        return null;
    }

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
}
