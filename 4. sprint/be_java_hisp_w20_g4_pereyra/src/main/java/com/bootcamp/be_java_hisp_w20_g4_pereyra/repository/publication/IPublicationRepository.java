package com.bootcamp.be_java_hisp_w20_g4_pereyra.repository.publication;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Publication;

import java.util.List;

public interface IPublicationRepository {
    boolean addPublication(Publication publication);
    List<Publication> getPublicationLastNDays(List<Integer> followedIds, int nDays);
    List<Publication> getPublicationUser(int user_id);
    List<Publication> getAllPublications();
}
