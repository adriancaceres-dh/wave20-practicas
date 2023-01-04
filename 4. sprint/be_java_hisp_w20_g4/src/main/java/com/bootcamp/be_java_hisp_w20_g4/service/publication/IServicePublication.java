package com.bootcamp.be_java_hisp_w20_g4.service.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PromoPublicationCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PromoPublicationDTO;

public interface IServicePublication {


    PublicationDTO addPublication(PostDTO publication);
    ProductTwoWeeksResponseDTO getLastTwoWeeksPublications(int userId, String order);
    PromoPublicationDTO addPromoPublication(PromoPostDTO promoPostDTO);
    PromoPublicationCountDTO getCountPromoPublications(Integer userId);

}
