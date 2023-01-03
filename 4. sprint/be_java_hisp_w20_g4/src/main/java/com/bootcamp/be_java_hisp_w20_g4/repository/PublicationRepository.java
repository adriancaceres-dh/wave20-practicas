package com.bootcamp.be_java_hisp_w20_g4.repository;

import com.bootcamp.be_java_hisp_w20_g4.model.Product;
import com.bootcamp.be_java_hisp_w20_g4.model.Publication;
import com.bootcamp.be_java_hisp_w20_g4.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PublicationRepository implements  IPublicationRepository{
    private List<Publication> publications = loadPublications();

    public PublicationRepository(){}

    private List<Publication> loadPublications() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:publications.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TypeReference<List<Publication>> typeRef = new TypeReference<>() {};
        List<Publication> publications = null;
        try {
            publications = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return publications;
    }

    public boolean addPublication(Publication publication){
        publications.add(publication);
        return true;
    }

    @Override
    public List<Publication> getPublicationLastNDays(List<Integer> followedIds, int nDays) {

        return publications.stream()
                .filter(p -> followedIds.contains(p.getUser_id()))
                .filter(p -> p.getDate().isAfter(LocalDate.now().minusDays(nDays)))
                .sorted(Comparator.comparing(Publication::getDate))
                .collect(Collectors.toList());
    }


}
