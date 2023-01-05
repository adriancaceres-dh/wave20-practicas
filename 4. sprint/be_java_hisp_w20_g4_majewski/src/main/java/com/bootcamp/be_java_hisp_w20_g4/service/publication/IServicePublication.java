package com.bootcamp.be_java_hisp_w20_g4.service.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostPromotionDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.ListedPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserPostPromotionDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserPromoProductsCountDTO;

import java.util.List;

public interface IServicePublication {

    ProductTwoWeeksResponseDTO getLastTwoWeeksPublications(int userId, String order);
    PublicationDTO addPublication(PostDTO publication);
    PublicationDTO addPublicationPromotion(PostPromotionDTO publicationPromotionDto);
    UserPromoProductsCountDTO promoPublicationsCount(int id);
    UserPostPromotionDTO getPromoPublications(int id);
    List<ListedPostDTO> getProductPublications(int id);
}

