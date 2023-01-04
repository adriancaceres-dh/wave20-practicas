package com.bootcamp.be_java_hisp_w20_g4.repository.publication;

import com.bootcamp.be_java_hisp_w20_g4.model.Publication;
import com.bootcamp.be_java_hisp_w20_g4.repository.publication.IPublicationRepository;
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
import java.util.stream.Collectors;

@Repository
public class PublicationRepository implements IPublicationRepository {
    private List<Publication> publications;

    public PublicationRepository(){
        this.publications = loadPublications();
    }

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

    /**
     * Este método agrega una publicación al repositorio
     * @param publication - Es la publicación que se va a agregar
     * @return boolean - Devuelve true si la publicacion fue agregada correctamente
     */
    public boolean addPublication(Publication publication){
        try{
            publications.add(publication);
            return true;
        }catch(Exception e){
            return false;
        }

    }

    /**
     * Este método obtiene las publicaciones de los ultimos N días
     * @param followedIds - Son los ids de las personas a las que hay que buscarles las publicaciones
     * @param nDays - Es el rango de días a buscar
     * @return List<Publication> - Se devuelve la lista de publicaciones que fueron requeridas
     */
    @Override
    public List<Publication> getPublicationLastNDays(List<Integer> followedIds, int nDays) {

        return publications.stream()
                .filter(p -> followedIds.contains(p.getUser_id()))
                .filter(p -> p.getDate().isAfter(LocalDate.now().minusDays(nDays)))
                .sorted(Comparator.comparing(Publication::getDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Publication> getPublicationsWithPromo(){
        return publications.stream().filter(p -> p.isHasPromo()).collect(Collectors.toList());
    }


}
