package com.bootcamp.be_java_hisp_w20_g4_stocco.repository.publication;

import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.publication.PromoCountDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.model.Publication;

import java.util.List;

public interface IPublicationRepository {
    public boolean addPublication(Publication publication);
    public List<Publication> getPublicationLastNDays(List<Integer> followedIds, int nDays);
    public int countPromos(int user_id);
    public List<Publication> promoSellerList(int user_id);
}
