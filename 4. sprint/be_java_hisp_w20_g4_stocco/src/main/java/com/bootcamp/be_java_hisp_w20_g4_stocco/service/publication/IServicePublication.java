package com.bootcamp.be_java_hisp_w20_g4_stocco.service.publication;

import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.publication.PublicationDTO;

public interface IServicePublication {


    PublicationDTO addPublication(PostDTO publication);
    ProductTwoWeeksResponseDTO getLastTwoWeeksPublications(int userId, String order);

}
