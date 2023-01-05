package com.bootcamp.be_java_hisp_w20_g4.service.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PromotionPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.FilteredPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PromotionPublicationCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PromotionPublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PublicationDTO;

import java.util.List;

public interface IServicePublication {


    PublicationDTO addPublication(PostDTO publication);
    ProductTwoWeeksResponseDTO getLastTwoWeeksPublications(int userId, String order);

    PromotionPublicationDTO addPublicationWithPromo(PromotionPostDTO post);

    public PromotionPublicationCountDTO getPromoPublications(int userId);

    public List<FilteredPostDTO> getPublicationsByPrice(Double min, Double max);

}
