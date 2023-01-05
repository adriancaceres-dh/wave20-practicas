package com.bootcamp.be_java_hisp_w20_g4.service.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.ListedPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ListProductsInPromoDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.PromoProductsCountDTO;
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
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.bootcamp.be_java_hisp_w20_g4.helpers.Validators.*;
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

    public PublicationDTO addPublication(PostDTO publicationDto){
        User user =  userRepository.findById(publicationDto.getUser_id());
        isValidUser(user);
        isSeller(user);

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
    public PromoPostDTO addPromo(PromoPostDTO promoPost) {
        User user = userRepository.findById(promoPost.getUser_id());
        isValidUser(user);
        isSeller(user);
        if(promoPost.getHas_promo().equals(false)) throw new BadRequestException("No se puede agregar un producto sin promocion");
        Category category = categoryRepository.findById(promoPost.getCategory());
        isValidCategory(category);
        Product product = mapper.map(promoPost.getProduct(), Product.class);
        isValidProduct(product);
        Publication publication = new Publication(promoPost.getDate(), promoPost.getPrice(), product, category, promoPost.getUser_id(), promoPost.getHas_promo(), promoPost.getDiscount());
        if(publicationRepository.addPublication(publication)){
            ((Seller) user).addPublication(publication);
            return new PromoPostDTO(promoPost.getUser_id(), promoPost.getDate(), promoPost.getProduct(), promoPost.getCategory(), promoPost.getPrice(), promoPost.getHas_promo(), promoPost.getDiscount());
        }
        return null;
    }

    @Override
    public PromoProductsCountDTO countPromos(int userId) {
        Seller user = (Seller) userRepository.findById(userId);
        isValidUser(user);
        isSeller(user);
        int countPromos = publicationRepository.getPublicationsWithPromo(userId).size();
        return new PromoProductsCountDTO(userId, user.getUser_name(), countPromos);
    }

    @Override
    public ListProductsInPromoDTO listPromos(int userId) {
        Seller user = (Seller) userRepository.findById(userId);
        isValidUser(user);
        isSeller(user);
        List<Publication> listPromos = publicationRepository.getPublicationsWithPromo(userId);
        //List<PromoPostDTO> promoPostDTOList = listPromos.stream().map(publication -> mapper.map(publication, PromoPostDTO.class)).collect(Collectors.toList());
        List<PromoPostDTO> promoPostDTOList1 = listPromos.stream().map(publication ->
                new PromoPostDTO(
                        publication.getUser_id(),
                        publication.getDate(),
                        mapper.map(publication.getProduct(), ProductDTO.class),
                        publication.getCategory().getId(),
                        publication.getPrice(),
                        publication.isHasPromo(),
                        publication.getDiscount())).collect(Collectors.toList());
        return new ListProductsInPromoDTO(userId, user.getUser_name(), promoPostDTOList1 );
    }

    @Override
    public List<ProductDTO> listProducts() {
        List<ProductDTO> productDTOList = productRepository.listAllProducts().stream().map(product -> mapper.map(product, ProductDTO.class)).collect(Collectors.toList());
        if(productDTOList.isEmpty()) throw new NotFoundException("La lista de productos esta vacia");
        return productDTOList;
    }

}
