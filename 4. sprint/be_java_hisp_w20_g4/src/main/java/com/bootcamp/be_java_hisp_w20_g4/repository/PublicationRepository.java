package com.bootcamp.be_java_hisp_w20_g4.repository;

import com.bootcamp.be_java_hisp_w20_g4.model.Product;
import com.bootcamp.be_java_hisp_w20_g4.model.Publication;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class PublicationRepository implements  IPublicationRepository{

    private List<Publication> publications = loadPublications();

    private List<Publication> loadPublications() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:publication.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Publication>> typeRef = new TypeReference<>() {};
        List<Publication> publications = null;
        try {
            publications = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return publications;
    }

}
