package com.bootcamp.be_java_hisp_w20_g4_stocco.repository.publication;

import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.publication.PromoCountDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.model.Publication;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PublicationRepository implements IPublicationRepository {
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

    /**
     * Este método muestra la cantidad de productos con promoción de un determinado verndedor
     * @param user_id - Representa el id del vendedor
     * @return int - Devuelve la cantidad obtenida de productos con promoción
     */
    public int countPromos(int user_id){

        int promos = 0;
        promos = (int) publications.stream()
                .filter(p->p.getUser_id() == user_id)
                .filter(p-> p.isHasPromo())
                .count();
        return promos;

    }

    /**
     * Este método lista las publicaciones con promoción de un determinado vendedor
     * @param user_id - Representa el vendedor
     * @return List<Publication> - Retorna la lista obtenida de publicaciones con descuento
     */
    public List<Publication> promoSellerList(int user_id){
        publications.stream()
                .filter(p->p.getUser_id() == user_id)
                .collect(Collectors.toList());
        return publications;
    }

}
