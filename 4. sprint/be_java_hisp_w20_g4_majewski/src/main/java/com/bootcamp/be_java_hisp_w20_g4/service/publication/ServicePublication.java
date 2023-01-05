package com.bootcamp.be_java_hisp_w20_g4.service.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostPromotionDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductWithPostListDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.ListedPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.ListedPostPromotionDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserPostPromotionDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserPromoProductsCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.exception.BadRequestException;
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
     * Este método crea una nueva publicación y la enlaza con el vendedor que la creó
     * @param publicationDto - Son los datos de la publicación
     * @return PublicationDTO - Se devuelve un dto de la publicación creada
     */
    public PublicationDTO addPublication(PostDTO publicationDto){
        User user =  userRepository.findById(publicationDto.getUser_id());
        Publication publication = validateAndCreatePublication(publicationDto, user);
        return addPublicationToRepository(publication, user);
    }


    /**
     * Este método crea una nueva publicación que cuenta con una promoción y la enlaza con el vendedor que la creó
     * @param publicationPromotionDto - Son los datos de la publicación
     * @return PublicationDTO - Se devuelve un dto de la publicación creada
     */
    public PublicationDTO addPublicationPromotion(PostPromotionDTO publicationPromotionDto){
        if(!publicationPromotionDto.isHas_promo()) throw new BadRequestException("La publicación no tiene promoción");
        if(publicationPromotionDto.getDiscount() <= 0) throw new BadRequestException("El descuento debe ser mayor a 0");
        User user = userRepository.findById(publicationPromotionDto.getUser_id());
        Publication publication= validateAndCreatePublication(publicationPromotionDto, user);
        publication.setHasPromo(true);
        publication.setDiscount(publicationPromotionDto.getDiscount());
        System.out.println(publicationPromotionDto.getDiscount());
        return addPublicationToRepository(publication, user);
    }

    /**
     *  Este método valida que la publicacion recibida cumpla algunos requerimientos
     * @param publication - Es la publicacion que hay que validar, (PostPromotionDTO hereda de PostDTO, es decir que se puede recibir un PostPromotionDTO)
     * @param user - Es el usuario que quiere crear la publicación, el cual hay que validar
     * @return Publication - Se devuelve la publicación ya creada (En caso de querer crear una que este en promoción, los datos se agregan luego en "addPublicationPromotion")
     */
    private Publication validateAndCreatePublication(PostDTO publication, User user){
        isValidUser(user);
        isSeller(user);
        Category category = categoryRepository.findById(publication.getCategory());
        if(category == null) throw new BadRequestException("La categoria ingresa no es válida.");
        Product product = mapper.map(publication.getProduct(), Product.class);
        if(!productRepository.productExist(product)) throw new BadRequestException("El producto no es válido.");
        return new Publication(publication.getDate(), publication.getPrice(), product, category, user.getUser_id());
    }

    /**
     * Este método agrega la publicación al repositorio y la enlaza al vendedor que la creo
     * @param publication - Es la publicación que hay que agregar
     * @param user - Es el usuario al que se le va a agregar a su lista de publicaciones la nueva publicación
     * @return PublicationDTO - Devuelve información de la publicación creada
     */
    private PublicationDTO addPublicationToRepository(Publication publication, User user) {
        if(publicationRepository.addPublication(publication)){
            ((Seller) user).addPublication(publication);
            return new PublicationDTO(publication.getDate(), mapper.map(publication.getProduct(), ProductDTO.class), publication.getCategory().getId(), publication.getPrice());
        }
        return null;
    }

    /**
     * Este método obtiene la cantidad de publicaciones con promoción que tiene un vendedor
     * @param id - Es el id del vendedor del que se desea saber la cantidad de publicaciones con promoción
     * @return UserPromoProductsDTO - Se devuelve información del vendedor y la cantidad de productos con promoción que tiene
     */
    public UserPromoProductsCountDTO promoPublicationsCount(int id){
        User user = userRepository.findById(id);
        isValidUser(user);
        isSeller(user);
        List<Publication> publicationsPromo = publicationRepository.getPublicationsPromo();
        List<Publication> userPublications = publicationsPromo.stream().filter(p -> p.getUser_id() == id).collect(Collectors.toList());
        return new UserPromoProductsCountDTO(user.getUser_id(), user.getUser_name(), userPublications.size());
    }

    /**
     * Este método obtiene un listado de las publicaciones con promoción de un vendedor
     * @param id - Es el id del vendedor del que se quiere obtener el listado
     * @return UserPostPromotionDto - Se devuelve información de el vendedor con una lista de todas sus publicacione en promoción
     */
    public UserPostPromotionDTO getPromoPublications(int id){
        User user = userRepository.findById(id);
        isValidUser(user);
        isSeller(user);
        List<Publication> promoPublications = publicationRepository.getPublicationsPromo().stream().filter(p -> p.getUser_id() == id).collect(Collectors.toList());
        List<ListedPostPromotionDTO> promoPublicationsDto = promoPublications.stream().map(p -> mapper.map(p, ListedPostPromotionDTO.class)).collect(Collectors.toList());
        return new UserPostPromotionDTO(user.getUser_id(), user.getUser_name(), promoPublicationsDto);
    }


    /**
     * Este método obtiene todas las publicaciones realizadas que tengan un producto determinado
     * @param id - Es el id del producto que deben tener las publicaciones
     * @return ListedPostDTO - Devuelve una lista con la información de los posts obtenidos
     */
    public ProductWithPostListDTO getProductPublications(int id){
        Product product = productRepository.findById(id);
        if(product == null) throw new BadRequestException("El producto no fue encontrado");
        List<Publication> publications = publicationRepository.getPublications();
        List<ListedPostDTO> publicationsDto = publications.stream().filter(p -> p.getProduct().getProduct_id() == id)
                .map(p -> mapper.map(p, ListedPostDTO.class)).collect(Collectors.toList());

        return new ProductWithPostListDTO(id, product.getProduct_name(), publicationsDto);
    }


}
