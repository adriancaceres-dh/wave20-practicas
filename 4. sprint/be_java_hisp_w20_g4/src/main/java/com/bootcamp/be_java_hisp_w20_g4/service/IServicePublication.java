package com.bootcamp.be_java_hisp_w20_g4.service;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDiscountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.PublicationDiscountDTO;

public interface IServicePublication {


    public PublicationDTO addPublication(PostDTO publication);

    public PublicationDiscountDTO addPromoPublication(PostDiscountDTO postDiscountDTO, PostDTO postDTO);

}
