package com.socialmeli.be_java_hisp_w20_g8.services.users;


import com.socialmeli.be_java_hisp_w20_g8.dto.SellerDTO;
import com.socialmeli.be_java_hisp_w20_g8.models.Person;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    PersonRepositoryImp personRepositoryImp;

    public List<Seller> getAllFollowed(int userId){
        Set<Integer> followedSellers = personRepositoryImp.getAllFollowed(userId);
        List<Seller> sellers = followedSellers.stream().map(seller_id -> personRepositoryImp.findSellerById(seller_id)).collect(Collectors.toList());
        System.out.println(sellers);
        return sellers;
    }
}
