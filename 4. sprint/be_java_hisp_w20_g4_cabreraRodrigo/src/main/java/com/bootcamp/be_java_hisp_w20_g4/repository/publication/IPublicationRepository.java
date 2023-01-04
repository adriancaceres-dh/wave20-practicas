package com.bootcamp.be_java_hisp_w20_g4.repository.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ListProductsInPromoDTO;
import com.bootcamp.be_java_hisp_w20_g4.model.Publication;
import com.bootcamp.be_java_hisp_w20_g4.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IPublicationRepository {
    public boolean addPublication(Publication publication);
    public List<Publication> getPublicationLastNDays(List<Integer> followedIds, int nDays);

    public List<Publication> getPublicationsWithPromo(int userId);
}
