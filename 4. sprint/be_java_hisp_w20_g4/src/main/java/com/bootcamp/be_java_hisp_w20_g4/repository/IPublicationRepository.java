package com.bootcamp.be_java_hisp_w20_g4.repository;

import com.bootcamp.be_java_hisp_w20_g4.model.Publication;
import com.bootcamp.be_java_hisp_w20_g4.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IPublicationRepository {
    public boolean addPublication(Publication publication);
    public List<Publication> getPublicationLastNDays(List<Integer> followedIds, int nDays);
}
