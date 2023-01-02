package com.bootcamp.be_java_hisp_w20_g4.service;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.excepcion.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.model.Category;
import com.bootcamp.be_java_hisp_w20_g4.model.Product;
import com.bootcamp.be_java_hisp_w20_g4.model.Publication;
import com.bootcamp.be_java_hisp_w20_g4.repository.ICategoryRepository;
import com.bootcamp.be_java_hisp_w20_g4.repository.IProductRepository;
import com.bootcamp.be_java_hisp_w20_g4.repository.IPublicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePublication implements  IServicePublication{

    @Autowired
    IPublicationRepository publicationRepository;
    @Autowired
    IProductRepository productRepository;
    @Autowired
    ICategoryRepository categoryRepository;


    ModelMapper mapper = new ModelMapper();

    public PublicationDTO addPublication(PostDTO publicationDto){
        Category category = categoryRepository.findById(publicationDto.getCategory());
        if(category == null) throw new BadRequestException("La categoria ingresa no es válida.");
        Product product = mapper.map(publicationDto.getProduct(), Product.class);
        if(!productRepository.productExist(product)) throw new BadRequestException("El producto no es válido.");
        Publication publication = new Publication(publicationDto.getDate(), publicationDto.getPrice(), product, category);
        if(publicationRepository.addPublication(publication)){
            return new PublicationDTO(publication.getDate(), mapper.map(publication.getProduct(), ProductDTO.class), category.getId(), publication.getPrice());
        }
        return null;
    }




}
