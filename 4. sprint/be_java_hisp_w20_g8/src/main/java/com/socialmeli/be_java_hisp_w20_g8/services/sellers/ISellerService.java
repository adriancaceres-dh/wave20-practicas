package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import java.util.Set;

public interface ISellerService<T> {
    public Set<T> getFollowers(Integer userId);

}
