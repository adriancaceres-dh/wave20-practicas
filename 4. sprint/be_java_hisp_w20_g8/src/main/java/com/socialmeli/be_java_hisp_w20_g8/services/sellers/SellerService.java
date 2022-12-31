package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.dto.SellerDTO;
import com.socialmeli.be_java_hisp_w20_g8.models.Person;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SellerService implements ISellerService {
    @Autowired
    PersonRepositoryImp personRepository;

    @Override
    public Set<Integer> getFollowers(Integer userId) {
        Seller seller= (Seller) personRepository.getPersons().get("sellers").stream().filter(s -> s.getId().equals(userId));
        return seller.getFollowers();
    }
}
