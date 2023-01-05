package com.bootcamp.be_java_hisp_w20_g4.repository.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.FilteredPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.model.Publication;
import com.bootcamp.be_java_hisp_w20_g4.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IPublicationRepository {
    boolean addPublication(Publication publication);
    List<Publication> getPublicationLastNDays(List<Integer> followedIds, int nDays);
    List<Publication> getPromoPublications(int userId);

    public List<Publication> getPublicationsByPrice(double min, double max);

}
